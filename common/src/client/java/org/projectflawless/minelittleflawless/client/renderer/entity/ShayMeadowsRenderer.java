package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.ShayMeadowsModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.ShayMeadowsFarmerLayer;
import org.projectflawless.minelittleflawless.entity.ShayMeadows;

public class ShayMeadowsRenderer extends TamersPonyRenderer<ShayMeadows, ShayMeadowsModel> {
    public ShayMeadowsRenderer(EntityRendererProvider.Context context) {
        super(context, new ShayMeadowsModel());
        this.addRenderLayer(new ShayMeadowsFarmerLayer(this));
    }
}
