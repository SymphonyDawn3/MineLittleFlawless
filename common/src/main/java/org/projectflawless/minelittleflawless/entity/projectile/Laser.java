package org.projectflawless.minelittleflawless.entity.projectile;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Laser extends AbstractArrow implements GeoEntity {
    private static final EntityDataAccessor<Integer> LASER_COLOR = SynchedEntityData.defineId(Laser.class, EntityDataSerializers.INT);
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public Laser(EntityType<Laser> entityType, Level level) {
        super(entityType, level);
        this.setNoGravity(true);
        this.setSoundEvent(SoundEvents.EMPTY);
        if (this instanceof LifeExpiryModifier lifeExpiryModifier) {
            lifeExpiryModifier.minelittleflawless$setLifeExpiry(100);
            lifeExpiryModifier.minelittleflawless$setGrazing(false);
        }
    }

    public Laser(double x, double y, double z, Level level) {
        super(MineLittleFlawlessEntities.LASER.get(), x, y, z, level);
        this.setNoGravity(true);
        this.setSoundEvent(SoundEvents.EMPTY);
        if (this instanceof LifeExpiryModifier lifeExpiryModifier) {
            lifeExpiryModifier.minelittleflawless$setLifeExpiry(100);
            lifeExpiryModifier.minelittleflawless$setGrazing(false);
        }
    }

    public Laser(LivingEntity shooter, Level level) {
        super(MineLittleFlawlessEntities.LASER.get(), shooter, level);
        this.setNoGravity(true);
        this.setSoundEvent(SoundEvents.EMPTY);
        if (this instanceof LifeExpiryModifier lifeExpiryModifier) {
            lifeExpiryModifier.minelittleflawless$setLifeExpiry(100);
            lifeExpiryModifier.minelittleflawless$setGrazing(false);
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(LASER_COLOR, Color.ofOpaque(0xcdff7a).argbInt());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("LaserColor", this.getLaserColor().argbInt());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("LaserColor", 3)) {
            this.setLaserColor(new Color(compound.getInt("LaserColor")));
        }
    }

    public Color getLaserColor() {
        return new Color(this.getEntityData().get(LASER_COLOR));
    }

    public void setLaserColor(Color laserColor) {
        this.getEntityData().set(LASER_COLOR, laserColor.argbInt());
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        this.discard();
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
}
