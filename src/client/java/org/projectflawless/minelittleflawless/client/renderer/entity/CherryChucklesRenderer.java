package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.CherryChucklesModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.CherryChucklesClownLayer;
import org.projectflawless.minelittleflawless.entity.CherryChuckles;

public class CherryChucklesRenderer extends TamersPonyRenderer<CherryChuckles, CherryChucklesModel> {
    public CherryChucklesRenderer(EntityRendererProvider.Context context) {
        super(context, new CherryChucklesModel(), 0.7f, 0.28f);
        this.addRenderLayer(new CherryChucklesClownLayer(this));
    }
}
