package org.projectflawless.minelittleflawless.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.projectflawless.minelittleflawless.client.renderer.entity.*;

public class MineLittleFlawlessEntityRenderers {
	public static void registerEntityRenderers() {
		EntityRendererRegistry.register(MineLittleFlawlessEntities.BARTLEBY, BartlebyRenderer::new);
		EntityRendererRegistry.register(MineLittleFlawlessEntities.FLAWLESS, FlawlessRenderer::new);
        EntityRendererRegistry.register(MineLittleFlawlessEntities.TWILIGHT, TwilightRenderer::new);
        EntityRendererRegistry.register(MineLittleFlawlessEntities.TRIXIE, TrixieRenderer::new);
        EntityRendererRegistry.register(MineLittleFlawlessEntities.ARINOS, ArinosRenderer::new);
        EntityRendererRegistry.register(MineLittleFlawlessEntities.TRIXIEBELLE, TrixiebelleRenderer::new);
        EntityRendererRegistry.register(MineLittleFlawlessEntities.MARIONETTE, MarionetteRenderer::new);
        EntityRendererRegistry.register(MineLittleFlawlessEntities.STAR_CATCHER, StarCatcherRenderer::new);
	}
}