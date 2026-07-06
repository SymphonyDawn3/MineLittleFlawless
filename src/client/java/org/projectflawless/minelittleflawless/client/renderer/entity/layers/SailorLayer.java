package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import org.projectflawless.minelittleflawless.client.model.entity.JackieSpectreModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.SailorModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.JackieSpectreRenderer;
import org.projectflawless.minelittleflawless.entity.JackieSpectre;

public class SailorLayer extends ClothingLayer<JackieSpectre, JackieSpectreModel> {
    public SailorLayer(JackieSpectreRenderer renderer) {
        super(renderer, new SailorModel());
    }
}
