package org.projectflawless.minelittleflawless.init;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.world.item.CreativeModeTabs;

public class MineLittleFlawlessTabs {
    final public static Event<ItemGroupEvents.ModifyEntries> SPAWN_EGGS = ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS);
    final public static Event<ItemGroupEvents.ModifyEntries> TOOLS_AND_UTILITIES = ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES);

    public static void buildTabContentsVanilla() {
        SPAWN_EGGS.register(entries -> {
            entries.accept(MineLittleFlawlessItems.FLAWLESS_SPAWN_EGG);
            entries.accept(MineLittleFlawlessItems.TWILIGHT_SPAWN_EGG);
            entries.accept(MineLittleFlawlessItems.TRIXIE_SPAWN_EGG);
            entries.accept(MineLittleFlawlessItems.ARINOS_SPAWN_EGG);
            entries.accept(MineLittleFlawlessItems.TRIXIEBELLE_SPAWN_EGG);
        });

        TOOLS_AND_UTILITIES.register(entries -> {
            entries.accept(MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING);
            entries.accept(MineLittleFlawlessItems.TUXEDO);
            entries.accept(MineLittleFlawlessItems.FARMER);
            entries.accept(MineLittleFlawlessItems.PAJAMAS);
            entries.accept(MineLittleFlawlessItems.SCHOOLGIRL);
            entries.accept(MineLittleFlawlessItems.ROCKSTAR);
        });
    }
}