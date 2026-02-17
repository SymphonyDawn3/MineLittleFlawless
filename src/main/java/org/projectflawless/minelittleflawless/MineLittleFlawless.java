package org.projectflawless.minelittleflawless;

import net.fabricmc.api.ModInitializer;

import org.projectflawless.minelittleflawless.init.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineLittleFlawless implements ModInitializer {
	public static final String MOD_ID = "minelittleflawless";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        MineLittleFlawlessItems.init();
        MineLittleFlawlessSoundEvents.init();
        MineLittleFlawlessSpawns.init();
        MineLittleFlawlessBiomeSpawns.init();
        MineLittleFlawlessTabs.buildTabContentsVanilla();
        MineLittleFlawlessAttributes.registerAttributes();
        FlawlessEvents.init();

		LOGGER.info("Hello Fabric world!");
	}
}