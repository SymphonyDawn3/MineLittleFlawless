package org.projectflawless.minelittleflawless.init;

import org.projectflawless.minelittleflawless.client.renderer.FlawlessRenderer;
import org.projectflawless.minelittleflawless.client.renderer.BartlebyRenderer;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class MinelittleflawlessModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MinelittleflawlessModEntities.BARTLEBY.get(), BartlebyRenderer::new);
		event.registerEntityRenderer(MinelittleflawlessModEntities.FLAWLESS.get(), FlawlessRenderer::new);
	}
}