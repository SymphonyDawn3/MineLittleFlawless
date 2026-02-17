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
    public static final SpawnEggItem FLAWLESS_SPAWN_EGG = register("flawless_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.FLAWLESS, 10730239, 11181311, new Item.Properties()));
    public static final SpawnEggItem TWILIGHT_SPAWN_EGG = register("twilight_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.TWILIGHT, 13409503, 6630791, new Item.Properties()));
    public static final SpawnEggItem TRIXIE_SPAWN_EGG = register("trixie_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.TRIXIE, 7123690, 14808319, new Item.Properties()));
    public static final SpawnEggItem ARINOS_SPAWN_EGG = register("arinos_spawn_egg", () -> new SpawnEggItem(MineLittleFlawlessEntities.ARINOS, 16636668, 3717372, new Item.Properties()));
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