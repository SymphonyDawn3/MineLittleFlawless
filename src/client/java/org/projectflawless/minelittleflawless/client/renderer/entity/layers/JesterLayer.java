package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.ArinosModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.JesterModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.ArinosRenderer;
import org.projectflawless.minelittleflawless.entity.Arinos;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class JesterLayer extends ClothingLayer<Arinos, ArinosModel> {
    public JesterLayer(ArinosRenderer renderer) {
        super(renderer, new JesterModel());
    }

    @Override
    public void render(PoseStack poseStack, Arinos animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.JESTER)) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
