package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import org.projectflawless.minelittleflawless.client.model.entity.MarionetteModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.MaskModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.MarionetteRenderer;
import org.projectflawless.minelittleflawless.entity.Marionette;

public class MaskLayer extends ClothingLayer<Marionette, MarionetteModel> {
    public MaskLayer(MarionetteRenderer renderer) {
        super(renderer, new MaskModel());
    }
}
