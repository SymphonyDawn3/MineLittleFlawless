package org.projectflawless.minelittleflawless.client.model.entity.clothing;

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.Marionette;

public class MaskModel extends AdultAndBabyPonyModel<Marionette> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(MineLittleFlawless.MOD_ID, "mask_model"), "main");

    private final ModelPart root;
	private final ModelPart head;

	public MaskModel(ModelPart root) {
        super(0.5f, 21.2086f);
        this.root = root;
		ModelPart body = this.root.getChild("body");
		this.head = body.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 5.3333F, 0.3333F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -5.3333F, -7.3333F));

		PartDefinition mask = head.addOrReplaceChild("mask", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		mask.addOrReplaceChild("ears", CubeListBuilder.create().texOffs(10, 16).addBox(-4.2F, -8.75F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F))
		.texOffs(10, 16).mirror().addBox(2.2F, -8.75F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition snout = mask.addOrReplaceChild("snout", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		snout.addOrReplaceChild("mare", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.2F, -7.75F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(18, 16).addBox(-1.0F, -1.3F, -7.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
	public void setupAnim(Marionette entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
	}
}