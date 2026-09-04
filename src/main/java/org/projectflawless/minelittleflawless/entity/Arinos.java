package org.projectflawless.minelittleflawless.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

public class Arinos extends AbstractClownPony {
    public Arinos(EntityType<Arinos> type, Level world) {
        super(type, world);
        this.setAlicorn(true);
        this.setClothing(Clothing.JESTER);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return MineLittleFlawlessSoundEvents.ARINOS_AMBIENT;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return MineLittleFlawlessSoundEvents.ARINOS_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.ARINOS_DEATH;
    }
}
