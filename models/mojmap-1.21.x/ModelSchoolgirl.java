// Made with Blockbench 5.0.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelSchoolgirl<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "schoolgirl"), "main");
	private final ModelPart head;
	private final ModelPart earrings;
	private final ModelPart body;
	private final ModelPart jacket;
	private final ModelPart collar;
	private final ModelPart rightLeg;
	private final ModelPart rightPants;
	private final ModelPart leftLeg;
	private final ModelPart leftPants;
	private final ModelPart leftArm;
	private final ModelPart leftSleeve;
	private final ModelPart rightArm;
	private final ModelPart rightSleeve;

	public ModelSchoolgirl(ModelPart root) {
		this.head = root.getChild("head");
		this.earrings = this.head.getChild("earrings");
		this.body = root.getChild("body");
		this.jacket = this.body.getChild("jacket");
		this.collar = this.body.getChild("collar");
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

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(),
				PartPose.offset(0.0F, -1.0F, -8.0F));

		PartDefinition earrings = head.addOrReplaceChild("earrings", CubeListBuilder.create().texOffs(16, 44).addBox(
				4.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition jacket = body.addOrReplaceChild("jacket",
				CubeListBuilder.create().texOffs(0, 16)
						.addBox(-4.0F, -20.0F, 4.5F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F)).texOffs(0, 0)
						.addBox(-4.0F, -20.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)).texOffs(24, 16)
						.addBox(-4.0F, -20.0F, -8.5F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition collar = body.addOrReplaceChild("collar",
				CubeListBuilder.create().texOffs(0, 44).addBox(-2.0F, 1.2F, -2.8F, 4.0F, 4.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, -6.0F, 0.1571F, 0.0F, 0.0F));

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
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
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
		this.rightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}