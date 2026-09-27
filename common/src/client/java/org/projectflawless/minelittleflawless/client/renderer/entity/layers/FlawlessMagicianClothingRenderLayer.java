package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.FlawlessMagicianClothingModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;

public class FlawlessMagicianClothingRenderLayer extends FlawlessClothingRenderLayer {
    public FlawlessMagicianClothingRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new FlawlessMagicianClothingModel(), Clothing.FLAWLESS_MAGICIAN_CLOTHING);
    }
}
