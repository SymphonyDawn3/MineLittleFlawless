package org.projectflawless.minelittleflawless.init;

import org.projectflawless.minelittleflawless.client.model.*;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class MineLittleFlawlessModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(PajamasModel.LAYER_LOCATION, PajamasModel::createBodyLayer);
		event.registerLayerDefinition(FarmerModel.LAYER_LOCATION, FarmerModel::createBodyLayer);
		event.registerLayerDefinition(FlawlessMagicianClothingModel.LAYER_LOCATION, FlawlessMagicianClothingModel::createBodyLayer);
		event.registerLayerDefinition(BartlebyModel.LAYER_LOCATION, BartlebyModel::createBodyLayer);
		event.registerLayerDefinition(SchoolgirlModel.LAYER_LOCATION, SchoolgirlModel::createBodyLayer);
		event.registerLayerDefinition(TuxedoModel.LAYER_LOCATION, TuxedoModel::createBodyLayer);
		event.registerLayerDefinition(RockstarModel.LAYER_LOCATION, RockstarModel::createBodyLayer);
		event.registerLayerDefinition(FlawlessModel.LAYER_LOCATION, FlawlessModel::createBodyLayer);
	}
}