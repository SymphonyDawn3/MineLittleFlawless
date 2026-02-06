package org.projectflawless.minelittleflawless.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.projectflawless.minelittleflawless.client.renderer.*;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MineLittleFlawlessEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MineLittleFlawlessEntities.BARTLEBY.get(), BartlebyRenderer::new);
		event.registerEntityRenderer(MineLittleFlawlessEntities.FLAWLESS.get(), FlawlessRenderer::new);
        event.registerEntityRenderer(MineLittleFlawlessEntities.TWILIGHT.get(), TwilightRenderer::new);
        event.registerEntityRenderer(MineLittleFlawlessEntities.TRIXIE.get(), TrixieRenderer::new);
        event.registerEntityRenderer(MineLittleFlawlessEntities.ARINOS.get(), ArinosRenderer::new);
	}
}