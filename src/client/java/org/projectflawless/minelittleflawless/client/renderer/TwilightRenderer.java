package org.projectflawless.minelittleflawless.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.TwilightModel;
import org.projectflawless.minelittleflawless.entity.Twilight;

public class TwilightRenderer extends MobRenderer<Twilight, TwilightModel> {
    public TwilightRenderer(EntityRendererProvider.Context context) {
        super(context, new TwilightModel(context.bakeLayer(TwilightModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Twilight entity) {
        return new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/twilight.png");
    }
}
