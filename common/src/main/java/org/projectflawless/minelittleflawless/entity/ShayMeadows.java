package org.projectflawless.minelittleflawless.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.init.MLFSoundEvents;

public class ShayMeadows extends TamableTamersPony {
    public ShayMeadows(EntityType<ShayMeadows> type, Level world) {
        super(type, world);
        this.setClothing(Clothing.SHAY_MEADOWS_FARMER);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.GLOW_BERRIES), false));
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        ShayMeadows babyShayMeadows = (ShayMeadows) this.getType().create(level, null, null, otherParent.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (babyShayMeadows != null) {
            babyShayMeadows.finalizeSpawn(level, level.getCurrentDifficultyAt(babyShayMeadows.blockPosition()), MobSpawnType.BREEDING, null, null);
        }

        return babyShayMeadows;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.GLOW_BERRIES);
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !this.getType().equals(entityType);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return MLFSoundEvents.SHAY_MEADOWS_AMBIENT.get();
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return MLFSoundEvents.SHAY_MEADOWS_HURT.get();
    }

    @Override
    public SoundEvent getDeathSound() {
        return MLFSoundEvents.SHAY_MEADOWS_DEATH.get();
    }
}
