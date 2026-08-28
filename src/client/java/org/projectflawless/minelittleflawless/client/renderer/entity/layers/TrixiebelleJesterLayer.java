package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.TrixiebelleModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.TrixiebelleJesterModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.TrixiebelleRenderer;
import org.projectflawless.minelittleflawless.entity.Trixiebelle;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class TrixiebelleJesterLayer extends ClothingLayer<Trixiebelle, TrixiebelleModel> {
    public TrixiebelleJesterLayer(TrixiebelleRenderer renderer) {
        super(renderer, new TrixiebelleJesterModel());
    }

    @Override
    public void render(PoseStack poseStack, Trixiebelle animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.TRIXIEBELLE_JESTER)) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
