package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.TrixieModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.TrixieGirModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.TrixieRenderer;
import org.projectflawless.minelittleflawless.entity.Trixie;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class TrixieGirLayer extends ClothingLayer<Trixie, TrixieModel> {
    public TrixieGirLayer(TrixieRenderer renderer) {
        super(renderer, new TrixieGirModel());
    }

    @Override
    public void render(PoseStack poseStack, Trixie animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.TRIXIE_GIR))
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
    }
}
