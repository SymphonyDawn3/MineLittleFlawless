package org.projectflawless.minelittleflawless.fabric.event;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import org.projectflawless.minelittleflawless.event.PlayerSleepEvent;

public class PlayerSleepEventFabric {
    public static void init() {
        EntitySleepEvents.ALLOW_SLEEPING.register((player, sleepingPos) -> PlayerSleepEvent.SLEEPING.invoker().onPlayerSleep(player, sleepingPos));
    }
}
