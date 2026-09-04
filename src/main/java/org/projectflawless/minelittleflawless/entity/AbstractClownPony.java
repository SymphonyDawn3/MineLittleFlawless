package org.projectflawless.minelittleflawless.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;
import org.projectflawless.minelittleflawless.MineLittleFlawlessTags;

public class AbstractClownPony extends TamableTamersPony {
    public AbstractClownPony(EntityType<? extends AbstractClownPony> type, Level world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.COOKIE), false));
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        AbstractClownPony babyClown = (AbstractClownPony) this.getType().create(level, null, null, otherParent.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (babyClown != null) {
            babyClown.finalizeSpawn(level, level.getCurrentDifficultyAt(babyClown.blockPosition()), MobSpawnType.BREEDING, null, null);
        }

        return babyClown;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return true;
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
        this.playSound(MineLittleFlawlessSoundEvents.CLOWN_PONY_JINGLE, 0.15f, 1.0f);
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !entityType.is(MineLittleFlawlessTags.CLOWN_COLLEGE);
    }
}
