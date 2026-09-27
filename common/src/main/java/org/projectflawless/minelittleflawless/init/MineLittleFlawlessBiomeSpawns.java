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
import org.projectflawless.minelittleflawless.MineLittleFlawlessMobCategory;
import org.projectflawless.minelittleflawless.MineLittleFlawlessTags;

import java.util.function.Predicate;

public class MineLittleFlawlessBiomeSpawns {
    public static void init() {
        // Flawless
        addSpawn(
                biomeContext -> true,
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MineLittleFlawlessEntities.FLAWLESS,
                1,
                4,
                4
        );

        // Twilight
        addSpawn(
                biomeContext -> true,
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MineLittleFlawlessEntities.TWILIGHT,
                1,
                4,
                4
        );

        // Trixie
        addSpawn(
                biomeContext -> true,
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MineLittleFlawlessEntities.TRIXIE,
                1,
                4,
                4
        );

        // Arinos
        clownBiomeSpawns(MineLittleFlawlessEntities.ARINOS);
        
        // Last Laugh
        clownBiomeSpawns(MineLittleFlawlessEntities.LAST_LAUGH);
        
        // Cherry Chuckles
        clownBiomeSpawns(MineLittleFlawlessEntities.CHERRY_CHUCKLES);

        // Bibblebop
        clownBiomeSpawns(MineLittleFlawlessEntities.BIBBLEBOP);

        // Tricolor Jubilee
        clownBiomeSpawns(MineLittleFlawlessEntities.TRICOLOR_JUBILEE);

        // Trixiebelle
        addSpawn(
                biomeContext -> biomeContext.hasTag(MineLittleFlawlessTags.SPAWNS_TRIXIEBELLE),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MineLittleFlawlessEntities.TRIXIEBELLE,
                1,
                4,
                4
        );

        // Skywishes
        addSpawn(
                biomeContext -> biomeContext.hasTag(MineLittleFlawlessTags.SPAWNS_SKYWISHES),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MineLittleFlawlessEntities.SKYWISHES,
                1,
                4,
                4
        );

        // Star Catcher
        addSpawn(
                biomeContext -> biomeContext.hasTag(MineLittleFlawlessTags.SPAWNS_STAR_CATCHER),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MineLittleFlawlessEntities.STAR_CATCHER,
                1,
                4,
                4
        );

        // Marionette
        addSpawn(
                biomeContext -> biomeContext.hasTag(MineLittleFlawlessTags.SPAWNS_MARIONETTE),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MineLittleFlawlessEntities.MARIONETTE,
                1,
                4,
                4
        );

        // Jackie Spectre
        addSpawn(
                biomeContext -> biomeContext.hasTag(MineLittleFlawlessTags.SPAWNS_JACKIE_SPECTRE),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MineLittleFlawlessEntities.JACKIE_SPECTRE,
                1,
                4,
                4
        );

        // Wish Fulfillment - Overworld
        addSpawn(
                biomeContext -> true,
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.WISH_FULFILLMENT,
                5,
                4,
                4
        );

        // Wish Fulfillment - Warped Forest
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.WARPED_FOREST),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.WISH_FULFILLMENT,
                5,
                1,
                4
        );

        // Wish Fulfillment - Crimson Forest
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.CRIMSON_FOREST),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.WISH_FULFILLMENT,
                5,
                4,
                4
        );

        // Fractured
        addSpawn(
                biomeContext -> true,
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.FRACTURED,
                5,
                1,
                4
        );
    }
    
    public static <E extends Entity> void clownBiomeSpawns(RegistrySupplier<EntityType<E>> entityType) {
        // Overworld
        addSpawn(
                biomeContext -> biomeContext.hasTag(BiomeTags.IS_OVERWORLD),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4);

        // End
        addSpawn(
                biomeContext -> biomeContext.hasTag(BiomeTags.IS_END),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Basalt Deltas
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.BASALT_DELTAS),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Crimson Forest
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.CRIMSON_FOREST),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Nether Wastes
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.NETHER_WASTES),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Soul Sand Valley
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.SOUL_SAND_VALLEY),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                1,
                4
        );

        // Warped Forest
        addSpawn(
                biomeContext -> isBiome(biomeContext, Biomes.WARPED_FOREST),
                MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                1,
                4
        );
    }

    private static <E extends Entity> void addSpawn(Predicate<BiomeModifications.BiomeContext> predicate, MineLittleFlawlessMobCategory category, RegistrySupplier<EntityType<E>> entityType, int weight, int minGroupSize, int maxGroupSize) {
        BiomeModifications.addProperties(predicate, (biomeContext, mutable) -> mutable.getSpawnProperties().addSpawn(
                MineLittleFlawlessMobCategory.getCategory(category), new MobSpawnSettings.SpawnerData(entityType.get(), weight, minGroupSize, maxGroupSize)
        ));
    }

    private static boolean isBiome(BiomeModifications.BiomeContext biomeContext, ResourceKey<Biome> biomeResourceKey) {
        return biomeContext.getKey().orElseThrow().equals(biomeResourceKey.location());
    }
}
