package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.BibblebopModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.BibblebopClownModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.BibblebopRenderer;
import org.projectflawless.minelittleflawless.entity.Bibblebop;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class BibblebopClownLayer extends ClothingLayer<Bibblebop, BibblebopModel> {
    public BibblebopClownLayer(BibblebopRenderer renderer) {
        super(renderer, new BibblebopClownModel());
    }

    @Override
    public void render(PoseStack poseStack, Bibblebop animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.BIBBLEBOP_CLOWN)) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
