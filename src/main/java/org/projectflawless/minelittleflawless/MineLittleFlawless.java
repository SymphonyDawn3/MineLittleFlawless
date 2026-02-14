package org.projectflawless.minelittleflawless;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessTabs;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Mod(MineLittleFlawless.MODID)
public class MineLittleFlawless {
    public static final Logger LOGGER = LogManager.getLogger(MineLittleFlawless.class);
    public static final String MODID = "minelittleflawless";

    public MineLittleFlawless(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        MineLittleFlawlessItems.REGISTRY.register(modEventBus);
        MineLittleFlawlessEntities.REGISTRY.register(modEventBus);
        MineLittleFlawlessTabs.REGISTRY.register(modEventBus);
        MineLittleFlawlessSoundEvents.REGISTRY.register(modEventBus);
    }
}