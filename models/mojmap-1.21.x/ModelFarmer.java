// Made with Blockbench 5.0.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelFarmer<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "farmer"), "main");
	private final ModelPart head;
	private final ModelPart hat;
	private final ModelPart hatString;
	private final ModelPart hatKnot;
	private final ModelPart body;
	private final ModelPart jacket;

	public ModelFarmer(ModelPart root) {
		this.head = root.getChild("head");
		this.hat = this.head.getChild("hat");
		this.hatString = this.hat.getChild("hatString");
		this.hatKnot = this.hatString.getChild("hatKnot");
		this.body = root.getChild("body");
		this.jacket = this.body.getChild("jacket");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(),
				PartPose.offset(0.0F, -1.0F, -8.0F));

		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 2.0F));

		PartDefinition cube_r1 = hat.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -2.0F, 0.0F, 10.0F, 1.0F, 11.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, -5.0F, -6.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r2 = hat.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(32, 12).addBox(-8.0F, -8.0F, 1.0F, 7.0F, 7.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, -5.0F, -6.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition hatString = hat.addOrReplaceChild("hatString", CubeListBuilder.create().texOffs(0, 12).addBox(
				-4.0F, -4.0F, -4.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -1.0F, -2.0F));

		PartDefinition hatKnot = hatString.addOrReplaceChild("hatKnot",
				CubeListBuilder.create().texOffs(32, 38)
						.addBox(-1.0F, 5.5F, -1.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 38)
						.addBox(0.0F, 7.5F, -1.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 41)
						.addBox(-2.0F, 7.5F, -1.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition jacket = body.addOrReplaceChild("jacket",
				CubeListBuilder.create().texOffs(0, 29)
						.addBox(-4.0F, -20.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)).texOffs(32, 26)
						.addBox(-4.0F, -20.0F, -8.5F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
	}
}