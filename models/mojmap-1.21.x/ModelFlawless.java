// Made with Blockbench 5.0.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelFlawless<T extends FlawlessEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "flawless"), "main");
	private final ModelPart head;
	private final ModelPart Hair;
	private final ModelPart snoutFemale;
	private final ModelPart horn;
	private final ModelPart hornGlow;
	private final ModelPart Realhat;
	private final ModelPart Body;
	private final ModelPart abdomen;
	private final ModelPart jacket;
	private final ModelPart tail;
	private final ModelPart tailBody;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart tail4;
	private final ModelPart neck;
	private final ModelPart neckFix;
	private final ModelPart neckFix2;
	private final ModelPart ears;
	private final ModelPart rightLeg;
	private final ModelPart rightPants;
	private final ModelPart leftLeg;
	private final ModelPart leftPants;
	private final ModelPart leftArm;
	private final ModelPart leftSleeve;
	private final ModelPart rightArm;
	private final ModelPart rightSleeve;

	public ModelFlawless(ModelPart root) {
		this.head = root.getChild("head");
		this.Hair = this.head.getChild("Hair");
		this.snoutFemale = this.head.getChild("snoutFemale");
		this.horn = this.head.getChild("horn");
		this.hornGlow = this.horn.getChild("hornGlow");
		this.Realhat = this.head.getChild("Realhat");
		this.Body = root.getChild("Body");
		this.abdomen = this.Body.getChild("abdomen");
		this.jacket = this.Body.getChild("jacket");
		this.tail = this.Body.getChild("tail");
		this.tailBody = this.tail.getChild("tailBody");
		this.tail2 = this.tailBody.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
		this.tail4 = this.tail3.getChild("tail4");
		this.neck = this.Body.getChild("neck");
		this.neckFix = this.neck.getChild("neckFix");
		this.neckFix2 = this.neckFix.getChild("neckFix2");
		this.ears = this.Body.getChild("ears");
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

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 13).addBox(
				-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -8.0F));

		PartDefinition Hair = head.addOrReplaceChild("Hair", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F,
				-4.0F, -4.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition snoutFemale = head.addOrReplaceChild("snoutFemale",
				CubeListBuilder.create().texOffs(60, 45)
						.addBox(-2.0F, 0.0F, -1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(60, 57)
						.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 2.0F, -4.0F));

		PartDefinition horn = head
				.addOrReplaceChild("horn",
						CubeListBuilder.create().texOffs(60, 52).addBox(-0.5F, -11.0F, -3.5F, 1.0F, 4.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 2.0F, 2.0F, 0.5061F, 0.0F, 0.0F));

		PartDefinition hornGlow = horn.addOrReplaceChild("hornGlow", CubeListBuilder.create().texOffs(64, 52).addBox(
				-0.5F, -11.0F, -3.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Realhat = head.addOrReplaceChild("Realhat", CubeListBuilder.create(),
				PartPose.offset(0.0F, 1.0F, 2.0F));

		PartDefinition cube_r1 = Realhat.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -2.0F, 0.0F, 10.0F, 2.0F, 11.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, -5.0F, -6.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Realhat.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(32, 45).addBox(-8.0F, -8.0F, 1.0F, 7.0F, 7.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, -5.0F, -6.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition abdomen = Body.addOrReplaceChild("abdomen",
				CubeListBuilder.create().texOffs(42, 0)
						.addBox(-4.0F, -20.0F, -8.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 29)
						.addBox(-4.0F, -20.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(16, 75)
						.addBox(-4.0F, -20.0F, 4.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(66, 0)
						.addBox(-4.0F, -16.0F, 4.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jacket = Body.addOrReplaceChild("jacket",
				CubeListBuilder.create().texOffs(0, 46)
						.addBox(-4.0F, -20.0F, 4.5F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F)).texOffs(0, 30)
						.addBox(-4.0F, -20.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)).texOffs(0, 58)
						.addBox(-4.0F, -20.0F, -8.5F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = Body.addOrReplaceChild("tail",
				CubeListBuilder.create().texOffs(24, 46).addBox(-1.0F, -4.0F, -0.5F, 2.0F, 6.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -20.0F, 8.0F, -1.0647F, 0.0F, 0.0F));

		PartDefinition tailBody = tail
				.addOrReplaceChild("tailBody",
						CubeListBuilder.create().texOffs(56, 75).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 1.0647F, 0.0F, 0.0F));

		PartDefinition tail2 = tailBody.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(72, 76).addBox(
				-2.0F, -21.0F, 6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -8.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(80, 8).addBox(-2.0F,
				-17.0F, 6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(80, 16).addBox(-2.0F,
				-13.0F, 6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition neck = Body.addOrReplaceChild("neck",
				CubeListBuilder.create().texOffs(40, 75).addBox(-2.0F, 1.2F, -2.8F, 4.0F, 4.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, -6.0F, 0.1571F, 0.0F, 0.0F));

		PartDefinition neckFix = neck.addOrReplaceChild("neckFix", CubeListBuilder.create(),
				PartPose.offset(0.0F, -1.0F, -2.0F));

		PartDefinition neckFix2 = neckFix.addOrReplaceChild("neckFix2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1571F, 0.0F, 0.0F));

		PartDefinition ears = Body.addOrReplaceChild("ears",
				CubeListBuilder.create().texOffs(24, 54)
						.addBox(4.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(60, 48)
						.addBox(-6.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -25.0F, -8.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(72, 44)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 11.0F, 4.0F));

		PartDefinition rightPants = rightLeg.addOrReplaceChild("rightPants", CubeListBuilder.create().texOffs(72, 60)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(64, 28)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 11.0F, 4.0F));

		PartDefinition leftPants = leftLeg.addOrReplaceChild("leftPants", CubeListBuilder.create().texOffs(0, 70)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(24, 59)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 11.0F, -5.0F));

		PartDefinition leftSleeve = leftArm.addOrReplaceChild("leftSleeve", CubeListBuilder.create().texOffs(40, 59)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(56, 59)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 11.0F, -5.0F));

		PartDefinition rightSleeve = rightArm.addOrReplaceChild("rightSleeve", CubeListBuilder.create().texOffs(64, 12)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.rightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}