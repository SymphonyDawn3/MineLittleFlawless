package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.CreativeTabRegistry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.Arrays;
import java.util.function.Supplier;

public class MLFTabs {
    public static void buildTabContentsVanilla() {
        append(CreativeModeTabs.SPAWN_EGGS,
                MLFItems.FLAWLESS_SPAWN_EGG,
                MLFItems.FRACTURED_SPAWN_EGG,
                MLFItems.TWILIGHT_SPAWN_EGG,
                MLFItems.TRIXIE_SPAWN_EGG,
                MLFItems.ARINOS_SPAWN_EGG,
                MLFItems.LAST_LAUGH_SPAWN_EGG,
                MLFItems.CHERRY_CHUCKLES_SPAWN_EGG,
                MLFItems.BIBBLEBOP_SPAWN_EGG,
                MLFItems.TRICOLOR_JUBILEE_SPAWN_EGG,
                MLFItems.TRIXIEBELLE_SPAWN_EGG,
                MLFItems.SKYWISHES_SPAWN_EGG,
                MLFItems.STAR_CATCHER_SPAWN_EGG,
                MLFItems.MARIONETTE_SPAWN_EGG,
                MLFItems.JACKIE_SPECTRE_SPAWN_EGG,
                MLFItems.WISH_FULFILLMENT_SPAWN_EGG,
                MLFItems.SHAY_MEADOWS_SPAWN_EGG
        );

        append(CreativeModeTabs.TOOLS_AND_UTILITIES,
                // Flawless clothing
                MLFItems.FLAWLESS_MAGICIAN_CLOTHING,
                MLFItems.TUXEDO,
                MLFItems.FARMER,
                MLFItems.PAJAMAS,
                MLFItems.SCHOOLGIRL,
                MLFItems.ROCKSTAR,
                // Trixie clothing
                MLFItems.TRIXIE_MAGICIAN,
                MLFItems.TRIXIE_BLACK_MAGICIAN,
                MLFItems.TRIXIE_SCHOOLGIRL,
                MLFItems.TRIXIE_GIR,
                // Trixiebelle clothing
                MLFItems.TRIXIEBELLE_JESTER,
                MLFItems.TRIXIEBELLE_MEXICAN,
                // Skywishes clothing
                MLFItems.SKYWISHES_DRACULA,
                // Music Discs
                MLFItems.MUSIC_DISC_WISHLESS_RESONANCE
        );

        append(CreativeModeTabs.INGREDIENTS,
                MLFItems.ROTTEN_SUGAR
        );
    }

    @SafeVarargs
    private static void append(ResourceKey<CreativeModeTab> tab, Supplier<? extends ItemLike>... items) {
        CreativeTabRegistry.appendStack(CreativeTabRegistry.defer(tab), Arrays.stream(items).map(supplier -> () -> new ItemStack(supplier.get())));
    }
}