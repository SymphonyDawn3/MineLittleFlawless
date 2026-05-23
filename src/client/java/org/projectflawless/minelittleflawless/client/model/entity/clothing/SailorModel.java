package org.projectflawless.minelittleflawless.client.model.entity.clothing;

// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.JackieSpectre;

public class SailorModel extends AdultAndBabyPonyModel<JackieSpectre> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "sailor_model"), "main");

    private final ModelPart root;
	private final ModelPart rightSleeve;
	private final ModelPart leftSleeve;

	public SailorModel(ModelPart root) {
        super(0.7f, 0.35f, 10.2f, 44.7f);
        this.root = root;
		ModelPart clothing = root.getChild("clothing");
		this.rightSleeve = clothing.getChild("rightSleeve");
		this.leftSleeve = clothing.getChild("leftSleeve");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition clothing = partdefinition.addOrReplaceChild("clothing", CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -20.0F, -9.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.5F))
		.texOffs(0, 0).addBox(-4.0F, -20.0F, -4.0F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition tie = clothing.addOrReplaceChild("tie", CubeListBuilder.create().texOffs(40, 24).addBox(-2.0F, -20.0F, -10.25F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        tie.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.0F, -19.0F, -8.75F, 0.1571F, 0.0F, 0.0F));

		clothing.addOrReplaceChild("rightSleeve", CubeListBuilder.create().texOffs(24, 39).addBox(0.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -16.0F, -5.0F));

		clothing.addOrReplaceChild("leftSleeve", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, 4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -16.0F, -5.0F));

		clothing.addOrReplaceChild("skirt", CubeListBuilder.create().texOffs(0, 20).addBox(-5.5F, -11.75F, 0.5F, 11.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(JackieSpectre entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rightSleeve.xRot = Mth.cos(limbSwing) * limbSwingAmount;
        this.leftSleeve.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
    }
}