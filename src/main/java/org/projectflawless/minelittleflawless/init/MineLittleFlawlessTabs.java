package org.projectflawless.minelittleflawless.init;

import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MineLittleFlawlessTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MineLittleFlawless.MODID);

    @SubscribeEvent
    public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
        if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            tabData.accept(MineLittleFlawlessItems.FLAWLESS_SPAWN_EGG.get());
            tabData.accept(MineLittleFlawlessItems.TWILIGHT_SPAWN_EGG.get());
            tabData.accept(MineLittleFlawlessItems.TRIXIE_SPAWN_EGG.get());
            tabData.accept(MineLittleFlawlessItems.ARINOS_SPAWN_EGG.get());
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