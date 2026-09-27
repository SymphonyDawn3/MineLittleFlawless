package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.LastLaughModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.LastLaughClownLayer;
import org.projectflawless.minelittleflawless.entity.LastLaugh;

public class LastLaughRenderer extends TamersPonyRenderer<LastLaugh, LastLaughModel> {
    public LastLaughRenderer(EntityRendererProvider.Context context) {
        super(context, new LastLaughModel());
        this.addRenderLayer(new LastLaughClownLayer(this));
    }
}
