package org.projectflawless.minelittleflawless.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.init.MLFSoundEvents;

public class CherryChuckles extends AbstractClownPony {
    public CherryChuckles(EntityType<CherryChuckles> type, Level world) {
        super(type, world);
        this.setStallion(true);
        this.setClothing(Clothing.CHERRY_CHUCKLES_CLOWN);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return MLFSoundEvents.CHERRY_CHUCKLES_AMBIENT.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return MLFSoundEvents.CHERRY_CHUCKLES_HURT.get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return MLFSoundEvents.CHERRY_CHUCKLES_DEATH.get();
    }
}
