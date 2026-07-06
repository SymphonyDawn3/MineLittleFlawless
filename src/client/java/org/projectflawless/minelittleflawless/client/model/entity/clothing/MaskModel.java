package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.Marionette;

public class MaskModel extends AdultAndBabyPonyModel<Marionette> {
    @Override
    public ResourceLocation getModelResource(Marionette animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/mask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Marionette animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/mask.png");
    }
}