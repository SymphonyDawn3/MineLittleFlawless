package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.FracturedModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.FracturedTuxedoModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FracturedRenderer;
import org.projectflawless.minelittleflawless.entity.Fractured;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class FracturedTuxedoLayer extends ClothingLayer<Fractured, FracturedModel> {
    public FracturedTuxedoLayer(FracturedRenderer renderer) {
        super(renderer, new FracturedTuxedoModel());
    }

    @Override
    public void render(PoseStack poseStack, Fractured animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.FRACTURED_TUXEDO)) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
