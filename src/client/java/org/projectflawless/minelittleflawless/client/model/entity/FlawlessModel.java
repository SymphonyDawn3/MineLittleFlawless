package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Flawless;

public class FlawlessModel extends TamersPonyModel<Flawless> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "flawless_model"), "main");

	public FlawlessModel(ModelPart root) {
        super(root);
	}

    @Override
    public void prepareMobModel(Flawless entity, float limbSwing, float limbSwingAmount, float partialTick) {
        this.stallion.visible = false;
        this.wings.visible = false;
    }
}