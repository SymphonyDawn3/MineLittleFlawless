package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.client.renderer.entity.SkywishesRenderer;
import org.projectflawless.minelittleflawless.entity.Skywishes;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class SkywishesGlowMaskLayer extends GeoRenderLayer<Skywishes> {
    public SkywishesGlowMaskLayer(SkywishesRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public ResourceLocation getTextureResource(Skywishes animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "textures/entity/skywishes_glowmask.png");
    }

    @Override
    public void render(PoseStack poseStack, Skywishes animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType emissiveRenderType = RenderType.entityTranslucentEmissive(this.getTextureResource(animatable));

        this.getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, emissiveRenderType, bufferSource.getBuffer(emissiveRenderType), partialTick, LightTexture.FULL_SKY, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
    }
}
