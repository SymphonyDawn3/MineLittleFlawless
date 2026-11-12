package org.projectflawless.minelittleflawless.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.MLFClient;
import org.projectflawless.minelittleflawless.forge.event.PlayerSleepEventForge;

@Mod(MLF.MOD_ID)
public final class MLFForge {
    public MLFForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(MLF.MOD_ID, modEventBus);

        MLF.init();
        MLFClient.init();
        PlayerSleepEventForge.init();
    }
}
