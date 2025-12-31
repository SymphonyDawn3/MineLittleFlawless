package org.projectflawless.minelittleflawless.init;

import org.projectflawless.minelittleflawless.client.model.*;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class MinelittleflawlessModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelPajamas.LAYER_LOCATION, ModelPajamas::createBodyLayer);
		event.registerLayerDefinition(ModelFarmer.LAYER_LOCATION, ModelFarmer::createBodyLayer);
		event.registerLayerDefinition(ModelFlawlessMagicianClothing.LAYER_LOCATION, ModelFlawlessMagicianClothing::createBodyLayer);
		event.registerLayerDefinition(ModelBartleby.LAYER_LOCATION, ModelBartleby::createBodyLayer);
		event.registerLayerDefinition(ModelSchoolgirl.LAYER_LOCATION, ModelSchoolgirl::createBodyLayer);
		event.registerLayerDefinition(ModelTuxedo.LAYER_LOCATION, ModelTuxedo::createBodyLayer);
		event.registerLayerDefinition(ModelRockstar.LAYER_LOCATION, ModelRockstar::createBodyLayer);
		event.registerLayerDefinition(ModelFlawless.LAYER_LOCATION, ModelFlawless::createBodyLayer);
	}
}