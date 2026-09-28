package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.level.entity.SpawnPlacementsRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.levelgen.Heightmap;

public class MineLittleFlawlessSpawns {
    public static void init() {
        register(MineLittleFlawlessEntities.FLAWLESS);
        register(MineLittleFlawlessEntities.TWILIGHT);
        register(MineLittleFlawlessEntities.TRIXIE);
        clownSpawns(MineLittleFlawlessEntities.ARINOS);
        clownSpawns(MineLittleFlawlessEntities.LAST_LAUGH);
        clownSpawns(MineLittleFlawlessEntities.CHERRY_CHUCKLES);
        clownSpawns(MineLittleFlawlessEntities.BIBBLEBOP);
        clownSpawns(MineLittleFlawlessEntities.TRICOLOR_JUBILEE);
        register(MineLittleFlawlessEntities.TRIXIEBELLE, (entityType,
                                                          serverLevelAccessor,
                                                          mobSpawnType,
                                                          blockPos, randomSource) -> {
            BlockState blockState = serverLevelAccessor.getBlockState(blockPos.below());
            return (blockState.is(BlockTags.ANIMALS_SPAWNABLE_ON) || blockState.is(BlockTags.SAND)
                    || blockState.is(BlockTags.BASE_STONE_OVERWORLD)) &&
                    serverLevelAccessor.getRawBrightness(blockPos, 0) > 8;
        });
        wishCatcherSpawns(MineLittleFlawlessEntities.SKYWISHES);
        wishCatcherSpawns(MineLittleFlawlessEntities.STAR_CATCHER);
        register(MineLittleFlawlessEntities.MARIONETTE);

        register(MineLittleFlawlessEntities.JACKIE_SPECTRE, ((entityType,
                                                              serverLevelAccessor,
                                                              mobSpawnType, blockPos,
                                                              randomSource) -> {
            BlockState blockState = serverLevelAccessor.getBlockState(blockPos.below());
            return (blockState.is(BlockTags.ANIMALS_SPAWNABLE_ON) || blockState.is(BlockTags.SAND) || blockState.is(BlockTags.BASE_STONE_OVERWORLD)) &&
                    serverLevelAccessor.getRawBrightness(blockPos, 0) > 8;
        }));

        register(MineLittleFlawlessEntities.WISH_FULFILLMENT, (entityType, serverLevel,
                                                               spawnType, pos, random)
                -> (serverLevel.getLevel().dimensionTypeId().equals(BuiltinDimensionTypes.OVERWORLD)
                && serverLevel.getLevel().isNight()
                && serverLevel.getMoonPhase() == 0
                && serverLevel.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON))
                || (serverLevel.getLevel().dimensionTypeId().equals(BuiltinDimensionTypes.NETHER)
                && serverLevel.getBlockState(pos.below()).is(BlockTags.NYLIUM)));

        register(MineLittleFlawlessEntities.FRACTURED, (entityType,
                                                        serverLevelAccessor, mobSpawnType,
                                                        blockPos, randomSource) ->
                serverLevelAccessor.getLevel().dimensionTypeId().equals(BuiltinDimensionTypes.OVERWORLD)
                        && Monster.isDarkEnoughToSpawn(serverLevelAccessor, blockPos, randomSource)
                        && serverLevelAccessor.getBlockState(blockPos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON));
    }

    private static <T extends Mob> void register(RegistrySupplier<EntityType<T>> entityType) {
        register(entityType, (entityType2, world, reason,
                              pos, random)
                -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) &&
                world.getRawBrightness(pos, 0) > 8));
    }

    private static <E extends Mob> void register(RegistrySupplier<EntityType<E>> entityType, SpawnPlacements.SpawnPredicate<E> spawnPredicate) {
        SpawnPlacementsRegistry.register(entityType, SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, spawnPredicate);
    }

    private static <E extends Mob> void clownSpawns(RegistrySupplier<EntityType<E>> entityType) {
        register(entityType, (entityType2, serverLevel,
                                                     spawnType, pos, random)
                -> Monster.isDarkEnoughToSpawn(serverLevel, pos, random)
                && Mob.checkMobSpawnRules(entityType2, serverLevel, spawnType, pos, random));
    }

    private static <E extends Mob> void wishCatcherSpawns(RegistrySupplier<EntityType<E>> entityType) {
        register(entityType, (entityType2,
                                                        serverLevelAccessor,
                                                        mobSpawnType,
                                                        blockPos,
                                                        randomSource) -> {
            BlockState blockState = serverLevelAccessor.getBlockState(blockPos.below());
            return (blockState.is(BlockTags.ANIMALS_SPAWNABLE_ON) || blockState.is(Blocks.SNOW_BLOCK)) &&
                    serverLevelAccessor.getRawBrightness(blockPos, 0) > 8;
        });
    }
}
