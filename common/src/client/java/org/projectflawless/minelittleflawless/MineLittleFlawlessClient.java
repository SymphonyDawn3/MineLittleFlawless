package org.projectflawless.minelittleflawless;

import net.fabricmc.api.ClientModInitializer;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntityRenderers;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessModels;

public class MineLittleFlawlessClient {
	public static void init() {
        MineLittleFlawlessEntityRenderers.registerEntityRenderers();
        MineLittleFlawlessModels.registerLayerDefinitions();
	}
}