package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.TricolorJubileeModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.TricolorJubileeClownModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.TricolorJubileeRenderer;
import org.projectflawless.minelittleflawless.entity.TricolorJubilee;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class TricolorJubileeClownLayer extends ClothingLayer<TricolorJubilee, TricolorJubileeModel> {
    public TricolorJubileeClownLayer(TricolorJubileeRenderer renderer) {
        super(renderer, new TricolorJubileeClownModel());
    }

    @Override
    public void render(PoseStack poseStack, TricolorJubilee animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.TRICOLOR_JUBILEE_CLOWN)) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
