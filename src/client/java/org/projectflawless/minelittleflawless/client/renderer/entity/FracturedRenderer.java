package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.FracturedModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.FracturedTuxedoLayer;
import org.projectflawless.minelittleflawless.entity.Fractured;

public class FracturedRenderer extends TamersPonyRenderer<Fractured, FracturedModel> {
    public FracturedRenderer(EntityRendererProvider.Context context) {
        super(context, new FracturedModel());
        this.addRenderLayer(new FracturedTuxedoLayer(this));
    }
}
