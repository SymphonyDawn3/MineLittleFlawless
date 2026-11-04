package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.client.model.entity.SkywishesModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.SkywishesDraculaModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.SkywishesRenderer;
import org.projectflawless.minelittleflawless.entity.Skywishes;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class SkywishesDraculaLayer extends ClothingLayer<Skywishes, SkywishesModel> {

    public SkywishesDraculaLayer(SkywishesRenderer renderer) {
        super(renderer, new SkywishesDraculaModel());
    }

    @Override
    public void render(PoseStack poseStack, Skywishes animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.getClothing().equals(Clothing.SKYWISHES_DRACULA)) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
