package org.projectflawless.minelittleflawless.fabric;

import net.fabricmc.api.ModInitializer;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.fabric.event.PlayerSleepEventFabric;


public final class MLFFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MLF.init();
        PlayerSleepEventFabric.init();
    }
}
