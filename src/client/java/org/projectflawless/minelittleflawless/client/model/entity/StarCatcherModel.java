package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.StarCatcher;

public class StarCatcherModel extends TamersPonyModel<StarCatcher> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MineLittleFlawless.MOD_ID, "star_catcher_model"), "main");

    public StarCatcherModel(ModelPart root) {
        super(root);
    }

    @Override
    public void prepareMobModel(StarCatcher entity, float limbSwing, float limbSwingAmount, float partialTick) {
        this.stallion.visible = false;
        this.extendedLeft.visible = false;
        this.extendedRight.visible = false;
    }
}
