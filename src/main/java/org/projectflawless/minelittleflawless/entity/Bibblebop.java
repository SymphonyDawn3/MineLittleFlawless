package org.projectflawless.minelittleflawless.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

public class Bibblebop extends AbstractClownPony {
    public Bibblebop(EntityType<Bibblebop> type, Level world) {
        super(type, world);
        this.setStallion(true);
        this.setClothing(Clothing.BIBBLEBOP_CLOWN);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return MineLittleFlawlessSoundEvents.BIBBLEBOP_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return MineLittleFlawlessSoundEvents.BIBBLEBOP_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.BIBBLEBOP_DEATH;
    }
}
