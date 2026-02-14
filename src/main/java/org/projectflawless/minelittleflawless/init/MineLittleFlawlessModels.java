package org.projectflawless.minelittleflawless.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.projectflawless.minelittleflawless.client.model.*;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
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
        event.registerLayerDefinition(TwilightModel.LAYER_LOCATION, TwilightModel::createBodyLayer);
        event.registerLayerDefinition(TrixieModel.LAYER_LOCATION, TrixieModel::createBodyLayer);
        event.registerLayerDefinition(ArinosModel.LAYER_LOCATION, ArinosModel::createBodyLayer);
        event.registerLayerDefinition(JesterModel.LAYER_LOCATION, JesterModel::createBodyLayer);
        event.registerLayerDefinition(UnicornHornCoronaModel.LAYER_LOCATION, UnicornHornCoronaModel::createBodyLayer);
	}
}