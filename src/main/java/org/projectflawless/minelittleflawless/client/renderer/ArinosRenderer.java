package org.projectflawless.minelittleflawless.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.client.model.ArinosModel;
import org.projectflawless.minelittleflawless.entity.Arinos;

public class ArinosRenderer extends MobRenderer<Arinos, ArinosModel> {
    public ArinosRenderer(EntityRendererProvider.Context context) {
        super(context, new ArinosModel(context.bakeLayer(ArinosModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Arinos entity) {
        return ResourceLocation.parse("minelittleflawless:textures/entities/arinos.png");
    }
}
