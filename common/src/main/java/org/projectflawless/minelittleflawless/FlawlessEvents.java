package org.projectflawless.minelittleflawless;

import org.projectflawless.minelittleflawless.entity.Flawless;
import org.projectflawless.minelittleflawless.event.PlayerSleepEvent;

public class FlawlessEvents {
    public static void init() {
        // This allows farmer Flawless to give you items whenever you go to bed.
        PlayerSleepEvent.SLEEPING.register(Flawless::whenPlayerWakesUp);
    }
}
