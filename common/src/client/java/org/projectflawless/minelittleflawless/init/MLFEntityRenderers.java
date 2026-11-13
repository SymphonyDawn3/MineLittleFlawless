package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import org.projectflawless.minelittleflawless.client.renderer.entity.*;
import org.projectflawless.minelittleflawless.client.renderer.entity.projectile.LaserRenderer;

public class MLFEntityRenderers {
	public static void registerEntityRenderers() {
		EntityRendererRegistry.register(MLFEntities.BARTLEBY, BartlebyRenderer::new);
		EntityRendererRegistry.register(MLFEntities.FLAWLESS, FlawlessRenderer::new);
        EntityRendererRegistry.register(MLFEntities.FRACTURED, FracturedRenderer::new);
        EntityRendererRegistry.register(MLFEntities.TWILIGHT, TwilightRenderer::new);
        EntityRendererRegistry.register(MLFEntities.TRIXIE, TrixieRenderer::new);
        EntityRendererRegistry.register(MLFEntities.ARINOS, ArinosRenderer::new);
        EntityRendererRegistry.register(MLFEntities.LAST_LAUGH, LastLaughRenderer::new);
        EntityRendererRegistry.register(MLFEntities.CHERRY_CHUCKLES, CherryChucklesRenderer::new);
        EntityRendererRegistry.register(MLFEntities.BIBBLEBOP, BibblebopRenderer::new);
        EntityRendererRegistry.register(MLFEntities.TRICOLOR_JUBILEE, TricolorJubileeRenderer::new);
        EntityRendererRegistry.register(MLFEntities.TRIXIEBELLE, TrixiebelleRenderer::new);
        EntityRendererRegistry.register(MLFEntities.SKYWISHES, SkywishesRenderer::new);
        EntityRendererRegistry.register(MLFEntities.STAR_CATCHER, StarCatcherRenderer::new);
        EntityRendererRegistry.register(MLFEntities.MARIONETTE, MarionetteRenderer::new);
        EntityRendererRegistry.register(MLFEntities.JACKIE_SPECTRE, JackieSpectreRenderer::new);
        EntityRendererRegistry.register(MLFEntities.WISH_FULFILLMENT, WishFulfillmentRenderer::new);
        EntityRendererRegistry.register(MLFEntities.SHAY_MEADOWS, ShayMeadowsRenderer::new);

        // Projectiles
        EntityRendererRegistry.register(MLFEntities.LASER, LaserRenderer::new);
	}
}