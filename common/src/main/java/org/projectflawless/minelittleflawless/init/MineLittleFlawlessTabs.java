package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.CreativeTabRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.Arrays;
import java.util.function.Supplier;

public class MineLittleFlawlessTabs {
    public static void buildTabContentsVanilla() {
        append(CreativeModeTabs.SPAWN_EGGS,
                MineLittleFlawlessItems.FLAWLESS_SPAWN_EGG,
                MineLittleFlawlessItems.FRACTURED_SPAWN_EGG,
                MineLittleFlawlessItems.TWILIGHT_SPAWN_EGG,
                MineLittleFlawlessItems.TRIXIE_SPAWN_EGG,
                MineLittleFlawlessItems.ARINOS_SPAWN_EGG,
                MineLittleFlawlessItems.LAST_LAUGH_SPAWN_EGG,
                MineLittleFlawlessItems.CHERRY_CHUCKLES_SPAWN_EGG,
                MineLittleFlawlessItems.BIBBLEBOP_SPAWN_EGG,
                MineLittleFlawlessItems.TRICOLOR_JUBILEE_SPAWN_EGG,
                MineLittleFlawlessItems.TRIXIEBELLE_SPAWN_EGG,
                MineLittleFlawlessItems.SKYWISHES_SPAWN_EGG,
                MineLittleFlawlessItems.STAR_CATCHER_SPAWN_EGG,
                MineLittleFlawlessItems.MARIONETTE_SPAWN_EGG,
                MineLittleFlawlessItems.JACKIE_SPECTRE_SPAWN_EGG,
                MineLittleFlawlessItems.WISH_FULFILLMENT_SPAWN_EGG
        );

        append(CreativeModeTabs.TOOLS_AND_UTILITIES,
                MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING,
                MineLittleFlawlessItems.TUXEDO,
                MineLittleFlawlessItems.FARMER,
                MineLittleFlawlessItems.PAJAMAS,
                MineLittleFlawlessItems.SCHOOLGIRL,
                MineLittleFlawlessItems.ROCKSTAR
        );

        append(CreativeModeTabs.INGREDIENTS,
                MineLittleFlawlessItems.ROTTEN_SUGAR
        );
    }

    @SafeVarargs
    private static void append(ResourceKey<CreativeModeTab> tab, Supplier<? extends ItemLike>... items) {
        CreativeTabRegistry.appendStack(CreativeTabRegistry.defer(tab), Arrays.stream(items).map(supplier -> () -> new ItemStack(supplier.get())));
    }
}