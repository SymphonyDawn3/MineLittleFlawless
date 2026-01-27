package org.projectflawless.minelittleflawless.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Arinos extends TamableTamersPony {
    public Arinos(EntityType<Arinos> type, Level world) {
        super(type, world);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, this::isFood, false));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData livingdata) {
        return super.finalizeSpawn(world, difficulty, spawnType, livingdata);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        Arinos retval = MineLittleFlawlessEntities.ARINOS.get().create(serverWorld, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (retval != null) {
            retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
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

    @SubscribeEvent
    public static void init(RegisterSpawnPlacementsEvent event) {
        event.register(MineLittleFlawlessEntities.ARINOS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, serverLevel, spawnType, pos, random)
                        -> (MobSpawnType.ignoresLightRequirements(spawnType) || Monster.isDarkEnoughToSpawn(serverLevel, pos, random))
                        && checkMobSpawnRules(entityType, serverLevel, spawnType, pos, random), RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(MineLittleFlawlessEntities.ARINOS.get(), TamableTamersPony.createAttributes().build());
    }
}
