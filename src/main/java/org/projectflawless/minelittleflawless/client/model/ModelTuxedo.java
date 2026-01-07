package org.projectflawless.minelittleflawless.client.model;

import net.minecraft.client.model.AgeableHierarchicalModel;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

// Made with Blockbench 5.0.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelTuxedo extends AgeableHierarchicalModel<FlawlessEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("minelittleflawless", "model_tuxedo"), "main");

    public final ModelPart root;
	public final ModelPart head;
	public final ModelPart hat;
	public final ModelPart body;
	public final ModelPart jacket;
	public final ModelPart bowtie;
	public final ModelPart leftArm;
	public final ModelPart leftSleeve;
	public final ModelPart rightArm;
	public final ModelPart rightSleeve;

	public ModelTuxedo(ModelPart root) {
        super(0.5f, 21.2086f);
        this.root = root;
        this.head = root.getChild("head");
		this.hat = this.head.getChild("hat");
		this.body = root.getChild("body");
		this.jacket = this.body.getChild("jacket");
		this.bowtie = this.body.getChild("bowtie");
		this.leftArm = root.getChild("leftArm");
		this.leftSleeve = this.leftArm.getChild("leftSleeve");
		this.rightArm = root.getChild("rightArm");
		this.rightSleeve = this.rightArm.getChild("rightSleeve");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -8.0F));
		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 2.0F));
		PartDefinition cube_r1 = hat.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -2.0F, 0.0F, 10.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -5.0F, -6.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r2 = hat.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 29).addBox(-8.0F, -8.0F, 1.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -5.0F, -6.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition jacket = body.addOrReplaceChild("jacket",
				CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -20.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)).texOffs(28, 29).addBox(-4.0F, -20.0F, -8.5F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bowtie = body.addOrReplaceChild("bowtie", CubeListBuilder.create().texOffs(42, 0).addBox(-1.0F, -20.0F, -9.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(42, 2)
				.addBox(-2.0F, -21.0F, -9.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(42, 6).addBox(1.0F, -21.0F, -9.75F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(2.0F, 11.0F, -5.0F));
		PartDefinition leftSleeve = leftArm.addOrReplaceChild("leftSleeve", CubeListBuilder.create().texOffs(32, 13).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(-2.0F, 11.0F, -5.0F));
		PartDefinition rightSleeve = rightArm.addOrReplaceChild("rightSleeve", CubeListBuilder.create().texOffs(28, 41).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
	public void setupAnim(FlawlessEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}