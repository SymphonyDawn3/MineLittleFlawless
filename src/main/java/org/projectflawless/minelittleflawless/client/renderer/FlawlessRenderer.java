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
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

import java.util.List;
import java.util.function.Function;

public class FlawlessRenderer extends MobRenderer<FlawlessEntity, FlawlessEntityRenderState, ModelFlawless> {
	private FlawlessEntity entity = null;
    private List<FlawlessClothingRenderLayer> flawlessClothingRenderLayers =
            List.of(new FlawlessMagicianClothingRenderLayer(), new TuxedoRenderLayer(), new FarmerRenderLayer(),
                    new PajamasRenderLayer(), new SchoolgirlRenderLayer(), new RockstarRenderLayer());

	public FlawlessRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFlawless(context.bakeLayer(ModelFlawless.LAYER_LOCATION)), 0.5f);
        this.flawlessClothingRenderLayers.forEach(this::addLayer);
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

    public class FlawlessClothingRenderLayer extends RenderLayer<FlawlessEntityRenderState, ModelFlawless> {
        final protected static EntityModelSet entityModels = Minecraft.getInstance().getEntityModels();
        final public ResourceLocation layerTexture;
        final public EntityModel<FlawlessEntityRenderState> model;
        final public Function<ResourceLocation, RenderType> renderTypeGetter;
        final public String flawlessClothing;
        public VertexConsumer vertexConsumer;

        public FlawlessClothingRenderLayer(
                ResourceLocation layerTexture, EntityModel<FlawlessEntityRenderState> model,
                Function<ResourceLocation, RenderType> renderTypeGetter, String flawlessClothing) {
            super(FlawlessRenderer.this);
            this.layerTexture = layerTexture;
            this.model = model;
            this.renderTypeGetter = renderTypeGetter;
            this.flawlessClothing = flawlessClothing;
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FlawlessEntityRenderState state, float headYaw, float headPitch) {
            if (state.flawlessClothing.equals(this.flawlessClothing)) {
                this.vertexConsumer = bufferSource.getBuffer(this.renderTypeGetter.apply(this.layerTexture));
                this.renderClothing(state, poseStack, light);
            }
        }

        protected void renderClothing(FlawlessEntityRenderState state, PoseStack poseStack, int light) {
            this.model.setupAnim(state);
            this.model.renderToBuffer(poseStack, this.vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(state, 0));
        }
    }

    public class FlawlessMagicianClothingRenderLayer extends FlawlessClothingRenderLayer {
        public FlawlessMagicianClothingRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/flawless_magician_clothing.png"),
                    new ModelFlawlessMagicianClothing(entityModels.bakeLayer(ModelFlawlessMagicianClothing.LAYER_LOCATION)),
                    RenderType::entityCutoutNoCull,
                    MinelittleflawlessModItems.FLAWLESS_MAGICIAN_CLOTHING.get().toString()
            );
        }
    }

    public class TuxedoRenderLayer extends FlawlessClothingRenderLayer {
        public TuxedoRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/tuxedo.png"),
                    new ModelTuxedo(entityModels.bakeLayer(ModelTuxedo.LAYER_LOCATION)),
                    RenderType::entityCutoutNoCull,
                    MinelittleflawlessModItems.TUXEDO.get().toString()
            );
        }
    }

    public class FarmerRenderLayer extends FlawlessClothingRenderLayer {
        public FarmerRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/farmer.png"),
                    new ModelFarmer(entityModels.bakeLayer(ModelFarmer.LAYER_LOCATION)),
                    RenderType::entityCutoutNoCull,
                    MinelittleflawlessModItems.FARMER.get().toString()
            );
        }
    }

    public class PajamasRenderLayer extends FlawlessClothingRenderLayer {
        public PajamasRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/pajamas.png"),
                    new ModelPajamas(entityModels.bakeLayer(ModelPajamas.LAYER_LOCATION)),
                    RenderType::eyes,
                    MinelittleflawlessModItems.PAJAMAS.get().toString()
            );
        }
    }

    public class SchoolgirlRenderLayer extends FlawlessClothingRenderLayer {
        public SchoolgirlRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/schoolgirl.png"),
                    new ModelSchoolgirl(entityModels.bakeLayer(ModelSchoolgirl.LAYER_LOCATION)),
                    RenderType::entityCutoutNoCull,
                    MinelittleflawlessModItems.SCHOOLGIRL.get().toString()
            );
        }
    }

    public class RockstarRenderLayer extends FlawlessClothingRenderLayer {
        public RockstarRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/rockstar.png"),
                    new ModelRockstar(entityModels.bakeLayer(ModelRockstar.LAYER_LOCATION)),
                    RenderType::entityCutoutNoCull,
                    MinelittleflawlessModItems.ROCKSTAR.get().toString()
            );
        }
    }
}