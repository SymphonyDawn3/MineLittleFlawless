package org.projectflawless.minelittleflawless.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

public class Arinos extends TamableTamersPony {
    public Arinos(EntityType<Arinos> type, Level world) {
        super(type, world);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.COOKIE), false));
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

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !this.getType().equals(entityType);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag dataTag) {
        this.setAlicorn(true);
        return super.finalizeSpawn(world, difficulty, spawnType, livingdata, dataTag);
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return true;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        Arinos retval = MineLittleFlawlessEntities.ARINOS.create(serverWorld, null, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (retval != null) {
            retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        }
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.COOKIE);
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader level) {
        return -level.getPathfindingCostFromLightLevels(pos);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(MineLittleFlawlessSoundEvents.ARINOS_JINGLE, 0.15f, 1.0f);
    }
}
