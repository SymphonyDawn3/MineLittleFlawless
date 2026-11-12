package org.projectflawless.minelittleflawless;

import org.projectflawless.minelittleflawless.init.MLFEntityRenderers;
import org.projectflawless.minelittleflawless.init.MLFModels;

public class MLFClient {
	public static void init() {
        MLFEntityRenderers.registerEntityRenderers();
        MLFModels.registerLayerDefinitions();
	}
}