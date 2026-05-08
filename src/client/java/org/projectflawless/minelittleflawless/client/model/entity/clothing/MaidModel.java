package org.projectflawless.minelittleflawless.client.model.entity.clothing;

// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.StarCatcher;

public class MaidModel extends AdultAndBabyPonyModel<StarCatcher> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "maid_model"), "main");

    private final ModelPart root;
	private final ModelPart head;
	private final ModelPart rightSleeve;
	private final ModelPart leftSkirt;
	private final ModelPart leftSleeve;
	private final ModelPart rightSkirt;

	public MaidModel(ModelPart root) {
        super(1.45f, 0.725f, -7.25f, 7.0f);
        this.root = root;
		ModelPart body = this.root.getChild("body");
		this.head = body.getChild("head");
		this.rightSleeve = body.getChild("rightSleeve");
		this.leftSkirt = body.getChild("leftSkirt");
		this.leftSleeve = body.getChild("leftSleeve");
		this.rightSkirt = body.getChild("rightSkirt");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 5.3333F, 0.3333F));

		body.addOrReplaceChild("maidDress", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -1.3333F, -9.3333F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(0, 0).addBox(-4.0F, -1.3333F, -4.8333F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -5.3333F, -7.3333F));

		head.addOrReplaceChild("maidCap", CubeListBuilder.create().texOffs(40, 0).addBox(-3.0F, -9.0F, -5.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		body.addOrReplaceChild("rightSleeve", CubeListBuilder.create().texOffs(24, 20).addBox(0.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 2.6667F, -5.3333F));

		body.addOrReplaceChild("leftSkirt", CubeListBuilder.create().texOffs(16, 36).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.offset(0.0F, 2.6667F, 3.6667F));

		body.addOrReplaceChild("leftSleeve", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 2.6667F, -5.3333F));

		body.addOrReplaceChild("rightSkirt", CubeListBuilder.create().texOffs(32, 36).addBox(0.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.offset(0.0F, 2.6667F, 3.6667F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(StarCatcher entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rightSleeve.xRot = Mth.cos(limbSwing) * limbSwingAmount;
        this.leftSkirt.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
        this.head.yRot = netHeadYaw / (180f / (float) Math.PI);
        this.head.xRot = headPitch / (180f / (float) Math.PI);
        this.rightSkirt.xRot = Mth.cos(limbSwing) * limbSwingAmount;
        this.leftSleeve.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
    }
}