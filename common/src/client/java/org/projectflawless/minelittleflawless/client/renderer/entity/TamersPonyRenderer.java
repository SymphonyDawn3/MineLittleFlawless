package org.projectflawless.minelittleflawless.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.PonySize;
import org.projectflawless.minelittleflawless.client.model.entity.TamersPonyModel;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Optional;

public class TamersPonyRenderer<T extends TamableTamersPony, M extends TamersPonyModel<T>> extends GeoEntityRenderer<T> {
    private final float BABY_BODY_SCALE_FACTOR = 0.4f;
    private final float BABY_HEAD_SCALE_FACTOR = 1.5f;
    private final PonySize ponySize;

    public TamersPonyRenderer(EntityRendererProvider.Context context, M model) {
        this(context, model, PonySize.MEDIUM);
    }
    public TamersPonyRenderer(EntityRendererProvider.Context context, M model, PonySize ponySize) {
        super(context, model);
        this.ponySize = ponySize;
    }

    @Override
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

        // Get the bones of the entity.
        Optional<GeoBone> root = model.getBone("root");
        Optional<GeoBone> head = model.getBone("head");
        Optional<GeoBone> rightArm = model.getBone("rightArm");
        Optional<GeoBone> leftArm = model.getBone("leftArm");
        Optional<GeoBone> rightLeg = model.getBone("rightLeg");
        Optional<GeoBone> leftLeg = model.getBone("leftLeg");

        root.ifPresent(bone -> {
            if (animatable.isBaby()) {
                bone.setScaleX(this.ponySize.scale*0.4f);
                bone.setScaleY(this.ponySize.scale*0.4f);
                bone.setScaleZ(this.ponySize.scale*0.4f);
            } else {
                bone.setScaleX(this.ponySize.scale);
                bone.setScaleY(this.ponySize.scale);
                bone.setScaleZ(this.ponySize.scale);
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

        root.ifPresent(bone -> {
            if (animatable.isBaby()) {
                if (animatable.isInSittingPose())
                    bone.setPosY(-0.875f*(this.ponySize.scale*BABY_BODY_SCALE_FACTOR)/BABY_BODY_SCALE_FACTOR);
                else
                    bone.setPosY(-1.5f*(this.ponySize.scale*BABY_BODY_SCALE_FACTOR)/BABY_BODY_SCALE_FACTOR);
            }
        });
    }
}
