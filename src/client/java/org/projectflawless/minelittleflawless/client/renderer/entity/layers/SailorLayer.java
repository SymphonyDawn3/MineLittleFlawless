package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.JackieSpectreModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.SailorModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.JackieSpectreRenderer;
import org.projectflawless.minelittleflawless.entity.JackieSpectre;

public class SailorLayer extends RenderLayer<JackieSpectre, JackieSpectreModel> {
    private final SailorModel model = new SailorModel(Minecraft.getInstance().getEntityModels()
            .bakeLayer(SailorModel.LAYER_LOCATION));

    public SailorLayer(JackieSpectreRenderer renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, JackieSpectre livingEntity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model,
                this.getTextureLocation(livingEntity), poseStack, buffer, packedLight, livingEntity,
                limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTick, 1.0f, 1.0f, 1.0f);
    }

    @Override
    protected ResourceLocation getTextureLocation(JackieSpectre entity) {
        return new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/sailor.png");
    }
}
