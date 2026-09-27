package org.projectflawless.minelittleflawless.fabric;

import net.fabricmc.api.ClientModInitializer;
import org.projectflawless.minelittleflawless.MineLittleFlawlessClient;

public class MineLittleFlawlessFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MineLittleFlawlessClient.init();
    }
}
