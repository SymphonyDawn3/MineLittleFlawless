package org.projectflawless.minelittleflawless;

import org.projectflawless.minelittleflawless.init.MineLittleFlawlessTabs;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.IEventBus;

@Mod("minelittleflawless")
public class MineLittleFlawless {
    public static final Logger LOGGER = LogManager.getLogger(MineLittleFlawless.class);
    public static final String MODID = "minelittleflawless";

    public MineLittleFlawless(IEventBus modEventBus) {
        MineLittleFlawlessItems.REGISTRY.register(modEventBus);
        MineLittleFlawlessEntities.REGISTRY.register(modEventBus);
        MineLittleFlawlessTabs.REGISTRY.register(modEventBus);
    }
}