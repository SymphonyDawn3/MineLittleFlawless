package org.projectflawless.minelittleflawless;

import org.projectflawless.minelittleflawless.init.MinelittleflawlessModTabs;
import org.projectflawless.minelittleflawless.init.MinelittleflawlessModItems;
import org.projectflawless.minelittleflawless.init.MinelittleflawlessModEntities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.IEventBus;

@Mod("minelittleflawless")
public class MinelittleflawlessMod {
    public static final Logger LOGGER = LogManager.getLogger(MinelittleflawlessMod.class);
    public static final String MODID = "minelittleflawless";

    public MinelittleflawlessMod(IEventBus modEventBus) {
        MinelittleflawlessModItems.REGISTRY.register(modEventBus);
        MinelittleflawlessModEntities.REGISTRY.register(modEventBus);
        MinelittleflawlessModTabs.REGISTRY.register(modEventBus);
    }
}