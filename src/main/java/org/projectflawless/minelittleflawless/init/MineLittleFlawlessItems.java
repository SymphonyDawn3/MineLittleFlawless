package org.projectflawless.minelittleflawless.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SpawnEggItem;
import org.projectflawless.minelittleflawless.item.*;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class MineLittleFlawlessItems {
    public static final SpawnEggItem FLAWLESS_SPAWN_EGG = register("flawless_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.FLAWLESS, 0xa3baff, 0xaa9cff, new Item.Properties()));
    public static final SpawnEggItem TWILIGHT_SPAWN_EGG = register("twilight_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.TWILIGHT, 0xcc9cdf, 0x652d87, new Item.Properties()));
    public static final SpawnEggItem TRIXIE_SPAWN_EGG = register("trixie_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.TRIXIE, 0x6cb2ea, 0xe1f4ff, new Item.Properties()));
    public static final SpawnEggItem ARINOS_SPAWN_EGG = register("arinos_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.ARINOS, 0xfddafc, 0x38b8fc, new Item.Properties()));
    public static final SpawnEggItem TRIXIEBELLE_SPAWN_EGG = register("trixiebelle_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.TRIXIEBELLE, 0xfdf0b5, 0xff7d69, new Item.Properties()));
    public static final SpawnEggItem MARIONETTE_SPAWN_EGG = register("marionette_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.MARIONETTE, 0xffffff, 0x302631, new Item.Properties()));
    public static final SpawnEggItem STAR_CATCHER_SPAWN_EGG = register("star_catcher_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.STAR_CATCHER, 0xf3ece0, 0xf2a6ce, new Item.Properties()));
    public static final SpawnEggItem JACKIE_SPECTRE_SPAWN_EGG = register("jackie_spectre_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.JACKIE_SPECTRE, 0xffefbb, 0xffe48b, new Item.Properties()));
    public static final FlawlessMagicianClothingItem FLAWLESS_MAGICIAN_CLOTHING = register("flawless_magician_clothing", () -> new FlawlessMagicianClothingItem(new Item.Properties()));
    public static final TuxedoItem TUXEDO = register("tuxedo", () -> new TuxedoItem(new Item.Properties()));
    public static final FarmerItem FARMER = register("farmer", () -> new FarmerItem(new Item.Properties()));
    public static final PajamasItem PAJAMAS = register("pajamas", () -> new PajamasItem(new Item.Properties()));
    public static final SchoolgirlItem SCHOOLGIRL = register("schoolgirl", () -> new SchoolgirlItem(new Item.Properties()));
    public static final RockstarItem ROCKSTAR = register("rockstar", () -> new RockstarItem(new Item.Properties()));

    public static void init() {

    }

    private static <I extends Item> I register(String name, Supplier<? extends I> supplier) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MineLittleFlawless.MOD_ID, name),
                supplier.get());
    }
}