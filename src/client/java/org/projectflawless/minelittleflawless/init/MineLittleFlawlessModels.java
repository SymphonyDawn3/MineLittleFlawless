package org.projectflawless.minelittleflawless.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import org.projectflawless.minelittleflawless.client.model.*;
import org.projectflawless.minelittleflawless.client.model.entity.*;

public class MineLittleFlawlessModels {
	public static void registerLayerDefinitions() {
		EntityModelLayerRegistry.registerModelLayer(BartlebyModel.LAYER_LOCATION, BartlebyModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(UnicornHornCoronaModel.LAYER_LOCATION, UnicornHornCoronaModel::createBodyLayer);
	}
}