package org.projectflawless.minelittleflawless.client.renderer.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import org.projectflawless.minelittleflawless.client.model.entity.projectile.LaserModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.LaserGlowMaskLayer;
import org.projectflawless.minelittleflawless.entity.projectile.Laser;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Optional;

public class LaserRenderer extends GeoEntityRenderer<Laser> {
    public LaserRenderer(EntityRendererProvider.Context context) {
        super(context, new LaserModel());
        this.addRenderLayer(new LaserGlowMaskLayer(this));
    }

    @Override
    public void preRender(PoseStack poseStack, Laser animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Optional<GeoBone> optionalRoot = model.getBone("root_laser");
        optionalRoot.ifPresent(geoBone -> {
            geoBone.setRotX(animatable.getXRot() * Mth.DEG_TO_RAD);
            geoBone.setRotY(animatable.getYRot() * Mth.DEG_TO_RAD);
        });

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public Color getRenderColor(Laser animatable, float partialTick, int packedLight) {
        return animatable.getLaserColor();
    }
}
