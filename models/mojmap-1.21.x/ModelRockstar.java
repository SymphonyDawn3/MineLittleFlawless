// Made with Blockbench 5.0.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelRockstar<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "rockstar"), "main");
	private final ModelPart body;
	private final ModelPart jacket;
	private final ModelPart guitar;
	private final ModelPart bandana;
	private final ModelPart rightLeg;
	private final ModelPart rightPants;
	private final ModelPart leftLeg;
	private final ModelPart leftPants;
	private final ModelPart leftArm;
	private final ModelPart leftSleeve;
	private final ModelPart rightArm;
	private final ModelPart rightSleeve;

	public ModelRockstar(ModelPart root) {
		this.body = root.getChild("body");
		this.jacket = this.body.getChild("jacket");
		this.guitar = this.body.getChild("guitar");
		this.bandana = this.body.getChild("bandana");
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

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition jacket = body.addOrReplaceChild("jacket",
				CubeListBuilder.create().texOffs(0, 16)
						.addBox(-4.0F, -20.0F, 4.5F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F)).texOffs(0, 0)
						.addBox(-4.0F, -20.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)).texOffs(24, 16)
						.addBox(-4.0F, -20.0F, -8.5F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition guitar = body.addOrReplaceChild("guitar",
				CubeListBuilder.create().texOffs(0, 44)
						.addBox(-0.5F, -3.0F, -3.8333F, 1.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(40, 44)
						.addBox(-0.5F, -1.0F, -11.8333F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(48, 5)
						.addBox(-1.0F, -2.0F, -14.8333F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(48, 15)
						.addBox(-0.5F, -3.0F, -12.825F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 17)
						.addBox(-0.5F, -3.0F, -14.825F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 19)
						.addBox(-0.5F, 2.0F, -12.825F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 21)
						.addBox(-0.5F, 2.0F, -14.825F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.75F, -16.0F, -0.1667F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bandana = body.addOrReplaceChild("bandana",
				CubeListBuilder.create().texOffs(48, 23)
						.addBox(-0.5F, -21.5F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 44)
						.addBox(-3.0F, -22.0F, -9.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(48, 0)
						.addBox(-3.0F, -20.0F, -9.75F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 12)
						.addBox(-1.0F, -16.0F, -9.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create(),
				PartPose.offset(-2.0F, 11.0F, 4.0F));

		PartDefinition rightPants = rightLeg.addOrReplaceChild("rightPants", CubeListBuilder.create().texOffs(32, 28)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create(),
				PartPose.offset(2.0F, 11.0F, 4.0F));

		PartDefinition leftPants = leftLeg.addOrReplaceChild("leftPants", CubeListBuilder.create().texOffs(32, 0)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create(),
				PartPose.offset(2.0F, 11.0F, -5.0F));

		PartDefinition leftSleeve = leftArm.addOrReplaceChild("leftSleeve", CubeListBuilder.create().texOffs(0, 28)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create(),
				PartPose.offset(-2.0F, 11.0F, -5.0F));

		PartDefinition rightSleeve = rightArm.addOrReplaceChild("rightSleeve", CubeListBuilder.create().texOffs(16, 28)
				.addBox(-2.0F, 1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.rightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.leftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}