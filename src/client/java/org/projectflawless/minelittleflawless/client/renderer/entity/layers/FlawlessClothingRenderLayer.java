package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.client.model.entity.FlawlessModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;
import org.projectflawless.minelittleflawless.entity.Flawless;

public class FlawlessClothingRenderLayer extends RenderLayer<Flawless, FlawlessModel> {
    protected static final EntityModelSet entityModels = Minecraft.getInstance().getEntityModels();
    public final ResourceLocation layerTexture;
    public final AdultAndBabyPonyModel<Flawless> model;
    public final String flawlessClothing;
    public VertexConsumer vertexConsumer;

    public FlawlessClothingRenderLayer(FlawlessRenderer renderer, ResourceLocation layerTexture,
                                       AdultAndBabyPonyModel<Flawless> model, String flawlessClothing) {
        super(renderer);
        this.layerTexture = layerTexture;
        this.model = model;
        this.flawlessClothing = flawlessClothing;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, Flawless entity, float limbSwing,
            float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getEntityData().get(Flawless.DATA_CLOTHING).equals(this.flawlessClothing)) {
            this.vertexConsumer = bufferSource.getBuffer(this.model.renderType(this.layerTexture));
            this.renderClothing(entity, poseStack, light, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        }
    }

    protected void renderClothing(Flawless entity, PoseStack poseStack, int light, float limbSwing,
                                  float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getParentModel().copyPropertiesTo(this.model);
        this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.model.renderToBuffer(poseStack, this.vertexConsumer, light,
                LivingEntityRenderer.getOverlayCoords(entity, 0), 1.0f, 1.0f, 1.0f, 1.0f);
    }
}
