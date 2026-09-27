package org.projectflawless.minelittleflawless.fabric;

import net.fabricmc.api.ModInitializer;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.fabric.event.PlayerSleepEventFabric;


public final class MineLittleFlawlessFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MineLittleFlawless.init();
        PlayerSleepEventFabric.init();
    }
}
