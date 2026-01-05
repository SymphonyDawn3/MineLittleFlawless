package org.projectflawless.minelittleflawless.client.renderer;

import org.projectflawless.minelittleflawless.entity.BartlebyEntity;
import org.projectflawless.minelittleflawless.client.model.ModelBartleby;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BartlebyRenderer extends MobRenderer<BartlebyEntity, LivingEntityRenderState, ModelBartleby> {
	public BartlebyRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBartleby(context.bakeLayer(ModelBartleby.LAYER_LOCATION)), 1f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(BartlebyEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("minelittleflawless:textures/entities/bartleby.png");
	}
}