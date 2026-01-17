package org.projectflawless.minelittleflawless.entity;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;

@EventBusSubscriber
public class Twilight extends TamableAnimal {
    public Twilight(EntityType<Twilight> type, Level world) {
        super(type, world);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new BreedGoal(this, 1));
        this.goalSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Monster.class, false, false));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, (float) 6));
        this.goalSelector.addGoal(7, new FollowOwnerGoal(this, 1, (float) 10, (float) 2));
        this.goalSelector.addGoal(8, new TemptGoal(this, 1, itemstack -> itemstack.is(Items.BOOK), false));
        this.goalSelector.addGoal(9, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(11, new FloatGoal(this));
    }

    @Override
    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cat.ambient"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cat.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cat.death"));
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.getItemInHand(hand);
        InteractionResult retval = InteractionResult.PASS;

        if (this.isFood(itemstack) || itemstack.is(ItemTags.create(ResourceLocation.parse("minelittleflawless:flawless_food")))) {
            if (this.isTame() && this.isOwnedBy(sourceentity)) {
                if (this.getHealth() < this.getMaxHealth()) {
                    FoodProperties foodproperties = itemstack.get(DataComponents.FOOD);
                    float nutrition = foodproperties != null ? (float) foodproperties.nutrition() * 10 : 1;
                    this.heal(nutrition);
                    this.usePlayerItem(sourceentity, hand, itemstack);
                    retval = InteractionResult.SUCCESS;
                } else {
                    retval = super.mobInteract(sourceentity, hand);
                }
            } else if (this.isFood(itemstack)) {
                this.usePlayerItem(sourceentity, hand, itemstack);
                if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceentity)) {
                    this.tame(sourceentity);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6);
                }
                this.setPersistenceRequired();
                retval = InteractionResult.SUCCESS;
            }
        } else {
            retval = super.mobInteract(sourceentity, hand);
            if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
                this.setPersistenceRequired();
        }

        return retval;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        Twilight retval = MineLittleFlawlessEntities.TWILIGHT.get().create(serverWorld, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);
        if (retval != null) {
            retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
        }
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.BOOK);
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !(this.getType() == entityType);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 200);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 15);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder;
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(MineLittleFlawlessEntities.TWILIGHT.get(), createAttributes().build());
    }
}
