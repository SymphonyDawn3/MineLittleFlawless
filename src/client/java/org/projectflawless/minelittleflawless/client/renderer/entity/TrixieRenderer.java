package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.TrixieModel;
import org.projectflawless.minelittleflawless.entity.Trixie;

public class TrixieRenderer extends TamersPonyRenderer<Trixie, TrixieModel> {
    public TrixieRenderer(EntityRendererProvider.Context context) {
        super(context, new TrixieModel(context.bakeLayer(TrixieModel.LAYER_LOCATION)),
                new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/trixie.png"));
    }
}
