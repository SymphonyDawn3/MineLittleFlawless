package org.projectflawless.minelittleflawless.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;

public class MineLittleFlawlessSpawns {
    public static void init() {
        register(MineLittleFlawlessEntities.FLAWLESS);
        register(MineLittleFlawlessEntities.TWILIGHT);
        register(MineLittleFlawlessEntities.TRIXIE);
        register(MineLittleFlawlessEntities.ARINOS, (entityType, serverLevel,
                                                     spawnType, pos, random)
                -> Monster.isDarkEnoughToSpawn(serverLevel, pos, random)
                && Mob.checkMobSpawnRules(entityType, serverLevel, spawnType, pos, random));
        register(MineLittleFlawlessEntities.TRIXIEBELLE, (entityType,
                                                          serverLevelAccessor,
                                                          mobSpawnType,
                                                          blockPos, randomSource) -> {
            BlockState blockState = serverLevelAccessor.getBlockState(blockPos.below());
            return (blockState.is(BlockTags.ANIMALS_SPAWNABLE_ON) || blockState.is(BlockTags.SAND)
                    || blockState.is(BlockTags.BASE_STONE_OVERWORLD)) &&
                    serverLevelAccessor.getRawBrightness(blockPos, 0) > 8;
        });
        register(MineLittleFlawlessEntities.STAR_CATCHER);
        register(MineLittleFlawlessEntities.MARIONETTE);
    }

    private static void register(EntityType<? extends Mob> entityType) {
        register(entityType, (entityType2, world, reason,
                              pos, random)
                -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) &&
                world.getRawBrightness(pos, 0) > 8));
    }

    private static <E extends Mob> void register(EntityType<E> entityType, SpawnPlacements.SpawnPredicate<E> spawnPredicate) {
        SpawnPlacements.register(entityType, SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, spawnPredicate);
    }
}
