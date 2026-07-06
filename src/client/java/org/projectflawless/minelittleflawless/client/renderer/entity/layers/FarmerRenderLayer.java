package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.FarmerModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;

public class FarmerRenderLayer extends FlawlessClothingRenderLayer {
    public FarmerRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new FarmerModel(), Clothing.FARMER);
    }
}
