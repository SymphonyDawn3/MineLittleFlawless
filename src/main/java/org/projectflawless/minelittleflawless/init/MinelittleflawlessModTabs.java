/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package org.projectflawless.minelittleflawless.init;

import org.projectflawless.minelittleflawless.MinelittleflawlessMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class MinelittleflawlessModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinelittleflawlessMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(MinelittleflawlessModItems.FLAWLESS_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(MinelittleflawlessModItems.FLAWLESS_MAGICIAN_CLOTHING.get());
			tabData.accept(MinelittleflawlessModItems.TUXEDO.get());
			tabData.accept(MinelittleflawlessModItems.FARMER.get());
			tabData.accept(MinelittleflawlessModItems.PAJAMAS.get());
		}
	}
}