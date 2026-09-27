package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.CherryChucklesModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.CherryChucklesClownModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.TamersPonyRenderer;
import org.projectflawless.minelittleflawless.entity.CherryChuckles;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class CherryChucklesClownLayer extends ClothingLayer<CherryChuckles, CherryChucklesModel> {
    public CherryChucklesClownLayer(TamersPonyRenderer<CherryChuckles, CherryChucklesModel> renderer) {
        super(renderer, new CherryChucklesClownModel());
    }

    @Override
    public void render(PoseStack poseStack, CherryChuckles animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.CHERRY_CHUCKLES_CLOWN)) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
