package org.projectflawless.minelittleflawless.client.renderer;

import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import org.projectflawless.minelittleflawless.init.MinelittleflawlessModItems;
import org.projectflawless.minelittleflawless.entity.FlawlessEntity;
import org.projectflawless.minelittleflawless.client.renderer.state.FlawlessEntityRenderState;
import org.projectflawless.minelittleflawless.client.model.*;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FlawlessRenderer extends MobRenderer<FlawlessEntity, FlawlessEntityRenderState, ModelFlawless> {
	private FlawlessEntity entity = null;

	public FlawlessRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFlawless(context.bakeLayer(ModelFlawless.LAYER_LOCATION)), 0.5f);
        this.addLayer(new RenderLayer<>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minelittleflawless:textures/entities/flawless_magician_clothing.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FlawlessEntityRenderState state, float headYaw, float headPitch) {
				if (state.flawlessClothing.equals(MinelittleflawlessModItems.FLAWLESS_MAGICIAN_CLOTHING.get().toString())) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel<FlawlessEntityRenderState> model = new ModelFlawlessMagicianClothing(Minecraft.getInstance().getEntityModels().bakeLayer(ModelFlawlessMagicianClothing.LAYER_LOCATION));
                    model.setupAnim(state);
                    model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(state, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minelittleflawless:textures/entities/tuxedo.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FlawlessEntityRenderState state, float headYaw, float headPitch) {
				if (state.flawlessClothing.equals(MinelittleflawlessModItems.TUXEDO.get().toString())) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
                    EntityModel<FlawlessEntityRenderState> model = new ModelTuxedo(Minecraft.getInstance().getEntityModels().bakeLayer(ModelTuxedo.LAYER_LOCATION));
                    model.setupAnim(state);
                    model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(state, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minelittleflawless:textures/entities/farmer.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FlawlessEntityRenderState state, float headYaw, float headPitch) {
				if (state.flawlessClothing.equals(MinelittleflawlessModItems.FARMER.get().toString())) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel<FlawlessEntityRenderState> model = new ModelFarmer(Minecraft.getInstance().getEntityModels().bakeLayer(ModelFarmer.LAYER_LOCATION));
                    model.setupAnim(state);
                    model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(state, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minelittleflawless:textures/entities/pajamas.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FlawlessEntityRenderState state, float headYaw, float headPitch) {
				if (state.flawlessClothing.equals(MinelittleflawlessModItems.PAJAMAS.get().toString())) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel<FlawlessEntityRenderState> model = new ModelPajamas(Minecraft.getInstance().getEntityModels().bakeLayer(ModelPajamas.LAYER_LOCATION));
                    model.setupAnim(state);
                    model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(state, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minelittleflawless:textures/entities/schoolgirl.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FlawlessEntityRenderState state, float headYaw, float headPitch) {
				if (state.flawlessClothing.equals(MinelittleflawlessModItems.SCHOOLGIRL.get().toString())) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel<FlawlessEntityRenderState> model = new ModelSchoolgirl(Minecraft.getInstance().getEntityModels().bakeLayer(ModelSchoolgirl.LAYER_LOCATION));
                    model.setupAnim(state);
                    model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(state, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minelittleflawless:textures/entities/rockstar.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FlawlessEntityRenderState state, float headYaw, float headPitch) {
				if (state.flawlessClothing.equals(MinelittleflawlessModItems.ROCKSTAR.get().toString())) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel<FlawlessEntityRenderState> model = new ModelRockstar(Minecraft.getInstance().getEntityModels().bakeLayer(ModelRockstar.LAYER_LOCATION));
                    model.setupAnim(state);
                    model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(state, 0));
				}
			}
		});
	}

	@Override
	public FlawlessEntityRenderState createRenderState() {
		return new FlawlessEntityRenderState();
	}

	@Override
	public void extractRenderState(FlawlessEntity entity, FlawlessEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
        state.flawlessClothing = entity.getEntityData().get(FlawlessEntity.DATA_flawlessClothing);
	}

	@Override
	public ResourceLocation getTextureLocation(FlawlessEntityRenderState state) {
		return ResourceLocation.parse("minelittleflawless:textures/entities/flawless.png");
	}

	@Override
	protected void scale(FlawlessEntityRenderState state, PoseStack poseStack) {
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}
}