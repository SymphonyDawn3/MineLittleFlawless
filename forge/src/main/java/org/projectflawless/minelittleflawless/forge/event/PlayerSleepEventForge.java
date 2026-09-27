package org.projectflawless.minelittleflawless.forge.event;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.projectflawless.minelittleflawless.event.PlayerSleepEvent;


public class PlayerSleepEventForge {
    @SubscribeEvent
    public static void onSleep(PlayerSleepInBedEvent event) {
        event.setResult(PlayerSleepEvent.SLEEPING.invoker().onPlayerSleep(event.getEntity(), event.getPos()));
    }

    public static void init() {
        MinecraftForge.EVENT_BUS.register(PlayerSleepEventForge.class);
    }
}
