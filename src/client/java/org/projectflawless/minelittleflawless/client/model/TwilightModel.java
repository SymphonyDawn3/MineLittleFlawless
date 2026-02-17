package org.projectflawless.minelittleflawless.client.model;// Made with Blockbench 5.0.7

import net.minecraft.client.model.AgeableHierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Twilight;

// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class TwilightModel extends AgeableHierarchicalModel<Twilight> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "twilight_model"), "main");

    private final ModelPart root;
    private final ModelPart body;
	private final ModelPart head;
	private final ModelPart ears;
	private final ModelPart horn;
	private final ModelPart snout;
	private final ModelPart mare;
	private final ModelPart neck;
	private final ModelPart mane;
	private final ModelPart tail;
	private final ModelPart tailStub;
	private final ModelPart tailLength;
	private final ModelPart rightArm;
	private final ModelPart leftLeg;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;

	public TwilightModel(ModelPart root) {
        super(0.5f, 21.2086f);
        this.root = root;
		this.body = this.root.getChild("body");
		this.head = this.body.getChild("head");
		this.ears = this.head.getChild("ears");
		this.horn = this.head.getChild("horn");
		this.snout = this.head.getChild("snout");
		this.mare = this.snout.getChild("mare");
		this.neck = this.body.getChild("neck");
		this.mane = this.neck.getChild("mane");
		this.tail = this.body.getChild("tail");
		this.tailStub = this.tail.getChild("tailStub");
		this.tailLength = this.tailStub.getChild("tailLength");
		this.rightArm = this.body.getChild("rightArm");
		this.leftLeg = this.body.getChild("leftLeg");
		this.leftArm = this.body.getChild("leftArm");
		this.rightLeg = this.body.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 36).addBox(-4.0F, -1.3333F, -9.3333F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -1.3333F, -5.3333F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.3333F, 0.3333F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(32, 20).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.3333F, -7.3333F));

		PartDefinition ears = head.addOrReplaceChild("ears", CubeListBuilder.create().texOffs(16, 48).addBox(-4.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 48).mirror().addBox(2.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition horn = head.addOrReplaceChild("horn", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone_r1 = horn.addOrReplaceChild("bone_r1", CubeListBuilder.create().texOffs(20, 64).addBox(-0.5F, -11.0F, -3.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5061F, 0.0F, 0.0F));

		PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition mare = snout.addOrReplaceChild("mare", CubeListBuilder.create().texOffs(50, 16).addBox(-2.0F, 0.0F, -7.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 24).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(32, 52).addBox(-2.0F, 1.0F, -2.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.3333F, -7.3333F, 0.1571F, 0.0F, 0.0F));

		PartDefinition mane = neck.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(16, 52).addBox(-2.0F, 0.0F, -2.75F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, -2.9F, 1.5F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -5.3333F, 6.6667F));

		PartDefinition tailStub = tail.addOrReplaceChild("tailStub", CubeListBuilder.create().texOffs(48, 52).addBox(-1.0F, -2.1301F, -1.5699F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -0.25F, 0.5061F, 0.0F, 0.0F));

		PartDefinition tailLength = tailStub.addOrReplaceChild("tailLength", CubeListBuilder.create().texOffs(56, 0).addBox(-2.0F, -2.0F, 0.25F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 8).addBox(-2.0F, 2.0F, 0.25F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 0).addBox(-2.0F, 6.0F, 0.25F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 8).addBox(-2.0F, 10.0F, 0.25F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1301F, 3.4301F, -0.48F, 0.0F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(24, 36).addBox(0.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.6667F, -5.3333F));

		PartDefinition leftLeg = body.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.6667F, 3.6667F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(40, 36).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.6667F, -5.3333F));

		PartDefinition rightLeg = body.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 48).addBox(0.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.6667F, 3.6667F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }

	@Override
	public void setupAnim(Twilight entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rightArm.xRot = Mth.cos(limbSwing) * limbSwingAmount;
        this.leftLeg.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
        this.rightLeg.xRot = Mth.cos(limbSwing) * limbSwingAmount;
        this.leftArm.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
	}
}