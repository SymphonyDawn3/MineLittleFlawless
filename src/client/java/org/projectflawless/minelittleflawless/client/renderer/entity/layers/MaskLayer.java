package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.MarionetteModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.MaskModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.MarionetteRenderer;
import org.projectflawless.minelittleflawless.entity.Marionette;

public class MaskLayer extends RenderLayer<Marionette, MarionetteModel> {
    private final MaskModel model = new MaskModel(Minecraft.getInstance().getEntityModels()
            .bakeLayer(MaskModel.LAYER_LOCATION));

    public MaskLayer(MarionetteRenderer renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Marionette livingEntity,
                       float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw,
                       float headPitch) {
        RenderLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model,
                this.getTextureLocation(livingEntity), poseStack, buffer, packedLight, livingEntity, limbSwing,
                limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTick, 1.0f, 1.0f, 1.0f);
    }

    @Override
    protected ResourceLocation getTextureLocation(Marionette entity) {
        return new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/mask.png");
    }
}
