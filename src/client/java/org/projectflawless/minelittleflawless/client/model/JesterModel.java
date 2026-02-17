package org.projectflawless.minelittleflawless.client.model;

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.AgeableHierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Arinos;

public class JesterModel extends AgeableHierarchicalModel<Arinos> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "jester_model"), "main");

    private final ModelPart root;
    private final ModelPart body;
	private final ModelPart jester;
	private final ModelPart bowtie;
	private final ModelPart socks;
	private final ModelPart rightArmSock;
	private final ModelPart leftLegSock;
	private final ModelPart leftArmSock;
	private final ModelPart rightLegSock;
	private final ModelPart head;
	private final ModelPart jingalings;

	public JesterModel(ModelPart root) {
        super(0.5f, 21.2086f);
        this.root = root;
        this.body = this.root.getChild("body");
		this.jester = this.body.getChild("jester");
		this.bowtie = this.body.getChild("bowtie");
		this.socks = this.body.getChild("socks");
		this.rightArmSock = this.socks.getChild("rightArmSock");
		this.leftLegSock = this.socks.getChild("leftLegSock");
		this.leftArmSock = this.socks.getChild("leftArmSock");
		this.rightLegSock = this.socks.getChild("rightLegSock");
		this.head = this.body.getChild("head");
		this.jingalings = this.head.getChild("jingalings");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 5.3333F, 0.3333F));

		PartDefinition jester = body.addOrReplaceChild("jester", CubeListBuilder.create().texOffs(0, 34).addBox(-4.0F, -1.3333F, -9.3333F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.3F))
		.texOffs(0, 0).addBox(-4.0F, -1.3333F, -4.7333F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bowtie = body.addOrReplaceChild("bowtie", CubeListBuilder.create().texOffs(48, 50).addBox(-1.0F, -1.25F, -10.3333F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 46).addBox(-4.0F, -2.25F, -10.5833F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 50).addBox(1.0F, -2.25F, -10.5833F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bowtie.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 50).addBox(-1.0F, -3.0F, 0.7167F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.0F, -11.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition cube_r2 = bowtie.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 50).addBox(-2.0F, -3.0F, 0.7167F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 3.0F, -11.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition socks = body.addOrReplaceChild("socks", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightArmSock = socks.addOrReplaceChild("rightArmSock", CubeListBuilder.create().texOffs(24, 34).addBox(0.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 2.6667F, -5.3333F));

		PartDefinition leftLegSock = socks.addOrReplaceChild("leftLegSock", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 2.6667F, 3.6667F));

		PartDefinition leftArmSock = socks.addOrReplaceChild("leftArmSock", CubeListBuilder.create().texOffs(40, 34).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 2.6667F, -5.3333F));

		PartDefinition rightLegSock = socks.addOrReplaceChild("rightLegSock", CubeListBuilder.create().texOffs(0, 46).addBox(0.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 2.6667F, 3.6667F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -5.3333F, -7.3333F));

		PartDefinition jingalings = head.addOrReplaceChild("jingalings", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = jingalings.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 20).addBox(-5.0F, -7.25F, -3.75F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(40, 16).addBox(-5.0F, -5.75F, 5.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.0469F, 0.8118F, -0.3762F, -0.1153F, -0.2835F));

		PartDefinition cube_r4 = jingalings.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(46, 16).addBox(4.0F, -5.75F, 5.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, -7.25F, -3.75F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.0469F, 0.8118F, -0.3762F, 0.1153F, 0.2835F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
	public void setupAnim(Arinos entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rightArmSock.xRot = Mth.cos(limbSwing) * limbSwingAmount;
        this.leftLegSock.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
        this.rightLegSock.xRot = Mth.cos(limbSwing) * limbSwingAmount;
        this.leftArmSock.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
	}
}