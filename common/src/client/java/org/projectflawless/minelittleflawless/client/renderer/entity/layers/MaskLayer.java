package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.MarionetteModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.MaskModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.MarionetteRenderer;
import org.projectflawless.minelittleflawless.entity.Marionette;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class MaskLayer extends ClothingLayer<Marionette, MarionetteModel> {
    public MaskLayer(MarionetteRenderer renderer) {
        super(renderer, new MaskModel());
    }

    @Override
    public void render(PoseStack poseStack, Marionette animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.MASK)) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
