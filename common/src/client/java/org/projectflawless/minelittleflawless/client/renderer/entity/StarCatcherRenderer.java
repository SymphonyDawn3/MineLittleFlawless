package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.PonySize;
import org.projectflawless.minelittleflawless.client.model.entity.StarCatcherModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.MaidLayer;
import org.projectflawless.minelittleflawless.entity.StarCatcher;

public class StarCatcherRenderer extends TamersPonyRenderer<StarCatcher, StarCatcherModel> {
    public StarCatcherRenderer(EntityRendererProvider.Context context) {
        super(context, new StarCatcherModel(), PonySize.LARGE);
        this.addRenderLayer(new MaidLayer(this));
    }
}
