package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.MarionetteModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.MaskLayer;
import org.projectflawless.minelittleflawless.entity.Marionette;

public class MarionetteRenderer extends TamersPonyRenderer<Marionette, MarionetteModel> {
    public MarionetteRenderer(EntityRendererProvider.Context context) {
        super(context, new MarionetteModel());
        this.addRenderLayer(new MaskLayer(this));
    }
}
