package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.LastLaughModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.LastLaughClownModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.TamersPonyRenderer;
import org.projectflawless.minelittleflawless.entity.LastLaugh;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class LastLaughClownLayer extends ClothingLayer<LastLaugh, LastLaughModel> {
    public LastLaughClownLayer(TamersPonyRenderer<LastLaugh, LastLaughModel> renderer) {
        super(renderer, new LastLaughClownModel());
    }

    @Override
    public void render(PoseStack poseStack, LastLaugh animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.LAST_LAUGH_CLOWN)) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
