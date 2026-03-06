// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

package org.projectflawless.minelittleflawless.client.model;

import net.minecraft.client.model.AgeableHierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Trixiebelle;

public class TrixiebelleJesterModel extends AgeableHierarchicalModel<Trixiebelle> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "trixiebelle_jester_model"), "main");

    private final ModelPart root;
    private final ModelPart body;
	private final ModelPart ruff;
	private final ModelPart head;
	private final ModelPart jingalings;

	public TrixiebelleJesterModel(ModelPart root) {
        super(0.5f, 21.2086f);
        this.root = root;
		this.body = this.root.getChild("body");
		this.ruff = this.body.getChild("ruff");
		this.head = this.body.getChild("head");
		this.jingalings = this.head.getChild("jingalings");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 5.3333F, 0.3333F));

		PartDefinition ruff = body.addOrReplaceChild("ruff", CubeListBuilder.create().texOffs(0, 28).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.25F, -7.5F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -5.3333F, -7.3333F));

		PartDefinition jingalings = head.addOrReplaceChild("jingalings", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = jingalings.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-5.0F, -7.25F, -3.75F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(28, 0).addBox(-5.0F, -5.75F, 5.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.0469F, 0.8118F, -0.3762F, -0.1153F, -0.2835F));

		PartDefinition cube_r2 = jingalings.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 4).addBox(4.0F, -5.75F, 5.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -7.25F, -3.75F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.0469F, 0.8118F, -0.3762F, 0.1153F, 0.2835F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }

	@Override
	public void setupAnim(Trixiebelle entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.head.xRot = headPitch / (180F / (float) Math.PI);
	}
}