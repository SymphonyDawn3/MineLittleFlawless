package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.StarCatcherModel;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.MaidModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.StarCatcherRenderer;
import org.projectflawless.minelittleflawless.entity.StarCatcher;

public class MaidLayer extends RenderLayer<StarCatcher, StarCatcherModel> {
    private final MaidModel model = new MaidModel(Minecraft.getInstance().getEntityModels()
            .bakeLayer(MaidModel.LAYER_LOCATION));

    public MaidLayer(StarCatcherRenderer renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, StarCatcher livingEntity,
                       float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw,
                       float headPitch) {
        RenderLayer.coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model,
                this.getTextureLocation(livingEntity), poseStack, buffer, packedLight, livingEntity,
                limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTick, 1.0f, 1.0f, 1.0f);
    }

    @Override
    protected ResourceLocation getTextureLocation(StarCatcher entity) {
        return new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/maid.png");
    }
}
