package org.projectflawless.minelittleflawless.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.TrixiebelleJesterModel;
import org.projectflawless.minelittleflawless.client.model.entity.TrixiebelleModel;
import org.projectflawless.minelittleflawless.entity.Trixiebelle;

public class TrixiebelleRenderer extends MobRenderer<Trixiebelle, TrixiebelleModel> {
    public TrixiebelleRenderer(EntityRendererProvider.Context context) {
        super(context, new TrixiebelleModel(context.bakeLayer(TrixiebelleModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new RenderLayer<>(this) {
            private final TrixiebelleJesterModel model = new TrixiebelleJesterModel(context.getModelSet().bakeLayer(TrixiebelleJesterModel.LAYER_LOCATION));

            @Override
            public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Trixiebelle livingEntity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
                RenderLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model,
                        this.getTextureLocation(livingEntity), poseStack, buffer, packedLight, livingEntity,
                        limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTick, 1.0f, 1.0f, 1.0f);
            }

            @Override
            protected ResourceLocation getTextureLocation(Trixiebelle entity) {
                return new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/trixiebelle_jester.png");
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(Trixiebelle entity) {
        return new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/trixiebelle.png");
    }
}
