package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.level.biome.BiomeModifications;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import org.projectflawless.minelittleflawless.MLFMobCategory;
import org.projectflawless.minelittleflawless.MLFTags;

import java.util.function.Predicate;

public class MLFBiomeSpawns {
    public static void init() {
        // Flawless
        addSpawn(
                biomeContext -> biomeContext.hasTag(MLFTags.SPAWNS_FLAWLESS),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.FLAWLESS,
                1,
                4,
                4
        );

        // Twilight
        addSpawn(
                biomeContext -> biomeContext.hasTag(MLFTags.SPAWNS_TWILIGHT),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.TWILIGHT,
                1,
                4,
                4
        );

        // Trixie
        addSpawn(
                biomeContext -> biomeContext.hasTag(MLFTags.SPAWNS_TRIXIE),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT,
                MLFEntities.TRIXIE,
                1,
                4,
                4
        );

        // Arinos
        clownBiomeSpawns(MLFEntities.ARINOS, MLFTags.SPAWNS_ARINOS);
        
        // Last Laugh
        clownBiomeSpawns(MLFEntities.LAST_LAUGH, MLFTags.SPAWNS_LAST_LAUGH);
        
        // Cherry Chuckles
        clownBiomeSpawns(MLFEntities.CHERRY_CHUCKLES, MLFTags.SPAWNS_CHERRY_CHUCKLES);

        // Bibblebop
        clownBiomeSpawns(MLFEntities.BIBBLEBOP, MLFTags.SPAWNS_BIBBLEBOP);

        // Tricolor Jubilee
        clownBiomeSpawns(MLFEntities.TRICOLOR_JUBILEE, MLFTags.SPAWNS_TRICOLOR_JUBILEE);

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

        // Wish Fulfillment
        addSpawn(
                biomeContext -> biomeContext.hasTag(MLFTags.SPAWNS_WISH_FULFILLMENT),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                MLFEntities.WISH_FULFILLMENT,
                5,
                4,
                4
        );

        // Fractured
        addSpawn(
                biomeContext -> biomeContext.hasTag(MLFTags.SPAWNS_FRACTURED),
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
    
    public static <E extends Entity> void clownBiomeSpawns(RegistrySupplier<EntityType<E>> entityType, TagKey<Biome> biomeTagKey) {
        addSpawn(
                biomeContext -> biomeContext.hasTag(biomeTagKey),
                MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT,
                entityType,
                8,
                4,
                4);
    }

    private static <E extends Entity> void addSpawn(Predicate<BiomeModifications.BiomeContext> predicate, MLFMobCategory category, RegistrySupplier<EntityType<E>> entityType, int weight, int minGroupSize, int maxGroupSize) {
        BiomeModifications.addProperties(predicate, (biomeContext, mutable) -> mutable.getSpawnProperties().addSpawn(
                MLFMobCategory.getCategory(category), new MobSpawnSettings.SpawnerData(entityType.get(), weight, minGroupSize, maxGroupSize)
        ));
    }
}
