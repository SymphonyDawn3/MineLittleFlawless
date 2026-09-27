package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.TrixieModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.TrixieBlackMagicianLayer;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.TrixieGirLayer;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.TrixieMagicianLayer;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.TrixieSchoolgirlLayer;
import org.projectflawless.minelittleflawless.entity.Trixie;

public class TrixieRenderer extends TamersPonyRenderer<Trixie, TrixieModel> {
    public TrixieRenderer(EntityRendererProvider.Context context) {
        super(context, new TrixieModel());
        this.addRenderLayer(new TrixieMagicianLayer(this));
        this.addRenderLayer(new TrixieBlackMagicianLayer(this));
        this.addRenderLayer(new TrixieGirLayer(this));
        this.addRenderLayer(new TrixieSchoolgirlLayer(this));
    }
}
