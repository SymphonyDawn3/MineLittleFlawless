package org.projectflawless.minelittleflawless.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.projectflawless.minelittleflawless.init.MLFEntities;
import org.projectflawless.minelittleflawless.init.MLFSoundEvents;
import org.projectflawless.minelittleflawless.MLFTags;

public class Twilight extends TamableTamersPony {
    public Twilight(EntityType<Twilight> type, Level world) {
        super(type, world);
        this.setUnicorn(true);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.BOOK), false));
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !(entityType.is(MLFTags.SPARKLEMOON_FAMILY));
    }

    @Override
    public SoundEvent getAmbientSound() {
        return MLFSoundEvents.TWILIGHT_AMBIENT.get();
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return MLFSoundEvents.TWILIGHT_HURT.get();
    }

    @Override
    public SoundEvent getDeathSound() {
        return MLFSoundEvents.TWILIGHT_DEATH.get();
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        TamableTamersPony retval;

        if (ageable instanceof Trixie)
            retval = MLFEntities.FLAWLESS.get().create(serverWorld, null, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);
        else
            retval = MLFEntities.TWILIGHT.get().create(serverWorld, null, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (retval != null) {
            retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        }
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.BOOK);
    }

    @Override
    public boolean canMate(Animal otherAnimal) {
        if ((otherAnimal == this) || (otherAnimal instanceof Flawless))
            return false;

        return this.isInLove() && otherAnimal.isInLove();
    }
}
