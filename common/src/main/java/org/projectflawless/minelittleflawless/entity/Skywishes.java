package org.projectflawless.minelittleflawless.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.MLFTags;
import org.projectflawless.minelittleflawless.entity.geoanimations.MineLittleFlawlessAnimations;
import org.projectflawless.minelittleflawless.entity.projectile.Laser;
import org.projectflawless.minelittleflawless.init.MLFEntities;
import org.projectflawless.minelittleflawless.init.MLFSoundEvents;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.core.object.PlayState;

public class Skywishes extends TamableTamersPony implements RangedAttackMob, Shearable {
    private static final EntityDataAccessor<Boolean> IS_AIMING = SynchedEntityData.defineId(Skywishes.class, EntityDataSerializers.BOOLEAN);
    private int maxLaserAmmo = 32;
    private int maxLaserAmmoCooldown = 20;
    private int laserAmmo = maxLaserAmmo;
    private int laserAmmoCooldown = maxLaserAmmoCooldown;
    private Color laserColor = Color.ofOpaque(0xcdff7a);

    public Skywishes(EntityType<Skywishes> type, Level world) {
        super(type, world);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(IS_AIMING, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("LaserColor", this.laserColor.getColor());
        compound.putInt("LaserAmmo", this.laserAmmo);
        compound.putInt("MaxLaserAmmo", this.maxLaserAmmo);
        compound.putInt("LaserAmmoCooldown", this.laserAmmoCooldown);
        compound.putInt("MaxLaserAmmoCooldown", this.maxLaserAmmoCooldown);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("LaserColor", 3))
            this.laserColor = new Color(compound.getInt("LaserColor"));

        if (compound.contains("LaserAmmo", 3))
            this.laserAmmo = compound.getInt("LaserAmmo");

        if (compound.contains("MaxLaserAmmo", 3))
            this.maxLaserAmmo = compound.getInt("MaxLaserAmmo");

        if (compound.contains("LaserAmmoCooldown", 3))
            this.laserAmmoCooldown = compound.getInt("LaserAmmoCooldown");

        if (compound.contains("MaxLaserAmmoCooldown", 3))
            this.maxLaserAmmoCooldown = compound.getInt("MaxLaserAmmoCooldown");
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        super.registerControllers(controllers);
        controllers.add(new AnimationController<>(this, "Aiming", 3,
                state -> {
                    Skywishes skywishes = state.getAnimatable();
                    if (skywishes.isAiming()) {
                        if (skywishes.isLeftHanded()) {
                            state.setAnimation(MineLittleFlawlessAnimations.SKYWISHES_AIM_LEFT_HOOF);
                        } else {
                            state.setAnimation(MineLittleFlawlessAnimations.SKYWISHES_AIM_RIGHT_HOOF);
                        }
                        return PlayState.CONTINUE;
                    } else {
                        return PlayState.STOP;
                    }
                }));
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this, Skywishes.class));
        this.goalSelector.addGoal(4, new SkywishesRangedAttackGoal(this, 1.0, 5, 10, 4, 16));
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.COOKED_BEEF), false));
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !this.getType().equals(entityType);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(MLFSoundEvents.SKYWISHES_CLANK.get(), 0.15f, 1.0f);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return MLFSoundEvents.SKYWISHES_AMBIENT.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return MLFSoundEvents.SKYWISHES_HURT.get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return MLFSoundEvents.SKYWISHES_DEATH.get();
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        RandomSource levelRandom = level.getRandom();
        this.laserColor = Color.ofHSB(levelRandom.nextFloat(), 0.5f + (levelRandom.nextFloat() * 0.5f), 1.0f);

        if (levelRandom.nextFloat() < 0.5f) {
            this.setClothing(Clothing.SKYWISHES_DRACULA);
        }

        return super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        Skywishes skywishesBaby = MLFEntities.SKYWISHES.get().create(level, null, null, otherParent.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (skywishesBaby != null)
            skywishesBaby.finalizeSpawn(level, level.getCurrentDifficultyAt(skywishesBaby.blockPosition()), MobSpawnType.BREEDING, null, null);

        return skywishesBaby;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.COOKED_BEEF);
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemStack = sourceentity.getItemInHand(hand);
        InteractionResult result;

        if (itemStack.is(MLFTags.SKYWISHES_CLOTHING)) {
            if (this.getClothing().equals(Clothing.NONE)) {
                ResourceLocation skywishesClothing = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.HORSE_SADDLE, SoundSource.AMBIENT, 1.0f, 1.0f);
                this.usePlayerItem(sourceentity, hand, itemStack);
                this.setClothing(skywishesClothing);
            }

            result = InteractionResult.sidedSuccess(sourceentity.level().isClientSide());
        } else if (itemStack.is(Items.SHEARS)) {
            if (!this.level().isClientSide()) {
                this.shear(SoundSource.PLAYERS);
                this.gameEvent(GameEvent.SHEAR, sourceentity);
                itemStack.hurtAndBreak(1, sourceentity, player -> player.broadcastBreakEvent(hand));
                result = InteractionResult.SUCCESS;
            } else {
                result = InteractionResult.CONSUME;
            }
        } else {
            result = super.mobInteract(sourceentity, hand);
        }

        return result;
    }

    @Override
    public void shear(SoundSource source) {
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.HORSE_SADDLE, source, 1.0f, 1.0f);
        this.dropClothing();
        this.setClothing(Clothing.NONE);
    }

    @Override
    public boolean readyForShearing() {
        return !this.getClothing().equals(Clothing.NONE);
    }

    private void dropClothing() {
        ResourceLocation skywishesClothing = this.getClothing();
        this.spawnAtLocation(BuiltInRegistries.ITEM.get(skywishesClothing));
    }

    @Override
    public void performRangedAttack(LivingEntity target, float velocity) {
        double adultLaserAimingScale = 1.0;
        double babyLaserAimingScale = 0.6;

        double laserOffsetY = 0.68015625;

        laserOffsetY *= this.isBaby() ? babyLaserAimingScale : adultLaserAimingScale;

        Laser laser = new Laser(this.getX(), this.getEyeY() - laserOffsetY, this.getZ(), this.level());
        laser.setOwner(this);
        laser.setLaserColor(this.laserColor);

        double distX = target.getX() - laser.getX();
        double distY = target.getEyeY() - laser.getY();
        double distZ = target.getZ() - laser.getZ();

        laser.shoot(distX, distY, distZ, 3.0f, 2);
        this.playSound(MLFSoundEvents.LASER_BLAST.get());
        this.level().addFreshEntity(laser);

        this.laserAmmo--;
    }

    public boolean isAiming() {
        return this.getEntityData().get(IS_AIMING);
    }

    public void setAiming(boolean aiming) {
        this.getEntityData().set(IS_AIMING, aiming);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    public boolean hasAnyLaserAmmo() {
        return this.laserAmmo > 0;
    }

    public boolean isFullLaserAmmo() {
        return this.laserAmmo == this.maxLaserAmmo;
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        if (!this.isFullLaserAmmo()) {
            this.laserAmmoCooldown--;
        }

        if (this.laserAmmoCooldown < 0) {
            this.laserAmmo++;
            this.laserAmmoCooldown = this.maxLaserAmmoCooldown;
        }
    }

    public static class SkywishesRangedAttackGoal extends RangedAttackGoal {
        private final Skywishes skywishes;
        private final int minAttackRadius;

        public SkywishesRangedAttackGoal(Skywishes skywishes, double speedModifier, int attackInterval, int minAttackRadius, int maxAttackRadius) {
            this(skywishes, speedModifier, attackInterval, attackInterval, minAttackRadius, maxAttackRadius);
        }

        public SkywishesRangedAttackGoal(Skywishes skywishes, double speedModifier, int attackIntervalMin, int attackIntervalMax, int minAttackRadius, int maxAttackRadius) {
            super(skywishes, speedModifier, attackIntervalMin, attackIntervalMax, maxAttackRadius);
            this.skywishes = skywishes;
            this.minAttackRadius = minAttackRadius;
        }

        @Override
        public boolean canUse() {
            if (!this.skywishes.hasAnyLaserAmmo()) {
                return false;
            }

            LivingEntity target = this.skywishes.getTarget();

            if (target instanceof EnderMan || target instanceof EnderDragon) {
                return false;
            } else {
                return super.canUse() && this.isWithinMinimumRange(target);
            }
        }

        @Override
        public void start() {
            super.start();
            this.skywishes.setAiming(true);
            this.skywishes.playSound(MLFSoundEvents.SKYWISHES_CLANK.get(), 0.15f, 1.0f);
        }

        @Override
        public void stop() {
            super.stop();
            this.skywishes.setAiming(false);
            this.skywishes.playSound(MLFSoundEvents.SKYWISHES_CLANK.get(), 0.15f, 1.0f);
        }

        private boolean isWithinMinimumRange(LivingEntity target) {
            return this.skywishes.distanceToSqr(target) >= this.minAttackRadius * this.minAttackRadius;
        }
    }
}
