package org.projectflawless.minelittleflawless.client.model;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

// Made with Blockbench 5.0.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelFlawless extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("minelittleflawless", "model_flawless"), "main");
	public final ModelPart head;
	public final ModelPart ears;
	public final ModelPart hair;
	public final ModelPart snoutFemale;
	public final ModelPart horn;
	public final ModelPart hornGlow;
	public final ModelPart hat;
	public final ModelPart body;
	public final ModelPart abdomen;
	public final ModelPart jacket;
	public final ModelPart tail;
	public final ModelPart tailBody;
	public final ModelPart tail2;
	public final ModelPart tail3;
	public final ModelPart tail4;
	public final ModelPart neck;
	public final ModelPart rightLeg;
	public final ModelPart rightPants;
	public final ModelPart leftLeg;
	public final ModelPart leftPants;
	public final ModelPart leftArm;
	public final ModelPart leftSleeve;
	public final ModelPart rightArm;
	public final ModelPart rightSleeve;

	public ModelFlawless(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
		this.ears = this.head.getChild("ears");
		this.hair = this.head.getChild("hair");
		this.snoutFemale = this.head.getChild("snoutFemale");
		this.horn = this.head.getChild("horn");
		this.hornGlow = this.horn.getChild("hornGlow");
		this.hat = this.head.getChild("hat");
		this.body = root.getChild("body");
		this.abdomen = this.body.getChild("abdomen");
		this.jacket = this.body.getChild("jacket");
		this.tail = this.body.getChild("tail");
		this.tailBody = this.tail.getChild("tailBody");
		this.tail2 = this.tailBody.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
		this.tail4 = this.tail3.getChild("tail4");
		this.neck = this.body.getChild("neck");
		this.rightLeg = root.getChild("rightLeg");
		this.rightPants = this.rightLeg.getChild("rightPants");
		this.leftLeg = root.getChild("leftLeg");
		this.leftPants = this.leftLeg.getChild("leftPants");
		this.leftArm = root.getChild("leftArm");
		this.leftSleeve = this.leftArm.getChild("leftSleeve");
		this.rightArm = root.getChild("rightArm");
		this.rightSleeve = this.rightArm.getChild("rightSleeve");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 13).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -8.0F));
		PartDefinition ears = head.addOrReplaceChild("ears",
				CubeListBuilder.create().texOffs(24, 54).addBox(4.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(60, 48).addBox(-6.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition hair = head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition snoutFemale = head.addOrReplaceChild("snoutFemale",
				CubeListBuilder.create().texOffs(60, 45).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(60, 57).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 2.0F, -4.0F));
		PartDefinition horn = head.addOrReplaceChild("horn", CubeListBuilder.create().texOffs(60, 52).addBox(-0.5F, -11.0F, -3.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 2.0F, 0.5061F, 0.0F, 0.0F));
		PartDefinition hornGlow = horn.addOrReplaceChild("hornGlow", CubeListBuilder.create().texOffs(64, 52).addBox(-0.5F, -11.0F, -3.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 2.0F));
		PartDefinition cube_r1 = hat.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -2.0F, 0.0F, 10.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -5.0F, -6.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r2 = hat.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 45).addBox(-8.0F, -8.0F, 1.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -5.0F, -6.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition abdomen = body.addOrReplaceChild("abdomen",
				CubeListBuilder.create().texOffs(42, 0).addBox(-4.0F, -20.0F, -8.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 29).addBox(-4.0F, -20.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(16, 75)
						.addBox(-4.0F, -20.0F, 4.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(66, 0).addBox(-4.0F, -16.0F, 4.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition jacket = body.addOrReplaceChild("jacket", CubeListBuilder.create().texOffs(0, 46).addBox(-4.0F, -20.0F, 4.5F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F)).texOffs(0, 30)
				.addBox(-4.0F, -20.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)).texOffs(0, 58).addBox(-4.0F, -20.0F, -8.5F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(24, 46).addBox(-1.0F, -4.0F, -0.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.0F, 8.0F, -1.0647F, 0.0F, 0.0F));
		PartDefinition tailBody = tail.addOrReplaceChild("tailBody", CubeListBuilder.create().texOffs(56, 75).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 1.0647F, 0.0F, 0.0F));
		PartDefinition tail2 = tailBody.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(72, 76).addBox(-2.0F, -21.0F, 6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -8.0F));
		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(80, 8).addBox(-2.0F, -17.0F, 6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(80, 16).addBox(-2.0F, -13.0F, 6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(40, 75).addBox(-2.0F, 1.2F, -2.8F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, -6.0F, 0.1571F, 0.0F, 0.0F));
		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(72, 44).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 11.0F, 4.0F));
		PartDefinition rightPants = rightLeg.addOrReplaceChild("rightPants", CubeListBuilder.create().texOffs(72, 60).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(64, 28).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 11.0F, 4.0F));
		PartDefinition leftPants = leftLeg.addOrReplaceChild("leftPants", CubeListBuilder.create().texOffs(0, 70).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(24, 59).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 11.0F, -5.0F));
		PartDefinition leftSleeve = leftArm.addOrReplaceChild("leftSleeve", CubeListBuilder.create().texOffs(40, 59).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(56, 59).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 11.0F, -5.0F));
		PartDefinition rightSleeve = rightArm.addOrReplaceChild("rightSleeve", CubeListBuilder.create().texOffs(64, 12).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}