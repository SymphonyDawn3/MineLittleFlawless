package org.projectflawless.minelittleflawless.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.TrixieModel;
import org.projectflawless.minelittleflawless.entity.Trixie;

public class TrixieRenderer extends MobRenderer<Trixie, TrixieModel> {
    public TrixieRenderer(EntityRendererProvider.Context context) {
        super(context, new TrixieModel(context.bakeLayer(TrixieModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Trixie entity) {
        return new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/trixie.png");
    }
}
