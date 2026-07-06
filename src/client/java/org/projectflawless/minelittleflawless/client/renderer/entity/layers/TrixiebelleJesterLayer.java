package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import org.projectflawless.minelittleflawless.client.model.entity.TrixiebelleModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.TrixiebelleJesterModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.TrixiebelleRenderer;
import org.projectflawless.minelittleflawless.entity.Trixiebelle;

public class TrixiebelleJesterLayer extends ClothingLayer<Trixiebelle, TrixiebelleModel> {
    public TrixiebelleJesterLayer(TrixiebelleRenderer renderer) {
        super(renderer, new TrixiebelleJesterModel());
    }
}
