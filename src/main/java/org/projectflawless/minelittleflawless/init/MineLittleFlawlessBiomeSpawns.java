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
                MobCategory.CREATURE,
                MineLittleFlawlessEntities.FLAWLESS,
                20,
                4,
                4
        );

        // Twilight
        BiomeModifications.addSpawn(
                biomeSelectionContext -> true,
                MobCategory.CREATURE,
                MineLittleFlawlessEntities.TWILIGHT,
                20,
                4,
                4
        );

        // Trixie
        BiomeModifications.addSpawn(
                biomeSelectionContext -> true,
                MobCategory.CREATURE,
                MineLittleFlawlessEntities.TRIXIE,
                20,
                4,
                4
        );

        // Arinos - Overworld
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(BiomeTags.IS_OVERWORLD),
                MobCategory.MONSTER,
                MineLittleFlawlessEntities.ARINOS,
                95,
                4,
                4);

        // Arinos - End
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(BiomeTags.IS_END),
                MobCategory.MONSTER,
                MineLittleFlawlessEntities.ARINOS,
                1,
                4,
                4
        );

        // Arinos - Basalt Deltas
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.BASALT_DELTAS),
                MobCategory.MONSTER,
                MineLittleFlawlessEntities.ARINOS,
                26,
                4,
                4
        );

        // Arinos - Crimson Forest
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.CRIMSON_FOREST),
                MobCategory.MONSTER,
                MineLittleFlawlessEntities.ARINOS,
                3,
                4,
                4
        );

        // Arinos - Nether Wastes
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.NETHER_WASTES),
                MobCategory.MONSTER,
                MineLittleFlawlessEntities.ARINOS,
                31,
                4,
                4
        );

        // Arinos - Soul Sand Valley
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.SOUL_SAND_VALLEY),
                MobCategory.MONSTER,
                MineLittleFlawlessEntities.ARINOS,
                13,
                4,
                4
        );

        // Arinos - Warped Forest
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(Biomes.WARPED_FOREST),
                MobCategory.MONSTER,
                MineLittleFlawlessEntities.ARINOS,
                1,
                1,
                4
        );

        // Trixiebelle
        BiomeModifications.addSpawn(
                biomeSelectionContext -> biomeSelectionContext.hasTag(MineLittleFlawlessTags.SPAWNS_TRIXIEBELLE),
                MobCategory.CREATURE,
                MineLittleFlawlessEntities.TRIXIEBELLE,
                20,
                4,
                4
        );
    }
}
