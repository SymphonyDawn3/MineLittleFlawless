package org.projectflawless.minelittleflawless;

import org.projectflawless.minelittleflawless.init.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MLF {
	public static final String MOD_ID = "minelittleflawless";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void init() {
        MLFEntities.init();
        MLFItems.init();
        MLFSoundEvents.init();
        MLFTags.init();
        MLFSpawns.init();
        MLFBiomeSpawns.init();
        MLFTabs.buildTabContentsVanilla();
        MLFAttributes.registerAttributes();
        FlawlessEvents.init();
        MLFSBLSensors.init();
	}
}