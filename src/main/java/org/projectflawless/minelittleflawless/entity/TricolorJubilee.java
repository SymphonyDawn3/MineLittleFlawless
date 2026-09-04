package org.projectflawless.minelittleflawless.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

public class TricolorJubilee extends AbstractClownPony {
    public TricolorJubilee(EntityType<TricolorJubilee> type, Level world) {
        super(type, world);
        this.setStallion(true);
        this.setClothing(Clothing.TRICOLOR_JUBILEE_CLOWN);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return MineLittleFlawlessSoundEvents.TRICOLOR_JUBILEE_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return MineLittleFlawlessSoundEvents.TRICOLOR_JUBILEE_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.TRICOLOR_JUBILEE_DEATH;
    }
}
