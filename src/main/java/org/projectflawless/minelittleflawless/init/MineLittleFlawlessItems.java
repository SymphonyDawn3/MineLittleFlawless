package org.projectflawless.minelittleflawless.init;

import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import org.projectflawless.minelittleflawless.item.*;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import java.util.function.Function;

public class MineLittleFlawlessItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MineLittleFlawless.MODID);
    public static final DeferredItem<DeferredSpawnEggItem> FLAWLESS_SPAWN_EGG = register("flawless_spawn_egg", properties -> new DeferredSpawnEggItem(MineLittleFlawlessEntities.FLAWLESS, 10730239, 11181311, properties));
    public static final DeferredItem<DeferredSpawnEggItem> TWILIGHT_SPAWN_EGG = register("twilight_spawn_egg", properties -> new DeferredSpawnEggItem(MineLittleFlawlessEntities.TWILIGHT, 13409503, 6630791, properties));
    public static final DeferredItem<DeferredSpawnEggItem> TRIXIE_SPAWN_EGG = register("trixie_spawn_egg", properties -> new DeferredSpawnEggItem(MineLittleFlawlessEntities.TRIXIE, 7123690,14808319, properties));
    public static final DeferredItem<DeferredSpawnEggItem> ARINOS_SPAWN_EGG = register("arinos_spawn_egg", properties -> new DeferredSpawnEggItem(MineLittleFlawlessEntities.ARINOS, 16636668, 3717372, properties));
    public static final DeferredItem<FlawlessMagicianClothingItem> FLAWLESS_MAGICIAN_CLOTHING = register("flawless_magician_clothing", FlawlessMagicianClothingItem::new);
    public static final DeferredItem<TuxedoItem> TUXEDO = register("tuxedo", TuxedoItem::new);
    public static final DeferredItem<FarmerItem> FARMER = register("farmer", FarmerItem::new);
    public static final DeferredItem<PajamasItem> PAJAMAS = register("pajamas", PajamasItem::new);
    public static final DeferredItem<SchoolgirlItem> SCHOOLGIRL = register("schoolgirl", SchoolgirlItem::new);
    public static final DeferredItem<RockstarItem> ROCKSTAR = register("rockstar", RockstarItem::new);

    private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
        return REGISTRY.registerItem(name, supplier, new Item.Properties());
    }
}