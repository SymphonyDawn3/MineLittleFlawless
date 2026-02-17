package org.projectflawless.minelittleflawless;

import net.fabricmc.api.ClientModInitializer;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntityRenderers;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessModels;

public class MineLittleFlawlessClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
        MineLittleFlawlessEntityRenderers.registerEntityRenderers();
        MineLittleFlawlessModels.registerLayerDefinitions();
	}
}