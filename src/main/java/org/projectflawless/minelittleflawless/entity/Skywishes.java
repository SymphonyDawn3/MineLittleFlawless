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
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

public class Skywishes extends TamableTamersPony {
    public Skywishes(EntityType<Skywishes> type, Level world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.COOKED_BEEF), false));
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !this.getType().equals(entityType);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return MineLittleFlawlessSoundEvents.SKYWISHES_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return MineLittleFlawlessSoundEvents.SKYWISHES_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.SKYWISHES_DEATH;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        Skywishes skywishesBaby = MineLittleFlawlessEntities.SKYWISHES.create(level, null, null, otherParent.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (skywishesBaby != null)
            skywishesBaby.finalizeSpawn(level, level.getCurrentDifficultyAt(skywishesBaby.blockPosition()), MobSpawnType.BREEDING, null, null);

        return skywishesBaby;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.COOKED_BEEF);
    }
}
