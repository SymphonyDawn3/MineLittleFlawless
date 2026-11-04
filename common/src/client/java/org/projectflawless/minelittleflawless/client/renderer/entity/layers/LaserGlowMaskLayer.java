package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import org.projectflawless.minelittleflawless.client.renderer.entity.projectile.LaserRenderer;
import org.projectflawless.minelittleflawless.entity.projectile.Laser;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.core.object.Color;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class LaserGlowMaskLayer extends GeoRenderLayer<Laser> {
    public LaserGlowMaskLayer(LaserRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack poseStack, Laser animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType emissiveRenderType = RenderType.entityTranslucentEmissive(this.getRenderer().getTextureLocation(animatable));
        Color laserColor = this.getRenderer().getRenderColor(animatable, partialTick, packedLight);

        this.getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, emissiveRenderType, bufferSource.getBuffer(emissiveRenderType), partialTick, LightTexture.FULL_SKY, OverlayTexture.NO_OVERLAY, laserColor.getRedFloat(), laserColor.getGreenFloat(), laserColor.getBlueFloat(), 1.0f);
    }
}
