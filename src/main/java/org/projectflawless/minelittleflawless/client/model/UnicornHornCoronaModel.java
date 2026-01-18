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
import org.projectflawless.minelittleflawless.entity.Flawless;

public class UnicornHornCoronaModel extends AgeableHierarchicalModel<Flawless> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("minelittleflawless", "unicorn_horn_corona_model"), "main");

    private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart horn;
	private final ModelPart corona;

	public UnicornHornCoronaModel(ModelPart root) {
        super(0.5f, 21.2086f);
        this.root = root;
        this.body = this.root.getChild("body");
		this.head = this.body.getChild("head");
		this.horn = this.head.getChild("horn");
		this.corona = this.horn.getChild("corona");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 5.3333F, 0.3333F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -5.3333F, -7.3333F));

		PartDefinition horn = head.addOrReplaceChild("horn", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition corona = horn.addOrReplaceChild("corona", CubeListBuilder.create().texOffs(24, 64).addBox(-0.5F, -11.0F, -3.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5061F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }

	@Override
	public void setupAnim(Flawless entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
	}
}