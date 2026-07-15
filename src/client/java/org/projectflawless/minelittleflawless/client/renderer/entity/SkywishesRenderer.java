package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.SkywishesModel;
import org.projectflawless.minelittleflawless.entity.Skywishes;

public class SkywishesRenderer extends TamersPonyRenderer<Skywishes, SkywishesModel> {
    public SkywishesRenderer(EntityRendererProvider.Context context) {
        super(context, new SkywishesModel(), 0.7f, 0.28f);
    }
}
