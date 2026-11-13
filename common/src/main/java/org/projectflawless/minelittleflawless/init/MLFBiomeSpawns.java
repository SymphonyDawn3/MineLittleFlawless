package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.level.biome.BiomeModifications;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import org.projectflawless.minelittleflawless.MLFMobCategory;
import org.projectflawless.minelittleflawless.MLFTags;

import java.util.function.Predicate;

public class MLFBiomeSpawns {
    public static void init() {
        // Flawless
        addSpawn(
                biomeContext -> true,
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.FLAWLESS,
                1,
                4,
                4
        );

        // Twilight
        addSpawn(
                biomeContext -> true,
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.TWILIGHT,
                1,
                4,
                4
        );

        // Trixie
        addSpawn(
                biomeContext -> true,
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.TRIXIE,
                1,
                4,
                4
        );

        // Arinos
        clownBiomeSpawns(MLFEntities.ARINOS);
        
        // Last Laugh
        clownBiomeSpawns(MLFEntities.LAST_LAUGH);
        
        // Cherry Chuckles
        clownBiomeSpawns(MLFEntities.CHERRY_CHUCKLES);

        // Bibblebop
        clownBiomeSpawns(MLFEntities.BIBBLEBOP);

        // Tricolor Jubilee
        clownBiomeSpawns(MLFEntities.TRICOLOR_JUBILEE);

        // Trixiebelle
        addSpawn(
                biomeContext -> biomeContext.hasTag(MLFTags.SPAWNS_TRIXIEBELLE),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.TRIXIEBELLE,
                1,
                4,
                4
        );

        // Skywishes
        addSpawn(
                biomeContext -> biomeContext.hasTag(MLFTags.SPAWNS_SKYWISHES),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.SKYWISHES,
                1,
                4,
                4
        );

        // Star Catcher
        addSpawn(
                biomeContext -> biomeContext.hasTag(MLFTags.SPAWNS_STAR_CATCHER),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.STAR_CATCHER,
                1,
                4,
                4
        );

        // Marionette
        addSpawn(
                biomeContext -> biomeContext.hasTag(MLFTags.SPAWNS_MARIONETTE),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.MARIONETTE,
                1,
                4,
                4
        );

        // Jackie Spectre
        addSpawn(
                biomeContext -> biomeContext.hasTag(MLFTags.SPAWNS_JACKIE_SPECTRE),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.JACKIE_SPECTRE,
                1,
                4,
                4
        );

        // Wish Fulfillment - Overworld
        addSpawn(
                biomeContext -> true,
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                MLFEntities.WISH_FULFILLMENT,
                5,
                4,
                4
        );

        // Wish Fulfillment - Warped Forest
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.WARPED_FOREST),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                MLFEntities.WISH_FULFILLMENT,
                5,
                1,
                4
        );

        // Wish Fulfillment - Crimson Forest
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.CRIMSON_FOREST),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                MLFEntities.WISH_FULFILLMENT,
                5,
                4,
                4
        );

        // Fractured
        addSpawn(
                biomeContext -> true,
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                MLFEntities.FRACTURED,
                5,
                1,
                4
        );

        // Shay Meadows
        addSpawn(
                biomeContext -> biomeContext.hasTag(MLFTags.SPAWNS_SHAY_MEADOWS),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.SHAY_MEADOWS,
                1,
                4,
                4
        );
    }
    
    public static <E extends Entity> void clownBiomeSpawns(RegistrySupplier<EntityType<E>> entityType) {
        // Overworld
        addSpawn(
                biomeContext -> biomeContext.hasTag(BiomeTags.IS_OVERWORLD),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4);

        // End
        addSpawn(
                biomeContext -> biomeContext.hasTag(BiomeTags.IS_END),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Basalt Deltas
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.BASALT_DELTAS),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Crimson Forest
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.CRIMSON_FOREST),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Nether Wastes
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.NETHER_WASTES),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Soul Sand Valley
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.SOUL_SAND_VALLEY),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                1,
                4
        );

        // Warped Forest
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.WARPED_FOREST),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                1,
                4
        );
    }

    private static <E extends Entity> void addSpawn(Predicate<BiomeModifications.BiomeContext> predicate, MLFMobCategory category, RegistrySupplier<EntityType<E>> entityType, int weight, int minGroupSize, int maxGroupSize) {
        BiomeModifications.addProperties(predicate, (biomeContext, mutable) -> mutable.getSpawnProperties().addSpawn(
                MLFMobCategory.getCategory(category), new MobSpawnSettings.SpawnerData(entityType.get(), weight, minGroupSize, maxGroupSize)
        ));
    }

    private static boolean isBiome(BiomeModifications.BiomeContext biomeContext, ResourceKey<Biome> biomeResourceKey) {
        return biomeContext.getKey().orElseThrow().equals(biomeResourceKey.location());
    }
}
