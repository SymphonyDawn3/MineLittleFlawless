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
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Flawless;

// Made with Blockbench 5.0.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class TuxedoModel extends AgeableHierarchicalModel<Flawless> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "tuxedo_model"), "main");

    private final ModelPart root;
    private final ModelPart body;
	private final ModelPart tuxedo;
	private final ModelPart bowtie;
	private final ModelPart head;
	private final ModelPart topHat;
	private final ModelPart sleeves;
	private final ModelPart rightSleeve;
	private final ModelPart leftSleeve;

	public TuxedoModel(ModelPart root) {
        super(0.5f, 21.2086f);
        this.root = root;
		this.body = this.root.getChild("body");
		this.tuxedo = this.body.getChild("tuxedo");
		this.bowtie = this.body.getChild("bowtie");
		this.head = this.body.getChild("head");
		this.topHat = this.head.getChild("topHat");
		this.sleeves = this.body.getChild("sleeves");
		this.rightSleeve = this.sleeves.getChild("rightSleeve");
		this.leftSleeve = this.sleeves.getChild("leftSleeve");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 5.3333F, 0.3333F));

		PartDefinition tuxedo = body.addOrReplaceChild("tuxedo", CubeListBuilder.create().texOffs(40, 18).addBox(-4.0F, -1.3333F, -9.3333F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.3F))
		.texOffs(0, 18).addBox(-4.0F, -1.3333F, -4.7333F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bowtie = body.addOrReplaceChild("bowtie", CubeListBuilder.create().texOffs(56, 36).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 30).addBox(0.5F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 33).addBox(-2.5F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -10.6F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -5.3333F, -7.3333F));

		PartDefinition topHat = head.addOrReplaceChild("topHat", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-5.0F, -12.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.2346F, -0.1522F, -0.48F, 0.0F, 0.0F));

		PartDefinition sleeves = body.addOrReplaceChild("sleeves", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightSleeve = sleeves.addOrReplaceChild("rightSleeve", CubeListBuilder.create().texOffs(40, 30).addBox(0.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 2.6667F, -5.3333F));

		PartDefinition leftSleeve = sleeves.addOrReplaceChild("leftSleeve", CubeListBuilder.create().texOffs(40, 46).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 2.6667F, -5.3333F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
	public void setupAnim(Flawless entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightSleeve.xRot = Mth.cos(limbSwing) * limbSwingAmount;
		this.leftSleeve.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
	}
}