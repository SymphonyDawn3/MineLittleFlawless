package org.projectflawless.minelittleflawless.init;

import dev.architectury.core.item.ArchitecturySpawnEggItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.SpawnEggItem;
import org.projectflawless.minelittleflawless.item.*;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class MineLittleFlawlessItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MineLittleFlawless.MOD_ID, Registries.ITEM);
    public static final RegistrySupplier<Item> ROTTEN_SUGAR = register("rotten_sugar", () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> FLAWLESS_SPAWN_EGG = register("flawless_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.FLAWLESS, 0xa3baff, 0xaa9cff, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> FRACTURED_SPAWN_EGG = register("fractured_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.FRACTURED, 0x39334d, 0x4a3559, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> TWILIGHT_SPAWN_EGG = register("twilight_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.TWILIGHT, 0xcc9cdf, 0x652d87, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> TRIXIE_SPAWN_EGG = register("trixie_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.TRIXIE, 0x6cb2ea, 0xe1f4ff, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> ARINOS_SPAWN_EGG = register("arinos_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.ARINOS, 0xfddafc, 0x38b8fc, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> LAST_LAUGH_SPAWN_EGG = register("last_laugh_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.LAST_LAUGH, 0x828085, 0x1a1a1a, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> CHERRY_CHUCKLES_SPAWN_EGG = register("cherry_chuckles_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.CHERRY_CHUCKLES, 0xc3fdff, 0x779bf9, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> BIBBLEBOP_SPAWN_EGG = ITEMS.register("bibblebop_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.BIBBLEBOP, 0xffffff, 0xf788f1, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> TRICOLOR_JUBILEE_SPAWN_EGG = register("tricolor_jubilee_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.TRICOLOR_JUBILEE, 0xfbf8cd, 0xbc79da, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> TRIXIEBELLE_SPAWN_EGG = register("trixiebelle_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.TRIXIEBELLE, 0xfdf0b5, 0xff7d69, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> SKYWISHES_SPAWN_EGG = register("skywishes_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.SKYWISHES, 0xfe9fe3, 0x913d9b, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> STAR_CATCHER_SPAWN_EGG = register("star_catcher_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.STAR_CATCHER, 0xf3ece0, 0xf2a6ce, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> MARIONETTE_SPAWN_EGG = register("marionette_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.MARIONETTE, 0xffffff, 0x302631, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> JACKIE_SPECTRE_SPAWN_EGG = register("jackie_spectre_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.JACKIE_SPECTRE, 0xffefbb, 0xffe48b, new Item.Properties()));
    public static final RegistrySupplier<SpawnEggItem> WISH_FULFILLMENT_SPAWN_EGG = register("wish_fulfillment_spawn_egg", () -> new ArchitecturySpawnEggItem(MineLittleFlawlessEntities.WISH_FULFILLMENT, 0x6bb3d0, 0x3c285f, new Item.Properties()));
    public static final RegistrySupplier<FlawlessMagicianClothingItem> FLAWLESS_MAGICIAN_CLOTHING = register("flawless_magician_clothing", () -> new FlawlessMagicianClothingItem(new Item.Properties()));
    public static final RegistrySupplier<TuxedoItem> TUXEDO = register("tuxedo", () -> new TuxedoItem(new Item.Properties()));
    public static final RegistrySupplier<FarmerItem> FARMER = register("farmer", () -> new FarmerItem(new Item.Properties()));
    public static final RegistrySupplier<PajamasItem> PAJAMAS = register("pajamas", () -> new PajamasItem(new Item.Properties()));
    public static final RegistrySupplier<SchoolgirlItem> SCHOOLGIRL = register("schoolgirl", () -> new SchoolgirlItem(new Item.Properties()));
    public static final RegistrySupplier<RockstarItem> ROCKSTAR = register("rockstar", () -> new RockstarItem(new Item.Properties()));

    public static void init() {
        ITEMS.register();
    }

    private static <I extends Item> RegistrySupplier<I> register(String name, Supplier<? extends I> supplier) {
        return ITEMS.register(name, supplier);
    }
}