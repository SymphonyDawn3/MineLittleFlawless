package org.projectflawless.minelittleflawless.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.TamersPonyModel;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Optional;

public class TamersPonyRenderer<T extends TamableTamersPony, M extends TamersPonyModel<T>> extends GeoEntityRenderer<T> {
    private final float BABY_HEAD_SCALE_FACTOR = 1.5f;
    private final float adultScaleFactor;
    private final float babyScaleFactor;

    public TamersPonyRenderer(EntityRendererProvider.Context context, M model) {
        this(context, model, 1.0f, 0.4f);
    }
    public TamersPonyRenderer(EntityRendererProvider.Context context, M model, float adultScaleFactor, float babyScaleFactor) {
        super(context, model);
        this.adultScaleFactor = adultScaleFactor;
        this.babyScaleFactor = babyScaleFactor;
    }

    @Override
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

        // Get the bones of the entity.
        Optional<GeoBone> body = model.getBone("body");
        Optional<GeoBone> head = model.getBone("head");
        Optional<GeoBone> rightArm = model.getBone("rightArm");
        Optional<GeoBone> leftArm = model.getBone("leftArm");
        Optional<GeoBone> rightLeg = model.getBone("rightLeg");
        Optional<GeoBone> leftLeg = model.getBone("leftLeg");

        body.ifPresent(bone -> {
            if (animatable.isBaby()) {
                bone.setScaleX(this.babyScaleFactor);
                bone.setScaleY(this.babyScaleFactor);
                bone.setScaleZ(this.babyScaleFactor);
            } else {
                bone.setScaleX(this.adultScaleFactor);
                bone.setScaleY(this.adultScaleFactor);
                bone.setScaleZ(this.adultScaleFactor);
            }
        });

        head.ifPresent(bone -> {
            if (animatable.isBaby()) {
                bone.setScaleX(BABY_HEAD_SCALE_FACTOR);
                bone.setScaleY(BABY_HEAD_SCALE_FACTOR);
                bone.setScaleZ(BABY_HEAD_SCALE_FACTOR);
            }
        });

        rightArm.ifPresent(bone -> {
            if (animatable.isBaby()) {
                bone.setScaleY(0.8f);
            }
        });

        leftArm.ifPresent(bone -> {
            if (animatable.isBaby()) {
                bone.setScaleY(0.8f);
            }
        });

        rightLeg.ifPresent(bone -> {
            if (animatable.isBaby()) {
                bone.setScaleY(0.8f);
            }
        });

        leftLeg.ifPresent(bone -> {
            if (animatable.isBaby()) {
                bone.setScaleY(0.8f);
            }
        });

        body.ifPresent(bone -> {
            if (animatable.isBaby()) {
                bone.setPosY(-1.5f*this.babyScaleFactor/0.4f);
            }
        });
    }
}
