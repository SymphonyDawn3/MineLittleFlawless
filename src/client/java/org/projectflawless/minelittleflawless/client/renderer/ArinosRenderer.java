package org.projectflawless.minelittleflawless.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.ArinosModel;
import org.projectflawless.minelittleflawless.client.model.JesterModel;
import org.projectflawless.minelittleflawless.entity.Arinos;

public class ArinosRenderer extends MobRenderer<Arinos, ArinosModel> {
    public ArinosRenderer(EntityRendererProvider.Context context) {
        super(context, new ArinosModel(context.bakeLayer(ArinosModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new RenderLayer<>(this) {
            private final JesterModel model = new JesterModel(context.getModelSet().bakeLayer(JesterModel.LAYER_LOCATION));

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, Arinos livingEntity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
                RenderLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model,
                        this.getTextureLocation(livingEntity), poseStack, bufferSource, packedLight, livingEntity,
                        limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTick, 1.0f, 1.0f, 1.0f);
            }

            @Override
            protected ResourceLocation getTextureLocation(Arinos entity) {
                return new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/jester.png");
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(Arinos entity) {
        return new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/arinos.png");
    }
}
