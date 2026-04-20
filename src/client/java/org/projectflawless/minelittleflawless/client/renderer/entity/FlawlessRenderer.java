package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.FlawlessModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.*;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.*;
import org.projectflawless.minelittleflawless.entity.Flawless;
import org.projectflawless.minelittleflawless.client.model.*;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FlawlessRenderer extends TamersPonyRenderer<Flawless, FlawlessModel> {
    public FlawlessRenderer(EntityRendererProvider.Context context) {
		super(context, new FlawlessModel(context.bakeLayer(FlawlessModel.LAYER_LOCATION)),
                new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/flawless.png"));

        this.addLayer(new FlawlessMagicianClothingRenderLayer(this));
        this.addLayer(new TuxedoRenderLayer(this));
        this.addLayer(new FarmerRenderLayer(this));
        this.addLayer(new PajamasRenderLayer(this));
        this.addLayer(new SchoolgirlRenderLayer(this));
        this.addLayer(new RockstarRenderLayer(this));
        this.addLayer(new RenderLayer<>(this) {

            private final UnicornHornCoronaModel model = new UnicornHornCoronaModel(Minecraft.getInstance().getEntityModels().bakeLayer(UnicornHornCoronaModel.LAYER_LOCATION));

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, Flawless entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
                if (!entity.getMainHandItem().isEmpty()) {
                    this.getParentModel().copyPropertiesTo(model);
                    VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(new ResourceLocation(MineLittleFlawless.MOD_ID, "flawless_horn_corona")));
                    this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                    this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, LivingEntityRenderer.getOverlayCoords(entity, 0), -1, -1, -1, -1);
                }
            }
        });
    }
}