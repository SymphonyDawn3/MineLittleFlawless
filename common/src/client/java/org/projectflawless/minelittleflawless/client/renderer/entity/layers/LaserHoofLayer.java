package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.projectflawless.minelittleflawless.client.model.entity.SkywishesModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.LaserHoofModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.SkywishesRenderer;
import org.projectflawless.minelittleflawless.entity.Skywishes;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import java.util.Optional;

public class LaserHoofLayer extends ClothingLayer<Skywishes, SkywishesModel> {
    public LaserHoofLayer(SkywishesRenderer renderer) {
        super(renderer, new LaserHoofModel());
    }

    @Override
    public void render(PoseStack poseStack, Skywishes animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        Optional<GeoBone> laserRightArm = this.model.getBone("rightArm");
        Optional<GeoBone> laserLeftArm = this.model.getBone("leftArm");
        if (animatable.isAiming()) {
            laserRightArm.ifPresent(geoBone -> geoBone.setHidden(!animatable.isLeftHanded()));
            laserLeftArm.ifPresent(geoBone -> geoBone.setHidden(animatable.isLeftHanded()));

            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }
}
