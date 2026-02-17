package org.projectflawless.minelittleflawless;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import org.projectflawless.minelittleflawless.entity.Flawless;

public class FlawlessEvents {
    public static void init() {
        EntitySleepEvents.ALLOW_SLEEPING.register(Flawless::whenPlayerWakesUp);
    }
}
