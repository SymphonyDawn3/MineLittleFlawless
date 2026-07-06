package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.TrixiebelleModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.TrixiebelleJesterLayer;
import org.projectflawless.minelittleflawless.entity.Trixiebelle;

public class TrixiebelleRenderer extends TamersPonyRenderer<Trixiebelle, TrixiebelleModel> {
    public TrixiebelleRenderer(EntityRendererProvider.Context context) {
        super(context, new TrixiebelleModel(), 0.7f, 0.28f);
        this.addRenderLayer(new TrixiebelleJesterLayer(this));
    }
}
