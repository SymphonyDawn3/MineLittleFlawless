package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import org.projectflawless.minelittleflawless.client.model.entity.ArinosModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.JesterModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.ArinosRenderer;
import org.projectflawless.minelittleflawless.entity.Arinos;

public class JesterLayer extends ClothingLayer<Arinos, ArinosModel> {
    public JesterLayer(ArinosRenderer renderer) {
        super(renderer, new JesterModel());
    }
}
