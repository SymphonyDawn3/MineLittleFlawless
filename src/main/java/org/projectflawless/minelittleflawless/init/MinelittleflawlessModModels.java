/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package org.projectflawless.minelittleflawless.init;

import org.projectflawless.minelittleflawless.client.model.ModelFriendshipBow;
import org.projectflawless.minelittleflawless.client.model.ModelFlawless;
import org.projectflawless.minelittleflawless.client.model.ModelBartleby;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class MinelittleflawlessModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelFriendshipBow.LAYER_LOCATION, ModelFriendshipBow::createBodyLayer);
		event.registerLayerDefinition(ModelBartleby.LAYER_LOCATION, ModelBartleby::createBodyLayer);
		event.registerLayerDefinition(ModelFlawless.LAYER_LOCATION, ModelFlawless::createBodyLayer);
	}
}