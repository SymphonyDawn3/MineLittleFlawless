package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import org.projectflawless.minelittleflawless.client.model.*;
import org.projectflawless.minelittleflawless.client.model.entity.*;

public class MineLittleFlawlessModels {
	public static void registerLayerDefinitions() {
        EntityModelLayerRegistry.register(BartlebyModel.LAYER_LOCATION, BartlebyModel::createBodyLayer);
        EntityModelLayerRegistry.register(UnicornHornCoronaModel.LAYER_LOCATION, UnicornHornCoronaModel::createBodyLayer);
	}
}