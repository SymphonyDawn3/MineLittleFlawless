package org.projectflawless.minelittleflawless.init;

import org.projectflawless.minelittleflawless.item.*;
import org.projectflawless.minelittleflawless.MinelittleflawlessMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class MinelittleflawlessModItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MinelittleflawlessMod.MODID);
    public static final DeferredItem<Item> FLAWLESS_SPAWN_EGG = register("flawless_spawn_egg", properties -> new SpawnEggItem(MinelittleflawlessModEntities.FLAWLESS.get(), properties));
    public static final DeferredItem<Item> FLAWLESS_MAGICIAN_CLOTHING = register("flawless_magician_clothing", FlawlessMagicianClothingItem::new);
    public static final DeferredItem<Item> TUXEDO = register("tuxedo", TuxedoItem::new);
    public static final DeferredItem<Item> FARMER = register("farmer", FarmerItem::new);
    public static final DeferredItem<Item> PAJAMAS = register("pajamas", PajamasItem::new);
    public static final DeferredItem<Item> SCHOOLGIRL = register("schoolgirl", SchoolgirlItem::new);
    public static final DeferredItem<Item> ROCKSTAR = register("rockstar", RockstarItem::new);

    private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
        return REGISTRY.registerItem(name, supplier, new Item.Properties());
    }
}