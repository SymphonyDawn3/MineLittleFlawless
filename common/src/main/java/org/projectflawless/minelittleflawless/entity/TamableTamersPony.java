package org.projectflawless.minelittleflawless.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.MineLittleFlawlessTags;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public abstract class TamableTamersPony extends TamableAnimal implements GeoEntity {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<String> DATA_CLOTHING = SynchedEntityData.defineId(TamableTamersPony.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Boolean> IS_STALLION = SynchedEntityData.defineId(TamableTamersPony.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_UNICORN = SynchedEntityData.defineId(TamableTamersPony.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_PEGASUS = SynchedEntityData.defineId(TamableTamersPony.class, EntityDataSerializers.BOOLEAN);

    public TamableTamersPony(EntityType<? extends TamableTamersPony> type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Walking", 3,
                state -> {
                    if (this.isInSittingPose() || (this.getVehicle() != null)) {
                        state.setControllerSpeed(1.0f);
                        state.setAnimation(DefaultAnimations.SIT);
                        return PlayState.CONTINUE;
                    } else if (state.isMoving()) {
                        state.setControllerSpeed(this.walkAnimation.speed() * (this.isBaby() ? 6.0f : 2.0f));
                        state.setAnimation(DefaultAnimations.WALK);
                        return PlayState.CONTINUE;
                    } else {
                        state.setAnimation(DefaultAnimations.IDLE);
                        return PlayState.CONTINUE;
                    }
                }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(DATA_CLOTHING, Clothing.NONE.toString());
        this.getEntityData().define(IS_STALLION, false);
        this.getEntityData().define(IS_UNICORN, false);
        this.getEntityData().define(IS_PEGASUS, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

        compound.putString("clothing", this.getClothing().toString());

        CompoundTag ponyData = new CompoundTag();
        ponyData.putBoolean("Stallion", this.isStallion());
        ponyData.putBoolean("Unicorn", this.isUnicorn());
        ponyData.putBoolean("Pegasus", this.isPegasus());
        compound.put("PonyData", ponyData);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        if (compound.contains("clothing"))
            this.setClothing(ResourceLocation.tryParse(compound.getString("clothing")));

        if (compound.contains("PonyData")) {
            CompoundTag ponyData = compound.getCompound("PonyData");
            this.setStallion(ponyData.getBoolean("Stallion"));
            this.setUnicorn(ponyData.getBoolean("Unicorn"));
            this.setPegasus(ponyData.getBoolean("Pegasus"));
        }
    }

    @Override
    public float getScale() {
        return this.isBaby() ? 0.4f : 1.0f;
    }

    public ResourceLocation getClothing() {
        return ResourceLocation.tryParse(this.getEntityData().get(DATA_CLOTHING));
    }

    public void setClothing(ResourceLocation clothing) {
        this.getEntityData().set(DATA_CLOTHING, clothing.toString());
    }

    public boolean isStallion() {
        return this.getEntityData().get(IS_STALLION);
    }

    public boolean isUnicorn() {
        return this.getEntityData().get(IS_UNICORN);
    }

    public boolean isPegasus() {
        return this.getEntityData().get(IS_PEGASUS);
    }

    public boolean isAlicorn() {
        return this.isUnicorn() && this.isPegasus();
    }

    public void setStallion(boolean toggle) {
        this.getEntityData().set(IS_STALLION, toggle);
    }

    public void setUnicorn(boolean toggle) {
        this.getEntityData().set(IS_UNICORN, toggle);
    }

    public void setPegasus(boolean toggle) {
        this.getEntityData().set(IS_PEGASUS, toggle);
    }

    public void setAlicorn(boolean toggle) {
        this.setUnicorn(toggle);
        this.setPegasus(toggle);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1, TamableTamersPony.class));
        this.goalSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new OwnerHurtTargetGoal(this));
        // A compromise when non-tamed ponies shouldn't attack raiders during raids to make the Hero of the Village
        // advancement possible, as written in FlawlessEvents:init()
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, LivingEntity.class, false, targetPredicate -> {
            if (targetPredicate instanceof Raider raider && raider.getCurrentRaid() != null && !this.isTame())
                return false;
            else
                return targetPredicate instanceof Enemy;
        }));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, (float) 6));
        this.goalSelector.addGoal(7, new TamableTamersPonyFollowParentGoal(this, 1));
        this.goalSelector.addGoal(8, new FollowOwnerGoal(this, 1, (float) 10, (float) 2, false));
        this.goalSelector.addGoal(10, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(12, new FloatGoal(this));
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.getItemInHand(hand);
        InteractionResult retval = InteractionResult.PASS;

        if (this.isFood(itemstack) || itemstack.is(MineLittleFlawlessTags.FLAWLESS_FOOD)) {
            if (this.isTame() && this.isOwnedBy(sourceentity)) {
                if (this.getHealth() < this.getMaxHealth()) {
                    FoodProperties foodproperties = itemstack.getItem().getFoodProperties();
                    float nutrition = foodproperties != null ? (float) foodproperties.getNutrition() * 10 : 1;
                    this.heal(nutrition);
                    this.usePlayerItem(sourceentity, hand, itemstack);
                    retval = InteractionResult.SUCCESS;
                } else {
                    retval = super.mobInteract(sourceentity, hand);
                }
            } else if (this.isFood(itemstack)) {
                this.usePlayerItem(sourceentity, hand, itemstack);
                if (this.random.nextInt(3) == 0) {
                    this.tame(sourceentity);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                    this.onTameSuccess(sourceentity, hand);
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6);
                }
                this.setPersistenceRequired();
                retval = InteractionResult.SUCCESS;
            }
        } else if (!this.level().isClientSide() && hand == InteractionHand.MAIN_HAND && itemstack.isEmpty() && this.isTame() && this.isOwnedBy(sourceentity)) {
            this.setOrderedToSit(!this.isOrderedToSit());

            retval = InteractionResult.SUCCESS;
        } else {
            retval = super.mobInteract(sourceentity, hand);
            if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
                this.setPersistenceRequired();
        }

        return retval;
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        // Check if this mob is tamable and has the same owner as the attacking mob.
        if (target instanceof TamableAnimal tamableTarget) {
            if (tamableTarget.isTame())
                return tamableTarget.getOwner() != this.getOwner();
            else
                return super.canAttack(tamableTarget);
        } else {
            return super.canAttack(target);
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 200);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 15);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        return builder;
    }

    protected void onTameSuccess(Player player, InteractionHand hand) {

    }

    public static class TamableTamersPonyFollowParentGoal extends FollowParentGoal {
        private final TamableTamersPony tamableTamersPony;

        public TamableTamersPonyFollowParentGoal(TamableTamersPony tamableTamersPony, double speedModifier) {
            super(tamableTamersPony, speedModifier);
            this.tamableTamersPony = tamableTamersPony;
        }

        @Override
        public boolean canUse() {
            return !this.tamableTamersPony.isInSittingPose() && super.canUse();
        }
    }
}
