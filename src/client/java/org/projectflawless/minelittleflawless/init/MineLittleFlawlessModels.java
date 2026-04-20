package org.projectflawless.minelittleflawless.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import org.projectflawless.minelittleflawless.client.model.*;

public class MineLittleFlawlessModels {
	public static void registerLayerDefinitions() {
        EntityModelLayerRegistry.registerModelLayer(PajamasModel.LAYER_LOCATION, PajamasModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FarmerModel.LAYER_LOCATION, FarmerModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FlawlessMagicianClothingModel.LAYER_LOCATION, FlawlessMagicianClothingModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(BartlebyModel.LAYER_LOCATION, BartlebyModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(SchoolgirlModel.LAYER_LOCATION, SchoolgirlModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(TuxedoModel.LAYER_LOCATION, TuxedoModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(RockstarModel.LAYER_LOCATION, RockstarModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(FlawlessModel.LAYER_LOCATION, FlawlessModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(TwilightModel.LAYER_LOCATION, TwilightModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(TrixieModel.LAYER_LOCATION, TrixieModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ArinosModel.LAYER_LOCATION, ArinosModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(TrixiebelleModel.LAYER_LOCATION, TrixiebelleModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(JesterModel.LAYER_LOCATION, JesterModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(TrixiebelleJesterModel.LAYER_LOCATION, TrixiebelleJesterModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(UnicornHornCoronaModel.LAYER_LOCATION, UnicornHornCoronaModel::createBodyLayer);
	}
}