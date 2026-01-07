package org.projectflawless.minelittleflawless.init;

import org.projectflawless.minelittleflawless.MineLittleFlawless;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class MineLittleFlawlessTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MineLittleFlawless.MODID);

    @SubscribeEvent
    public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
        if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            tabData.accept(MineLittleFlawlessItems.FLAWLESS_SPAWN_EGG.get());
        } else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            tabData.accept(MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING.get());
            tabData.accept(MineLittleFlawlessItems.TUXEDO.get());
            tabData.accept(MineLittleFlawlessItems.FARMER.get());
            tabData.accept(MineLittleFlawlessItems.PAJAMAS.get());
            tabData.accept(MineLittleFlawlessItems.SCHOOLGIRL.get());
			tabData.accept(MineLittleFlawlessItems.ROCKSTAR.get());
        }
    }
}