package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.SchoolgirlModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;

public class SchoolgirlRenderLayer extends FlawlessClothingRenderLayer {
    public SchoolgirlRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new SchoolgirlModel(), Clothing.SCHOOLGIRL);
    }
}
