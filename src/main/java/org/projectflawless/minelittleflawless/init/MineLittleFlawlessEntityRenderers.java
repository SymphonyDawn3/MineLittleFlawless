package org.projectflawless.minelittleflawless.init;

import org.projectflawless.minelittleflawless.client.renderer.FlawlessRenderer;
import org.projectflawless.minelittleflawless.client.renderer.BartlebyRenderer;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;
import org.projectflawless.minelittleflawless.client.renderer.TrixieRenderer;
import org.projectflawless.minelittleflawless.client.renderer.TwilightRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class MineLittleFlawlessEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MineLittleFlawlessEntities.BARTLEBY.get(), BartlebyRenderer::new);
		event.registerEntityRenderer(MineLittleFlawlessEntities.FLAWLESS.get(), FlawlessRenderer::new);
        event.registerEntityRenderer(MineLittleFlawlessEntities.TWILIGHT.get(), TwilightRenderer::new);
        event.registerEntityRenderer(MineLittleFlawlessEntities.TRIXIE.get(), TrixieRenderer::new);
	}
}