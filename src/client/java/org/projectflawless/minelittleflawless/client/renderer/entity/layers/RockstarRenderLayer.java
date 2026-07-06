package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.RockstarModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;

public class RockstarRenderLayer extends FlawlessClothingRenderLayer {
    public RockstarRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new RockstarModel(), Clothing.ROCKSTAR);
    }
}
