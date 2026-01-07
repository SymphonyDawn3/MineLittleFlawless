package org.projectflawless.minelittleflawless.client.renderer;

import org.projectflawless.minelittleflawless.entity.Flawless;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;
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

public class FlawlessRenderer extends MobRenderer<Flawless, FlawlessModel> {
	private Flawless entity = null;

    public FlawlessRenderer(EntityRendererProvider.Context context) {
		super(context, new FlawlessModel(context.bakeLayer(FlawlessModel.LAYER_LOCATION)), 0.5f);

        List<FlawlessClothingRenderLayer> flawlessClothingRenderLayers = List.of(new FlawlessMagicianClothingRenderLayer(), new TuxedoRenderLayer(), new FarmerRenderLayer(),
                new PajamasRenderLayer(), new SchoolgirlRenderLayer(), new RockstarRenderLayer());

        flawlessClothingRenderLayers.forEach(this::addLayer);
	}

	@Override
	public ResourceLocation getTextureLocation(Flawless entity) {
		return ResourceLocation.parse("minelittleflawless:textures/entities/flawless.png");
	}

    public class FlawlessClothingRenderLayer extends RenderLayer<Flawless, FlawlessModel> {
        final protected static EntityModelSet entityModels = Minecraft.getInstance().getEntityModels();
        final public ResourceLocation layerTexture;
        final public AgeableHierarchicalModel<Flawless> model;
        final public String flawlessClothing;
        public VertexConsumer vertexConsumer;

        public FlawlessClothingRenderLayer(
                ResourceLocation layerTexture, AgeableHierarchicalModel<Flawless> model, String flawlessClothing) {
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
                Flawless entity,
                float limbSwing,
                float limbSwingAmount,
                float partialTick,
                float ageInTicks,
                float netHeadYaw,
                float headPitch) {
            if (entity.getEntityData().get(Flawless.DATA_flawlessClothing).equals(this.flawlessClothing)) {
                this.vertexConsumer = bufferSource.getBuffer(this.model.renderType(this.layerTexture));
                this.renderClothing(entity, poseStack, light, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            }
        }

        protected void renderClothing(
                Flawless entity,
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
                    new FlawlessMagicianClothingModel(entityModels.bakeLayer(FlawlessMagicianClothingModel.LAYER_LOCATION)),
                    MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING.get().toString()
            );
        }
    }

    public class TuxedoRenderLayer extends FlawlessClothingRenderLayer {
        public TuxedoRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/tuxedo.png"),
                    new TuxedoModel(entityModels.bakeLayer(TuxedoModel.LAYER_LOCATION)),
                    MineLittleFlawlessItems.TUXEDO.get().toString()
            );
        }
    }

    public class FarmerRenderLayer extends FlawlessClothingRenderLayer {
        public FarmerRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/farmer.png"),
                    new FarmerModel(entityModels.bakeLayer(FarmerModel.LAYER_LOCATION)),
                    MineLittleFlawlessItems.FARMER.get().toString()
            );
        }
    }

    public class PajamasRenderLayer extends FlawlessClothingRenderLayer {
        public PajamasRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/pajamas.png"),
                    new PajamasModel(entityModels.bakeLayer(PajamasModel.LAYER_LOCATION)),
                    MineLittleFlawlessItems.PAJAMAS.get().toString()
            );
        }
    }

    public class SchoolgirlRenderLayer extends FlawlessClothingRenderLayer {
        public SchoolgirlRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/schoolgirl.png"),
                    new SchoolgirlModel(entityModels.bakeLayer(SchoolgirlModel.LAYER_LOCATION)),
                    MineLittleFlawlessItems.SCHOOLGIRL.get().toString()
            );
        }
    }

    public class RockstarRenderLayer extends FlawlessClothingRenderLayer {
        public RockstarRenderLayer() {
            super(
                    ResourceLocation.parse("minelittleflawless:textures/entities/rockstar.png"),
                    new RockstarModel(entityModels.bakeLayer(RockstarModel.LAYER_LOCATION)),
                    MineLittleFlawlessItems.ROCKSTAR.get().toString()
            );
        }
    }
}