package org.projectflawless.minelittleflawless.client.model.entity.clothing;

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
public class RockstarModel extends AgeableHierarchicalModel<Flawless> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "rockstar_model"), "main");

    private final ModelPart root;
	private final ModelPart rightSleeve;
	private final ModelPart leftSleeve;
	private final ModelPart leftSock;
	private final ModelPart rightSock;

	public RockstarModel(ModelPart root) {
        super(0.5f, 21.2086f);
        this.root = root;
		ModelPart body = this.root.getChild("body");
		ModelPart sleeves = body.getChild("sleeves");
		this.rightSleeve = sleeves.getChild("rightSleeve");
		this.leftSleeve = sleeves.getChild("leftSleeve");
		ModelPart socks = body.getChild("socks");
		this.leftSock = socks.getChild("leftSock");
		this.rightSock = socks.getChild("rightSock");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 5.3333F, 0.3333F));

		body.addOrReplaceChild("bandana", CubeListBuilder.create().texOffs(40, 24).addBox(-2.0F, 1.0F, -2.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -5.3333F, -7.3333F, 0.1571F, 0.0F, 0.0F));

		body.addOrReplaceChild("shirt", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -1.3333F, -9.3333F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.3F))
		.texOffs(0, 0).addBox(-4.0F, -1.3333F, -4.7333F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition sleeves = body.addOrReplaceChild("sleeves", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		sleeves.addOrReplaceChild("rightSleeve", CubeListBuilder.create().texOffs(24, 20).addBox(0.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 2.6667F, -5.3333F));

		sleeves.addOrReplaceChild("leftSleeve", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 2.6667F, -5.3333F));

		PartDefinition socks = body.addOrReplaceChild("socks", CubeListBuilder.create(), PartPose.offset(0.0F, 2.6667F, 3.6667F));

		socks.addOrReplaceChild("leftSock", CubeListBuilder.create().texOffs(16, 36).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		socks.addOrReplaceChild("rightSock", CubeListBuilder.create().texOffs(32, 36).addBox(0.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		body.addOrReplaceChild("guitar", CubeListBuilder.create().texOffs(40, 0).addBox(-0.25F, -4.0F, -4.0F, 1.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(40, 14).addBox(-0.25F, -2.0F, -12.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(16, 32).addBox(-0.25F, -3.0F, -10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 32).addBox(-0.25F, -3.0F, -12.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 34).addBox(-0.25F, 0.0F, -12.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 34).addBox(-0.25F, 0.0F, -10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 3.75F, 0.0F, -0.2618F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
	public void setupAnim(Flawless entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightSock.xRot = Mth.cos(limbSwing) * limbSwingAmount;
		this.rightSleeve.xRot = Mth.cos(limbSwing) * limbSwingAmount;
		this.leftSleeve.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
		this.leftSock.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
	}
}