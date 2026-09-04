package org.projectflawless.minelittleflawless.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
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
                5,
                4,
                4
        );

        // Wish Fulfillment - Warped Forest
        BiomeModifications.addSpawn(biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.WARPED_FOREST),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.WISH_FULFILLMENT,
                5,
                1,
                4
        );

        // Wish Fulfillment - Crimson Forest
        BiomeModifications.addSpawn(biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.CRIMSON_FOREST),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                MineLittleFlawlessEntities.WISH_FULFILLMENT,
                5,
                4,
                4
        );
    }
    
    public static void clownBiomeSpawns(EntityType<?> entityType) {
        // Overworld
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(BiomeTags.IS_OVERWORLD),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4);

        // End
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(BiomeTags.IS_END),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Basalt Deltas
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.BASALT_DELTAS),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Crimson Forest
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.CRIMSON_FOREST),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Nether Wastes
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.NETHER_WASTES),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT, 
                entityType,
                8,
                4,
                4
        );

        // Soul Sand Valley
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.SOUL_SAND_VALLEY),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4
        );

        // Warped Forest
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.WARPED_FOREST),
                MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT,
                entityType,
                8,
                1,
                4
        );
    }
}
