package org.projectflawless.minelittleflawless.fabric;

import net.fabricmc.api.ClientModInitializer;
import org.projectflawless.minelittleflawless.MLFClient;

public class MLFFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MLFClient.init();
    }
}
