package org.projectflawless.minelittleflawless.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biomes;

public class MineLittleFlawlessBiomeSpawns {
    public static void init() {
        // Flawless
        BiomeModifications.addSpawn(
                biomeSelectionContext -> true,
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT,
                MineLittleFlawlessEntities.FLAWLESS,
                1,
                4,
                4
        );

        // Twilight
        BiomeModifications.addSpawn(
                biomeSelectionContext -> true,
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT,
                MineLittleFlawlessEntities.TWILIGHT,
                1,
                4,
                4
        );

        // Trixie
        BiomeModifications.addSpawn(
                biomeSelectionContext -> true,
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT,
                MineLittleFlawlessEntities.TRIXIE,
                1,
                4,
                4
        );

        // Arinos - Overworld
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(BiomeTags.IS_OVERWORLD),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.ARINOS,
                8,
                4,
                4);

        // Arinos - End
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(BiomeTags.IS_END),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.ARINOS,
                1,
                4,
                4
        );

        // Arinos - Basalt Deltas
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.BASALT_DELTAS),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.ARINOS,
                1,
                4,
                4
        );

        // Arinos - Crimson Forest
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.CRIMSON_FOREST),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.ARINOS,
                8,
                4,
                4
        );

        // Arinos - Nether Wastes
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.NETHER_WASTES),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.ARINOS,
                1,
                4,
                4
        );

        // Arinos - Soul Sand Valley
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.SOUL_SAND_VALLEY),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.ARINOS,
                1,
                4,
                4
        );

        // Arinos - Warped Forest
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.WARPED_FOREST),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.ARINOS,
                8,
                1,
                4
        );

        // Trixiebelle
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(MineLittleFlawlessTags.SPAWNS_TRIXIEBELLE),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT,
                MineLittleFlawlessEntities.TRIXIEBELLE,
                1,
                4,
                4
        );

        // Skywishes
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(MineLittleFlawlessTags.SPAWNS_SKYWISHES),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT,
                MineLittleFlawlessEntities.SKYWISHES,
                1,
                4,
                4
        );

        // Star Catcher
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(MineLittleFlawlessTags.SPAWNS_STAR_CATCHER),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT,
                MineLittleFlawlessEntities.STAR_CATCHER,
                1,
                4,
                4
        );

        // Marionette
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(MineLittleFlawlessTags.SPAWNS_MARIONETTE),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT,
                MineLittleFlawlessEntities.MARIONETTE,
                1,
                4,
                4
        );

        // Jackie Spectre
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(MineLittleFlawlessTags.SPAWNS_JACKIE_SPECTRE),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT,
                MineLittleFlawlessEntities.JACKIE_SPECTRE,
                1,
                4,
                4
        );

        // Wish Fulfillment - Overworld
        BiomeModifications.addSpawn(
                biomeSelectionContext -> true,
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.WISH_FULFILLMENT,
                1,
                4,
                4
        );

        // Wish Fulfillment - Warped Forest
        BiomeModifications.addSpawn(biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.WARPED_FOREST),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.WISH_FULFILLMENT,
                1,
                1,
                4
        );

        // Wish Fulfillment - Crimson Forest
        BiomeModifications.addSpawn(biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.CRIMSON_FOREST),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.WISH_FULFILLMENT,
                1,
                4,
                4
        );
    }
}
