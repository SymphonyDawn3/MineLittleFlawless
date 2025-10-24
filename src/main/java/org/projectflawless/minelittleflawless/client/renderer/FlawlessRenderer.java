package org.projectflawless.minelittleflawless.client.renderer;

import org.projectflawless.minelittleflawless.procedures.IfFlawlessIsTamedProcedure;
import org.projectflawless.minelittleflawless.entity.FlawlessEntity;
import org.projectflawless.minelittleflawless.client.model.ModelFriendshipBow;
import org.projectflawless.minelittleflawless.client.model.ModelFlawless;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FlawlessRenderer extends MobRenderer<FlawlessEntity, LivingEntityRenderState, ModelFlawless> {
	private FlawlessEntity entity = null;

	public FlawlessRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFlawless(context.bakeLayer(ModelFlawless.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minelittleflawless:textures/entities/friendship_bow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, LivingEntityRenderState state, float headYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (IfFlawlessIsTamedProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new ModelFriendshipBow(Minecraft.getInstance().getEntityModels().bakeLayer(ModelFriendshipBow.LAYER_LOCATION));
					model.setupAnim(state);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(state, 0));
				}
			}
		});
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(FlawlessEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("minelittleflawless:textures/entities/flawless.png");
	}

	@Override
	protected void scale(LivingEntityRenderState state, PoseStack poseStack) {
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}
}