package org.projectflawless.minelittleflawless.init;

import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.projectflawless.minelittleflawless.item.*;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class MineLittleFlawlessItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MineLittleFlawless.MODID);
    public static final RegistryObject<ForgeSpawnEggItem> FLAWLESS_SPAWN_EGG = register("flawless_spawn_egg", () -> new ForgeSpawnEggItem(MineLittleFlawlessEntities.FLAWLESS, 10730239, 11181311, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> TWILIGHT_SPAWN_EGG = register("twilight_spawn_egg", () -> new ForgeSpawnEggItem(MineLittleFlawlessEntities.TWILIGHT, 13409503, 6630791, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> TRIXIE_SPAWN_EGG = register("trixie_spawn_egg", () -> new ForgeSpawnEggItem(MineLittleFlawlessEntities.TRIXIE, 7123690,14808319, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> ARINOS_SPAWN_EGG = register("arinos_spawn_egg", () -> new ForgeSpawnEggItem(MineLittleFlawlessEntities.ARINOS, 16636668, 3717372, new Item.Properties()));
    public static final RegistryObject<FlawlessMagicianClothingItem> FLAWLESS_MAGICIAN_CLOTHING = register("flawless_magician_clothing", () -> new FlawlessMagicianClothingItem(new Item.Properties()));
    public static final RegistryObject<TuxedoItem> TUXEDO = register("tuxedo", () -> new TuxedoItem(new Item.Properties()));
    public static final RegistryObject<FarmerItem> FARMER = register("farmer", () -> new FarmerItem(new Item.Properties()));
    public static final RegistryObject<PajamasItem> PAJAMAS = register("pajamas", () -> new PajamasItem(new Item.Properties()));
    public static final RegistryObject<SchoolgirlItem> SCHOOLGIRL = register("schoolgirl", () -> new SchoolgirlItem(new Item.Properties()));
    public static final RegistryObject<RockstarItem> ROCKSTAR = register("rockstar", () -> new RockstarItem(new Item.Properties()));

    private static <I extends Item> RegistryObject<I> register(String name, Supplier<? extends I> supplier) {
        return REGISTRY.register(name, supplier);
    }
}