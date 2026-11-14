package org.projectflawless.minelittleflawless;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class MLFTags {
    public static TagKey<Item> FLAWLESS_CLOTHING = TagKey.create(Registries.ITEM,
            new ResourceLocation(MLF.MOD_ID, "flawless_clothing"));

    public static TagKey<Item> TRIXIE_CLOTHING = TagKey.create(Registries.ITEM,
            new ResourceLocation(MLF.MOD_ID, "trixie_clothing"));

    public static TagKey<Item> TRIXIEBELLE_CLOTHING = TagKey.create(Registries.ITEM,
            new ResourceLocation(MLF.MOD_ID, "trixiebelle_clothing"));

    public static TagKey<Item> SKYWISHES_CLOTHING = TagKey.create(Registries.ITEM,
            new ResourceLocation(MLF.MOD_ID, "skywishes_clothing"));

    public static TagKey<Item> FARMER_GIFTS = TagKey.create(Registries.ITEM,
            new ResourceLocation(MLF.MOD_ID, "farmer_gifts"));

    public static TagKey<Item> FLAWLESS_FOOD = TagKey.create(Registries.ITEM,
            new ResourceLocation(MLF.MOD_ID, "flawless_food"));

    public static TagKey<EntityType<?>> SPARKLEMOON_FAMILY = TagKey.create(Registries.ENTITY_TYPE,
            new ResourceLocation(MLF.MOD_ID, "sparklemoon_family"));

    public static TagKey<EntityType<?>> CLOWN_COLLEGE = TagKey.create(Registries.ENTITY_TYPE,
            new ResourceLocation(MLF.MOD_ID, "clown_college"));

    public static TagKey<Biome> SPAWNS_SPARKLEMOON_FAMILY = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_sparklemoon_family"));

    public static TagKey<Biome> SPAWNS_FLAWLESS = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_flawless"));

    public static TagKey<Biome> SPAWNS_TWILIGHT = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_twilight"));

    public static TagKey<Biome> SPAWNS_TRIXIE = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_trixie"));

    public static TagKey<Biome> SPAWNS_FRACTURED = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_fractured"));

    public static TagKey<Biome> SPAWNS_CLOWNS = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_clowns"));

    public static TagKey<Biome> SPAWNS_ARINOS = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_arinos"));

    public static TagKey<Biome> SPAWNS_LAST_LAUGH = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_last_laugh"));

    public static TagKey<Biome> SPAWNS_CHERRY_CHUCKLES = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_cherry_chuckles"));

    public static TagKey<Biome> SPAWNS_BIBBLEBOP = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_bibblebop"));

    public static TagKey<Biome> SPAWNS_TRICOLOR_JUBILEE = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_tricolor_jubilee"));

    public static TagKey<Biome> SPAWNS_TRIXIEBELLE = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_trixiebelle"));

    public static TagKey<Biome> SPAWNS_WISHCATCHER = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_wishcatcher"));

    public static TagKey<Biome> SPAWNS_SKYWISHES = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_skywishes"));

    public static TagKey<Biome> SPAWNS_STAR_CATCHER = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_star_catcher"));

    public static TagKey<Biome> SPAWNS_MARIONETTE = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_marionette"));

    public static TagKey<Biome> SPAWNS_JACKIE_SPECTRE = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_jackie_spectre"));

    public static TagKey<Biome> SPAWNS_WISH_FULFILLMENT = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_wish_fulfillment"));

    public static TagKey<Biome> SPAWNS_SHAY_MEADOWS = TagKey.create(Registries.BIOME,
            new ResourceLocation(MLF.MOD_ID, "spawns_shay_meadows"));

    public static TagKey<Block> SHAY_MEADOWS_SPAWNABLE_ON = TagKey.create(Registries.BLOCK,
            new ResourceLocation(MLF.MOD_ID, "shay_meadows_spawnable_on"));

    public static void init() {

    }
}
