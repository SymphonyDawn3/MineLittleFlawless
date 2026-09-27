package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.client.model.entity.FlawlessModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;
import org.projectflawless.minelittleflawless.entity.Flawless;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class FlawlessClothingRenderLayer extends ClothingLayer<Flawless, FlawlessModel> {
    public final ResourceLocation flawlessClothing;

    public FlawlessClothingRenderLayer(FlawlessRenderer renderer, AdultAndBabyPonyModel<Flawless> model, ResourceLocation flawlessClothing) {
        super(renderer, model);
        this.flawlessClothing = flawlessClothing;
    }

    @Override
    public void render(PoseStack poseStack, Flawless animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(this.flawlessClothing)) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
