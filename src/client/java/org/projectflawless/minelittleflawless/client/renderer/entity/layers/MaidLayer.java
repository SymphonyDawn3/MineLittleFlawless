package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.client.model.entity.StarCatcherModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.MaidModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.StarCatcherRenderer;
import org.projectflawless.minelittleflawless.entity.StarCatcher;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class MaidLayer extends ClothingLayer<StarCatcher, StarCatcherModel> {
    public MaidLayer(StarCatcherRenderer renderer) {
        super(renderer, new MaidModel());
    }

    @Override
    public void render(PoseStack poseStack, StarCatcher animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.canPickUpLoot()) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
