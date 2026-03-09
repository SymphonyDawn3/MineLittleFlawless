package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.TrixiebelleModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.TrixiebelleJesterModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.TrixiebelleRenderer;
import org.projectflawless.minelittleflawless.entity.Trixiebelle;

public class TrixiebelleJesterLayer extends RenderLayer<Trixiebelle, TrixiebelleModel> {
    private final TrixiebelleJesterModel model = new TrixiebelleJesterModel(Minecraft.getInstance().getEntityModels()
            .bakeLayer(TrixiebelleJesterModel.LAYER_LOCATION));

    public TrixiebelleJesterLayer(TrixiebelleRenderer renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Trixiebelle livingEntity,
                       float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw,
                       float headPitch) {
        RenderLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model,
                this.getTextureLocation(livingEntity), poseStack, buffer, packedLight, livingEntity,
                limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTick, 1.0f, 1.0f, 1.0f);
    }

    @Override
    protected ResourceLocation getTextureLocation(Trixiebelle entity) {
        return new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/trixiebelle_jester.png");
    }
}
