package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.TrixiebelleModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.TrixiebelleJesterLayer;
import org.projectflawless.minelittleflawless.entity.Trixiebelle;

public class TrixiebelleRenderer extends TamersPonyRenderer<Trixiebelle, TrixiebelleModel> {
    public TrixiebelleRenderer(EntityRendererProvider.Context context) {
        super(context, new TrixiebelleModel(context.bakeLayer(TrixiebelleModel.LAYER_LOCATION)),
                new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/trixiebelle.png"));

        this.addLayer(new TrixiebelleJesterLayer(this));
    }
}
