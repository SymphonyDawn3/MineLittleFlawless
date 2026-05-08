package org.projectflawless.minelittleflawless.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.world.entity.Entity;

public abstract class AdultAndBabyPonyModel<E extends Entity> extends HierarchicalModel<E> {
    private final float adultScaleFactor;
    private final float babyScaleFactor;
    private final float adultDownY;
    private final float babyDownY;

    public AdultAndBabyPonyModel() {
        this(1.0f, 0.5f, 0.0f, 21.2086f);
    }

    public AdultAndBabyPonyModel(float babyScaleFactor, float babyDownY) {
        this(1.0f, babyScaleFactor, 0.0f, babyDownY);
    }

    public AdultAndBabyPonyModel(float adultScaleFactor, float babyScaleFactor, float adultDownY, float babyDownY) {
        this.adultScaleFactor = adultScaleFactor;
        this.babyScaleFactor = babyScaleFactor;
        this.adultDownY = adultDownY;
        this.babyDownY = babyDownY;
    }
    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();

        if (this.young) {
            poseStack.scale(this.babyScaleFactor, this.babyScaleFactor, this.babyScaleFactor);
            poseStack.translate(0.0f, this.babyDownY / 16.0f, 0.0f);
        } else {
            poseStack.scale(this.adultScaleFactor, this.adultScaleFactor, this.adultScaleFactor);
            poseStack.translate(0.0f, this.adultDownY / 16.0f, 0.0f);
        }

        super.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

        poseStack.popPose();
    }
}
