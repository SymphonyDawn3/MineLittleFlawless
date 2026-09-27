package org.projectflawless.minelittleflawless.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.MineLittleFlawlessClient;
import org.projectflawless.minelittleflawless.forge.event.PlayerSleepEventForge;

@Mod(MineLittleFlawless.MOD_ID)
public final class MineLittleFlawlessForge {
    public MineLittleFlawlessForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(MineLittleFlawless.MOD_ID, modEventBus);

        MineLittleFlawless.init();
        MineLittleFlawlessClient.init();
        PlayerSleepEventForge.init();
    }
}
