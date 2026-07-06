package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.TuxedoModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;

public class TuxedoRenderLayer extends FlawlessClothingRenderLayer {
    public TuxedoRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new TuxedoModel(), Clothing.TUXEDO);
    }
}
