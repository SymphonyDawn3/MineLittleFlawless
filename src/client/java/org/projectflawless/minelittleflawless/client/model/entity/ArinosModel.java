package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Arinos;

public class ArinosModel extends TamersPonyModel<Arinos> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "arinos_model"), "main");

	public ArinosModel(ModelPart root) {
        super(root);
	}

    @Override
    public void prepareMobModel(Arinos entity, float limbSwing, float limbSwingAmount, float partialTick) {
        this.stallion.visible = false;
        this.extendedRight.visible = false;
        this.extendedLeft.visible = false;
    }
}