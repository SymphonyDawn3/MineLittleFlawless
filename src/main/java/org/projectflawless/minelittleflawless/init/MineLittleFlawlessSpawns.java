package org.projectflawless.minelittleflawless.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;

public class MineLittleFlawlessSpawns {
    public static void init() {
        SpawnPlacements.register(MineLittleFlawlessEntities.FLAWLESS, SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos,
                 random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)
                        && world.getRawBrightness(pos, 0) > 8));
        SpawnPlacements.register(MineLittleFlawlessEntities.TWILIGHT, SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos,
                 random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)
                        && world.getRawBrightness(pos, 0) > 8));
        SpawnPlacements.register(MineLittleFlawlessEntities.TRIXIE, SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos,
                 random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) &&
                        world.getRawBrightness(pos, 0) > 8));
        SpawnPlacements.register(MineLittleFlawlessEntities.ARINOS, SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevel,
                                                            spawnType, pos, random)
                        -> Monster.isDarkEnoughToSpawn(serverLevel, pos, random)
                        && Mob.checkMobSpawnRules(entityType, serverLevel, spawnType, pos, random));
    }
}
