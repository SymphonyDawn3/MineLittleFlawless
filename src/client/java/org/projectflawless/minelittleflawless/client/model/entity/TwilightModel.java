package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Twilight;

public class TwilightModel extends TamersPonyModel<Twilight> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "twilight_model"), "main");

	public TwilightModel(ModelPart root) {
        super(root);
	}

    @Override
    public void prepareMobModel(Twilight entity, float limbSwing, float limbSwingAmount, float partialTick) {
        this.stallion.visible = false;
        this.wings.visible = false;
    }
}