package org.projectflawless.minelittleflawless.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

public class MineLittleFlawlessTags {
    public static TagKey<Biome> SPAWNS_TRIXIEBELLE = TagKey.create(Registries.BIOME,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "spawns_trixiebelle"));

    public static void init() {

    }
}
