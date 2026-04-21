package org.projectflawless.minelittleflawless.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

public class MineLittleFlawlessTags {
    public static TagKey<Item> FLAWLESS_CLOTHING = TagKey.create(Registries.ITEM,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "flawless_clothing"));

    public static TagKey<Item> FARMER_GIFTS = TagKey.create(Registries.ITEM,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "farmer_gifts"));

    public static TagKey<Item> FLAWLESS_FOOD = TagKey.create(Registries.ITEM,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "flawless_food"));

    public static TagKey<EntityType<?>> SPARKLEMOON_FAMILY = TagKey.create(Registries.ENTITY_TYPE,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "sparklemoon_family"));

    public static TagKey<Biome> SPAWNS_TRIXIEBELLE = TagKey.create(Registries.BIOME,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "spawns_trixiebelle"));

    public static TagKey<Biome> SPAWNS_STAR_CATCHER = TagKey.create(Registries.BIOME,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "spawns_star_catcher"));

    public static void init() {

    }
}
