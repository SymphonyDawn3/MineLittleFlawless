package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.client.model.entity.TamersPonyModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.TamersPonyRenderer;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import java.util.Optional;

public class ClothingLayer<E extends TamableTamersPony, M extends TamersPonyModel<E>> extends GeoRenderLayer<E> {
    private final AdultAndBabyPonyModel<E> model;

    public ClothingLayer(TamersPonyRenderer<E, M> renderer, AdultAndBabyPonyModel<E> model) {
        super(renderer);
        this.model = model;
    }

    @Override
    public void render(PoseStack poseStack, E animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        BakedGeoModel bakedModel2 = this.model.getBakedModel(this.model.getModelResource(animatable));
        RenderType renderType2 = this.model.getRenderType(animatable, this.model.getTextureResource(animatable));

        for (CoreGeoBone layeredBone : this.model.getAnimationProcessor().getRegisteredBones()) {
            Optional<GeoBone> mainBone = this.getRenderer().getGeoModel().getBone(layeredBone.getName());

            mainBone.ifPresent(bone -> {
                layeredBone.setPosX(bone.getPosX());
                layeredBone.setPosY(bone.getPosY());
                layeredBone.setPosZ(bone.getPosZ());

                layeredBone.setScaleX(bone.getScaleX());
                layeredBone.setScaleY(bone.getScaleY());
                layeredBone.setScaleZ(bone.getScaleZ());

                layeredBone.setRotX(bone.getRotX());
                layeredBone.setRotY(bone.getRotY());
                layeredBone.setRotZ(bone.getRotZ());
            });
        }
        this.getRenderer().reRender(bakedModel2, poseStack, bufferSource, animatable, renderType2, bufferSource.getBuffer(renderType2), partialTick,
                packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
    }
}
