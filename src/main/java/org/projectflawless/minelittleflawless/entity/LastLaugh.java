package org.projectflawless.minelittleflawless.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

public class LastLaugh extends AbstractClownPony {
    public LastLaugh(EntityType<LastLaugh> type, Level world) {
        super(type, world);
        this.setStallion(true);
        this.setClothing(Clothing.LAST_LAUGH_CLOWN);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return MineLittleFlawlessSoundEvents.LAST_LAUGH_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return MineLittleFlawlessSoundEvents.LAST_LAUGH_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.LAST_LAUGH_DEATH;
    }
}
