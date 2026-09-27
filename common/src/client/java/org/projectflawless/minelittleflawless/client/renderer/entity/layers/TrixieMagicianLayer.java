package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.TrixieModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.TrixieMagicianModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.TrixieRenderer;
import org.projectflawless.minelittleflawless.entity.Trixie;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class TrixieMagicianLayer extends ClothingLayer<Trixie, TrixieModel> {
    public TrixieMagicianLayer(TrixieRenderer renderer) {
        super(renderer, new TrixieMagicianModel());
    }

    @Override
    public void render(PoseStack poseStack, Trixie animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.TRIXIE_MAGICIAN))
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
    }
}
