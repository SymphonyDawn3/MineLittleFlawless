package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Trixiebelle;

public class TrixiebelleModel extends TamersPonyModel<Trixiebelle> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "trixiebelle_model"), "main");

	public TrixiebelleModel(ModelPart root) {
        super(root, 0.7f, 0.35f, 10.2f, 44.7f);
	}

    @Override
    public void prepareMobModel(Trixiebelle entity, float limbSwing, float limbSwingAmount, float partialTick) {
        this.stallion.visible = false;
        this.wings.visible = false;
    }
}