package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.PonySize;
import org.projectflawless.minelittleflawless.client.model.entity.CherryChucklesModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.CherryChucklesClownLayer;
import org.projectflawless.minelittleflawless.entity.CherryChuckles;

public class CherryChucklesRenderer extends TamersPonyRenderer<CherryChuckles, CherryChucklesModel> {
    public CherryChucklesRenderer(EntityRendererProvider.Context context) {
        super(context, new CherryChucklesModel(), PonySize.SMALL);
        this.addRenderLayer(new CherryChucklesClownLayer(this));
    }
}
