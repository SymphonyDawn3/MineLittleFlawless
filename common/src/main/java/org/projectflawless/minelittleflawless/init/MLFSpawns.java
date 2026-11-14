package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.level.entity.SpawnPlacementsRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import org.projectflawless.minelittleflawless.MLFTags;

public class MLFSpawns {
    public static void init() {
        register(MLFEntities.FLAWLESS, MLFTags.FLAWLESSES_SPAWNABLE_ON);
        register(MLFEntities.TWILIGHT, MLFTags.TWILIGHTS_SPAWNABLE_ON);
        register(MLFEntities.TRIXIE, MLFTags.TRIXIES_SPAWNABLE_ON);
        clownSpawns(MLFEntities.ARINOS);
        clownSpawns(MLFEntities.LAST_LAUGH);
        clownSpawns(MLFEntities.CHERRY_CHUCKLES);
        clownSpawns(MLFEntities.BIBBLEBOP);
        clownSpawns(MLFEntities.TRICOLOR_JUBILEE);
        register(MLFEntities.TRIXIEBELLE, MLFTags.TRIXIEBELLES_SPAWNABLE_ON);
        register(MLFEntities.SKYWISHES, MLFTags.SKYWISHES_SPAWNABLE_ON);
        register(MLFEntities.STAR_CATCHER, MLFTags.STAR_CATCHERS_SPAWNABLE_ON);
        register(MLFEntities.MARIONETTE, MLFTags.MARIONETTES_SPAWNABLE_ON);
        register(MLFEntities.JACKIE_SPECTRE, MLFTags.JACKIE_SPECTRES_SPAWNABLE_ON);

        register(MLFEntities.WISH_FULFILLMENT, (entityType, serverLevel,
                                                spawnType, pos, random)
                -> (serverLevel.getBiome(pos.below()).is(MLFTags.SPAWNS_WISH_FULFILLMENT_AT_NIGHT)
                && serverLevel.getLevel().isNight()
                && serverLevel.getMoonPhase() == 0
                && serverLevel.getBlockState(pos.below()).is(MLFTags.WISH_FULFILLMENTS_SPAWNABLE_AT_NIGHT_ON))
                || (serverLevel.getBiome(pos.below()).is(MLFTags.SPAWNS_WISH_FULFILLMENT_ALWAYS)
                && serverLevel.getBlockState(pos.below()).is(MLFTags.WISH_FULFILLMENTS_SPAWNABLE_ALWAYS_ON)));

        register(MLFEntities.FRACTURED, (entityType,
                                         serverLevelAccessor, mobSpawnType,
                                         blockPos, randomSource) ->
                serverLevelAccessor.getLevel().dimensionTypeId().equals(BuiltinDimensionTypes.OVERWORLD)
                        && Monster.isDarkEnoughToSpawn(serverLevelAccessor, blockPos, randomSource)
                        && serverLevelAccessor.getBlockState(blockPos.below()).is(MLFTags.FRACTUREDS_SPAWNABLE_ON));

        register(MLFEntities.SHAY_MEADOWS, MLFTags.SHAY_MEADOWS_SPAWNABLE_ON);
    }

    private static <T extends Mob> void register(RegistrySupplier<EntityType<T>> entityType, TagKey<Block> blockTagKey) {
        register(entityType, (entityType2, world, reason,
                              pos, random)
                -> (world.getBlockState(pos.below()).is(blockTagKey)) &&
                world.getRawBrightness(pos, 0) > 8);
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
}
