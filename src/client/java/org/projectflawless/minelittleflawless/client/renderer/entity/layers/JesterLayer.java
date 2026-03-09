package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.ArinosModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.JesterModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.ArinosRenderer;
import org.projectflawless.minelittleflawless.entity.Arinos;

public class JesterLayer extends RenderLayer<Arinos, ArinosModel> {
    private final JesterModel model = new JesterModel(Minecraft.getInstance().getEntityModels()
            .bakeLayer(JesterModel.LAYER_LOCATION));

    public JesterLayer(ArinosRenderer renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, Arinos livingEntity,
                       float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw,
                       float headPitch) {
        RenderLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model,
                this.getTextureLocation(livingEntity), poseStack, bufferSource, packedLight, livingEntity,
                limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTick, 1.0f, 1.0f,
                1.0f);
    }

    @Override
    protected ResourceLocation getTextureLocation(Arinos entity) {
        return new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/jester.png");
    }
}
