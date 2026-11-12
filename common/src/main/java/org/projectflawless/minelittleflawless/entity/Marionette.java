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
import org.projectflawless.minelittleflawless.init.MLFEntities;
import org.projectflawless.minelittleflawless.init.MLFSoundEvents;
import org.projectflawless.minelittleflawless.MLFTags;

public class Marionette extends TamableTamersPony {
    public Marionette(EntityType<Marionette> type, Level world) {
        super(type, world);
        this.setClothing(Clothing.MASK);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.SWEET_BERRIES), false));
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !entityType.is(MLFTags.SPARKLEMOON_FAMILY);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return MLFSoundEvents.MARIONETTE_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return MLFSoundEvents.MARIONETTE_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return MLFSoundEvents.MARIONETTE_DEATH.get();
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        Marionette babyMarionette = MLFEntities.MARIONETTE.get().create(level, null, null,
                otherParent.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (babyMarionette != null)
            babyMarionette.finalizeSpawn(level, level.getCurrentDifficultyAt(babyMarionette.blockPosition()),
                    MobSpawnType.BREEDING, null, null);

        return babyMarionette;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.SWEET_BERRIES);
    }
}
