package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.PonySize;
import org.projectflawless.minelittleflawless.client.model.entity.TrixiebelleModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.TrixiebelleJesterLayer;
import org.projectflawless.minelittleflawless.entity.Trixiebelle;

public class TrixiebelleRenderer extends TamersPonyRenderer<Trixiebelle, TrixiebelleModel> {
    public TrixiebelleRenderer(EntityRendererProvider.Context context) {
        super(context, new TrixiebelleModel(), PonySize.SMALL);
        this.addRenderLayer(new TrixiebelleJesterLayer(this));
    }
}
