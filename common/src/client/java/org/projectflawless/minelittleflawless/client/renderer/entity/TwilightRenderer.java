package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.TwilightModel;
import org.projectflawless.minelittleflawless.entity.Twilight;

public class TwilightRenderer extends TamersPonyRenderer<Twilight, TwilightModel> {
    public TwilightRenderer(EntityRendererProvider.Context context) {
        super(context, new TwilightModel());
    }
}
