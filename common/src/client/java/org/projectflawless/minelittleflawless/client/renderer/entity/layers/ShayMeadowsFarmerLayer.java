package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.ShayMeadowsModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.ShayMeadowsFarmerModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.ShayMeadowsRenderer;
import org.projectflawless.minelittleflawless.entity.ShayMeadows;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class ShayMeadowsFarmerLayer extends ClothingLayer<ShayMeadows, ShayMeadowsModel> {
    public ShayMeadowsFarmerLayer(ShayMeadowsRenderer renderer) {
        super(renderer, new ShayMeadowsFarmerModel());
    }

    @Override
    public void render(PoseStack poseStack, ShayMeadows animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.SHAY_MEADOWS_FARMER)) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
