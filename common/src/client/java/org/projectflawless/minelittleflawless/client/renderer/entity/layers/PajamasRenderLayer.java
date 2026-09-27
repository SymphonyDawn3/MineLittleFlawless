package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.PajamasModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;

public class PajamasRenderLayer extends FlawlessClothingRenderLayer {
    public PajamasRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new PajamasModel(), Clothing.PAJAMAS);
    }
}
