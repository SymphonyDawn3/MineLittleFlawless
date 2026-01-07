package org.projectflawless.minelittleflawless.client.renderer;

import org.projectflawless.minelittleflawless.entity.BartlebyEntity;
import org.projectflawless.minelittleflawless.client.model.ModelBartleby;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BartlebyRenderer extends MobRenderer<BartlebyEntity, ModelBartleby> {
	public BartlebyRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBartleby(context.bakeLayer(ModelBartleby.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(BartlebyEntity entity) {
		return ResourceLocation.parse("minelittleflawless:textures/entities/bartleby.png");
	}
}