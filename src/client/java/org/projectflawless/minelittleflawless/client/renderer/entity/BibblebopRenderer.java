package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.PonySize;
import org.projectflawless.minelittleflawless.client.model.entity.BibblebopModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.BibblebopClownLayer;
import org.projectflawless.minelittleflawless.entity.Bibblebop;

public class BibblebopRenderer extends TamersPonyRenderer<Bibblebop, BibblebopModel> {
    public BibblebopRenderer(EntityRendererProvider.Context context) {
        super(context, new BibblebopModel(), PonySize.LARGE);
        this.addRenderLayer(new BibblebopClownLayer(this));
    }
}
