package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.client.model.AgeableHierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;

public class TamersPonyModel<E extends TamableTamersPony> extends AgeableHierarchicalModel<E> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(
            MineLittleFlawless.MOD_ID, "tamers_pony_model"), "main");

    protected final ModelPart root;
    protected final ModelPart body;
    protected final ModelPart head;
    protected final ModelPart horn;
    protected final ModelPart snout;
    protected final ModelPart stallion;
    protected final ModelPart wings;
    protected final ModelPart rightWing;
    protected final ModelPart extendedRight;
    protected final ModelPart leftWing;
    protected final ModelPart extendedLeft;
    protected final ModelPart rightArm;
    protected final ModelPart leftLeg;
    protected final ModelPart leftArm;
    protected final ModelPart rightLeg;

    public TamersPonyModel(ModelPart root) {
        super(0.5f, 21.2086f);
        this.root = root;
        this.body = this.root.getChild("body");
        this.head = this.body.getChild("head");
        this.horn = this.head.getChild("horn");
        this.snout = this.head.getChild("snout");
        this.stallion = this.snout.getChild("stallion");
        this.wings = this.body.getChild("wings");
        this.rightWing = this.wings.getChild("rightWing");
        this.extendedRight = this.rightWing.getChild("extendedRight");
        this.leftWing = this.wings.getChild("leftWing");
        this.extendedLeft = this.leftWing.getChild("extendedLeft");
        this.rightArm = this.body.getChild("rightArm");
        this.leftLeg = this.body.getChild("leftLeg");
        this.leftArm = this.body.getChild("leftArm");
        this.rightLeg = this.body.getChild("rightLeg");
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body = partDefinition.addOrReplaceChild("body",
                CubeListBuilder
                        .create()
                        .texOffs(0, 36)
                        .addBox(-4.0f, -1.3333f, -9.3333f, 8.0f, 8.0f,
                                4.0f, new CubeDeformation(0.0f))
                        .texOffs(0, 0)
                        .addBox(-4.0f, -1.3333f, -5.3333f, 8.0f, 8.0f,
                                12.0f, new CubeDeformation(0.0f)),
                PartPose.offset(0.0f, 5.3333f, 0.3333f));

        PartDefinition head = body.addOrReplaceChild("head",
                CubeListBuilder
                        .create()
                        .texOffs(0, 20)
                        .addBox(-4.0f, -6.0f, -6.0f, 8.0f, 8.0f,
                                8.0f, new CubeDeformation(0.0f))
                        .texOffs(32, 20)
                        .addBox(-4.0f, -6.0f, -6.0f, 8.0f, 8.0f,
                                8.0f, new CubeDeformation(0.5f)),
                PartPose.offset(0.0f, -5.3333f, -7.3333f));

        head.addOrReplaceChild("ears",
                CubeListBuilder
                        .create()
                        .texOffs(16, 48)
                        .addBox(-4.0f, -8.0f, -1.0f, 2.0f, 2.0f,
                                2.0f, new CubeDeformation(0.0f))
                        .texOffs(16, 48)
                        .mirror()
                        .addBox(2.0f, -8.0f, -1.0f, 2.0f, 2.0f,
                                2.0f, new CubeDeformation(0.0f))
                        .mirror(false),
                PartPose.offset(0.0f, 0.0f, 0.0f));

        PartDefinition horn = head.addOrReplaceChild("horn",
                CubeListBuilder
                        .create(),
                PartPose.offset(0.0f, 0.0f, 0.0f));

        horn.addOrReplaceChild("bone_r1",
                CubeListBuilder
                        .create()
                        .texOffs(20, 64)
                        .addBox(-0.5f, -11.0f, -3.5f, 1.0f, 4.0f,
                                1.0f, new CubeDeformation(0.0f)),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, 0.5061f, 0.0f, 0.0f));

        PartDefinition snout = head.addOrReplaceChild("snout",
                CubeListBuilder
                        .create(),
                PartPose.offset(0.0f, 0.0f, 0.0f));

        snout.addOrReplaceChild("mare",
                CubeListBuilder
                        .create()
                        .texOffs(50, 16)
                        .addBox(-2.0f, 0.0f, -7.0f, 4.0f, 2.0f,
                                1.0f, new CubeDeformation(0.0f))
                        .texOffs(64, 24)
                        .addBox(-1.0f, -1.0f, -7.0f, 2.0f, 1.0f,
                                1.0f, new CubeDeformation(0.0f)),
                PartPose.offset(0.0f, 0.0f, 0.0f));

        snout.addOrReplaceChild("stallion",
                CubeListBuilder
                        .create()
                        .texOffs(40, 16)
                        .addBox(-2.0f, -1.0f, -7.0f, 4.0f, 3.0f,
                                1.0f, new CubeDeformation(0.0f)),
                PartPose.offset(0.0f, 0.0f, 0.0f));

        PartDefinition neck = body.addOrReplaceChild("neck",
                CubeListBuilder
                        .create()
                        .texOffs(32, 52)
                        .addBox(-2.0f, 1.0f, -2.75f, 4.0f, 4.0f,
                                4.0f, new CubeDeformation(0.0f)),
                PartPose.offsetAndRotation(0.0f, -5.3333f, -7.3333f, 0.1571f, 0.0f, 0.0f));

        neck.addOrReplaceChild("mane",
                CubeListBuilder
                        .create()
                        .texOffs(16, 52)
                        .addBox(-2.0f, 0.0f, -2.75f, 4.0f, 8.0f,
                                4.0f, new CubeDeformation(-0.5f)),
                PartPose.offset(0.0f, -2.9f, 1.5f));

        PartDefinition tail = body.addOrReplaceChild("tail",
                CubeListBuilder
                        .create(),
                PartPose.offset(0.0f, -5.3333f, 6.6667f));

        PartDefinition tailStub = tail.addOrReplaceChild("tailStub",
                CubeListBuilder
                        .create()
                        .texOffs(48, 52)
                        .addBox(-1.0f, -2.1301f, -1.5699f, 2.0f, 2.0f,
                                6.0f, new CubeDeformation(0.0f)),
                PartPose.offsetAndRotation(0.0f, 6.0f, -0.25f, 0.5061f, 0.0f, 0.0f));

        tailStub.addOrReplaceChild("tailLength",
                CubeListBuilder
                        .create()
                        .texOffs(56, 0)
                        .addBox(-2.0f, -2.0f, 0.25f, 4.0f, 4.0f,
                                4.0f, new CubeDeformation(0.0f))
                        .texOffs(56, 8)
                        .addBox(-2.0f, 2.0f, 0.25f, 4.0f, 4.0f,
                                4.0f, new CubeDeformation(0.0f))
                        .texOffs(56, 0)
                        .addBox(-2.0f, 6.0f, 0.25f, 4.0f, 4.0f,
                                4.0f, new CubeDeformation(0.0f))
                        .texOffs(56, 8)
                        .addBox(-2.0f, 10.0f, 0.25f, 4.0f, 4.0f,
                                4.0f, new CubeDeformation(0.0f)),
                PartPose.offsetAndRotation(0.0f, -1.1301f, 3.401f, -0.48f, 0.0f, 0.0f));

        PartDefinition wings = body.addOrReplaceChild("wings",
                CubeListBuilder
                        .create(),
                PartPose.offset(0.0f, -5.3333f, -7.3333f));

        PartDefinition rightWing = wings.addOrReplaceChild("rightWing",
                CubeListBuilder
                        .create(),
                PartPose.offset(0.0f, 0.0f, 0.0f));

        rightWing.addOrReplaceChild("foldedRight",
                CubeListBuilder
                        .create()
                        .texOffs(52, 60)
                        .addBox(4.001f, 5.0f, 1.999f, 2.0f, 6.0f,
                                2.0f, new CubeDeformation(0.0f))
                        .texOffs(56, 36)
                        .addBox(4.001f, 5.0f, 4.001f, 2.0f, 8.0f,
                                2.0f, new CubeDeformation(0.0f))
                        .texOffs(52, 60)
                        .addBox(4.001f, 5.0f, 6.002f, 2.0f, 6.0f,
                                2.0f, new CubeDeformation(0.0f)),
                PartPose.offsetAndRotation(0.0f, 13.0f, -2.0f, 1.5708f, 0.0f, 0.0f));

        PartDefinition extendedRight = rightWing.addOrReplaceChild("extendedRight",
                CubeListBuilder
                        .create()
                        .texOffs(40, 60)
                        .addBox(-0.5f, 6.0f, 0.0f, 1.0f, 9.0f,
                                2.0f, new CubeDeformation(0.1f))
                        .texOffs(14, 64)
                        .addBox(-0.5f, 0.0f, -0.2f, 1.0f, 6.0f,
                                2.0f, new CubeDeformation(0.3f)),
                PartPose.offsetAndRotation(4.5f, 5.3f, 6.0f, -0.5236f, -3.1416f, -2.5307f));

        extendedRight.addOrReplaceChild("feather6_r1",
                CubeListBuilder
                        .create()
                        .texOffs(56, 46)
                        .addBox(-0.5f, 0.0f, 0.0f, 1.0f, 3.0f,
                                2.0f, new CubeDeformation(0.19f))
                        .texOffs(60, 60)
                        .addBox(-0.5f, -1.0f, -0.3f, 1.0f, 8.0f,
                                2.0f, new CubeDeformation(0.1f)),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, -0.8378f, 0.0f, 0.0f));

        extendedRight.addOrReplaceChild("feather4_r1",
                CubeListBuilder
                        .create()
                        .texOffs(60, 60)
                        .addBox(-0.5f, 5.0f, 2.0f, 1.0f, 8.0f,
                                2.0f, new CubeDeformation(0.0f)),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, -0.4887f, 0.0f, 0.0f));

        extendedRight.addOrReplaceChild("feather3_r1",
                CubeListBuilder
                        .create()
                        .texOffs(60, 60)
                        .addBox(-0.5f, 1.8f, 1.3f, 1.0f, 8.0f,
                                2.0f, new CubeDeformation(-0.1f)),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, -0.733f, 0.0f, 0.0f));

        PartDefinition leftWing = wings.addOrReplaceChild("leftWing",
                CubeListBuilder
                        .create(),
                PartPose.offset(0.0f, 0.0f, 0.0f));

        leftWing.addOrReplaceChild("foldedLeft",
                CubeListBuilder
                        .create()
                        .texOffs(0, 64)
                        .addBox(-6.1f, 5.0f, 1.999f, 2.0f, 6.0f,
                                2.0f, new CubeDeformation(0.0f))
                        .texOffs(32, 60)
                        .addBox(-6.1f, 5.0f, 4.001f, 2.0f, 8.0f,
                                2.0f, new CubeDeformation(0.0f))
                        .texOffs(0, 64)
                        .addBox(-6.1f, 5.0f, 6.002f, 2.0f, 6.0f,
                                2.0f, new CubeDeformation(0.0f)),
                PartPose.offsetAndRotation(0.0f, 13.0f, -2.0f, 1.5708f, 0.0f, 0.0f));

        PartDefinition extendedLeft = leftWing.addOrReplaceChild("extendedLeft",
                CubeListBuilder
                        .create()
                        .texOffs(46, 60)
                        .addBox(-0.5f, 6.0f, 0.0f, 1.0f, 9.0f,
                                2.0f, new CubeDeformation(0.1f))
                        .texOffs(64, 16)
                        .addBox(-0.5f, 0.0f, -0.2f, 1.0f, 6.0f,
                                2.0f, new CubeDeformation(0.3f)),
                PartPose.offsetAndRotation(-4.5f, 5.3f, 6.0f, -0.5236f, -3.1416f, 2.5307f));

        extendedLeft.addOrReplaceChild("feather6_r2",
                CubeListBuilder
                        .create()
                        .texOffs(62, 46)
                        .addBox(-0.5f, 0.0f, 0.0f, 1.0f, 3.0f,
                                2.0f, new CubeDeformation(0.19f))
                        .texOffs(8, 64)
                        .addBox(-0.5f, -1.0f, -0.3f, 1.0f, 8.0f,
                                2.0f, new CubeDeformation(0.1f)),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, -0.8378f, 0.0f, 0.0f));

        extendedLeft.addOrReplaceChild("feather4_r2",
                CubeListBuilder
                        .create()
                        .texOffs(8, 64)
                        .addBox(-0.5f, 5.0f, 2.0f, 1.0f, 8.0f,
                                2.0f, new CubeDeformation(0.0f)),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, -0.4887f, 0.0f, 0.0f));

        extendedLeft.addOrReplaceChild("feather3_r2",
                CubeListBuilder
                        .create()
                        .texOffs(8, 64)
                        .addBox(-0.5f, 1.8f, 1.3f, 1.0f, 8.0f,
                                2.0f, new CubeDeformation(-0.1f)),
                PartPose.offsetAndRotation(0.0f, 0.0f, 0.0f, -0.733f, 0.0f, 0.0f));

        body.addOrReplaceChild("rightArm",
                CubeListBuilder
                        .create()
                        .texOffs(24, 36)
                        .addBox(0.0f, 4.0f, -2.0f, 4.0f, 12.0f,
                                4.0f, new CubeDeformation(0.0f)),
                PartPose.offset(0.0f, 2.6667f, -5.3333f));

        body.addOrReplaceChild("leftLeg",
                CubeListBuilder
                        .create()
                        .texOffs(40, 0)
                        .addBox(-4.0f, 4.0f, -2.0f, 4.0f, 12.0f,
                                4.0f, new CubeDeformation(0.0f)),
                PartPose.offset(0.0f, 2.6667f, 3.6667f));

        body.addOrReplaceChild("leftArm",
                CubeListBuilder
                        .create()
                        .texOffs(40, 36)
                        .addBox(-4.0f, 4.0f, -2.0f, 4.0f, 12.0f,
                                4.0f, new CubeDeformation(0.0f)),
                PartPose.offset(0.0f, 2.6667f, -5.3333f));

        body.addOrReplaceChild("rightLeg",
                CubeListBuilder
                        .create()
                        .texOffs(0, 48)
                        .addBox(0.0f, 4.0f, -2.0f, 4.0f, 12.0f,
                                4.0f, new CubeDeformation(0.0f)),
                PartPose.offset(0.0f, 2.6667f, 3.6667f));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public void setupAnim(E entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
        this.rightArm.xRot = Mth.cos(limbSwing) * limbSwingAmount;
        this.leftLeg.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
        this.head.yRot = netHeadYaw / (180f / (float) Math.PI);
        this.head.xRot = headPitch / (180f / (float) Math.PI);
        this.rightLeg.xRot = Mth.cos(limbSwing) * limbSwingAmount;
        this.leftArm.xRot = Mth.cos(limbSwing) * -limbSwingAmount;
    }
}
