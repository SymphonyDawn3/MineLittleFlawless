package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.JackieSpectre;

public class JackieSpectreModel extends TamersPonyModel<JackieSpectre> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "jackie_spectre_model"), "main");

    public JackieSpectreModel(ModelPart root) {
        super(root, 0.7f, 0.35f, 10.2f, 44.7f);
    }

    @Override
    public void prepareMobModel(JackieSpectre entity, float limbSwing, float limbSwingAmount, float partialTick) {
        this.stallion.visible = false;
        this.wings.visible = false;
        this.horn.visible = false;
    }
}
