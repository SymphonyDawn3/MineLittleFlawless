package org.projectflawless.minelittleflawless.client.renderer;

import org.projectflawless.minelittleflawless.init.MinelittleflawlessModItems;
import org.projectflawless.minelittleflawless.entity.FlawlessEntity;
import org.projectflawless.minelittleflawless.client.model.*;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.AgeableHierarchicalModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

import java.util.List;

public class FlawlessRenderer extends MobRenderer<FlawlessEntity, ModelFlawless> {
	private FlawlessEntity entity = null;

    public FlawlessRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFlawless(context.bakeLayer(ModelFlawless.LAYER_LOCATION)), 0.5f);

        List<FlawlessClothingRenderLayer> flawlessClothingRenderLayers = List.of(new FlawlessMagicianClothingRenderLayer(), new TuxedoRenderLayer(), new FarmerRenderLayer(),
                new PajamasRenderLayer(), new SchoolgirlRenderLayer(), new RockstarRenderLayer());

        flawlessClothingRenderLayers.forEach(this::addLayer);
	}

	@Override
	public ResourceLocation getTextureLocation(FlawlessEntity entity) {
		return ResourceLocation.parse("minelittleflawless:textures/entities/flawless.png");
	}

    public class FlawlessClothingRenderLayer extends RenderLayer<FlawlessEntity, ModelFlawless> {
        final protected static EntityModelSet entityModels = Minecraft.getInstance().getEntityModels();
        final public ResourceLocation layerTexture;
        final public AgeableHierarchicalModel<FlawlessEntity> model;
        final public String flawlessClothing;
        public VertexConsumer vertexConsumer;

        public FlawlessClothingRenderLayer(
                ResourceLocation layerTexture, AgeableHierarchicalModel<FlawlessEntity> model, String flawlessClothing) {
            super(FlawlessRenderer.this);
            this.layerTexture = layerTexture;
            this.model = model;
            this.flawlessClothing = flawlessClothing;
        }

        @Override
        public void render(
                PoseStack poseStack,
                MultiBufferSource bufferSource,
                int light,
                FlawlessEntity entity,
                float limbSwing,
                float limbSwingAmount,
                float partialTick,
                float ageInTicks,
                float netHeadYaw,
                float headPitch) {
            if (entity.getEntityData().get(FlawlessEntity.DATA_flawlessClothing).equals(this.flawlessClothing)) {
                this.vertexConsumer = bufferSource.getBuffer(this.model.renderType(this.layerTexture));
                this.renderClothing(entity, poseStack, light, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            }
        }

        protected void renderClothing(
                FlawlessEntity entity,
                PoseStack poseStack,
                int light,
                float limbSwing,
                float limbSwingAmount,
                float ageInTicks,
                float netHeadYaw,
                float headPitch) {
            FlawlessRenderer.this.model.copyPropertiesTo(this.model);
            this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            this.model.renderToBuffer(poseStack, this.vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
        }
    }

    public class FlawlessMagicianClothingRenderLayer extends FlawlessClothingRenderLayer {
        public FlawlessMagicianClothingRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/flawless_magician_clothing.png"),
                    new ModelFlawlessMagicianClothing(entityModels.bakeLayer(ModelFlawlessMagicianClothing.LAYER_LOCATION)),
                    MinelittleflawlessModItems.FLAWLESS_MAGICIAN_CLOTHING.get().toString()
            );
        }
    }

    public class TuxedoRenderLayer extends FlawlessClothingRenderLayer {
        public TuxedoRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/tuxedo.png"),
                    new ModelTuxedo(entityModels.bakeLayer(ModelTuxedo.LAYER_LOCATION)),
                    MinelittleflawlessModItems.TUXEDO.get().toString()
            );
        }
    }

    public class FarmerRenderLayer extends FlawlessClothingRenderLayer {
        public FarmerRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/farmer.png"),
                    new ModelFarmer(entityModels.bakeLayer(ModelFarmer.LAYER_LOCATION)),
                    MinelittleflawlessModItems.FARMER.get().toString()
            );
        }
    }

    public class PajamasRenderLayer extends FlawlessClothingRenderLayer {
        public PajamasRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/pajamas.png"),
                    new ModelPajamas(entityModels.bakeLayer(ModelPajamas.LAYER_LOCATION)),
                    MinelittleflawlessModItems.PAJAMAS.get().toString()
            );
        }
    }

    public class SchoolgirlRenderLayer extends FlawlessClothingRenderLayer {
        public SchoolgirlRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/schoolgirl.png"),
                    new ModelSchoolgirl(entityModels.bakeLayer(ModelSchoolgirl.LAYER_LOCATION)),
                    MinelittleflawlessModItems.SCHOOLGIRL.get().toString()
            );
        }
    }

    public class RockstarRenderLayer extends FlawlessClothingRenderLayer {
        public RockstarRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/rockstar.png"),
                    new ModelRockstar(entityModels.bakeLayer(ModelRockstar.LAYER_LOCATION)),
                    MinelittleflawlessModItems.ROCKSTAR.get().toString()
            );
        }
    }
}