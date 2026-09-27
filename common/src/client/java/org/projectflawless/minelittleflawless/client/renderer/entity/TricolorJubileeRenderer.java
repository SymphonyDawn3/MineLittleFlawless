package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.TricolorJubileeModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.TricolorJubileeClownLayer;
import org.projectflawless.minelittleflawless.entity.TricolorJubilee;

public class TricolorJubileeRenderer extends TamersPonyRenderer<TricolorJubilee, TricolorJubileeModel> {
    public TricolorJubileeRenderer(EntityRendererProvider.Context context) {
        super(context, new TricolorJubileeModel());
        this.addRenderLayer(new TricolorJubileeClownLayer(this));
    }
}
