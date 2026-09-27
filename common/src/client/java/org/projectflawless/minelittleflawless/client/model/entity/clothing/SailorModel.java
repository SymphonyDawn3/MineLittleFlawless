package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.JackieSpectre;

public class SailorModel extends AdultAndBabyPonyModel<JackieSpectre> {
    @Override
    public ResourceLocation getModelResource(JackieSpectre animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/clothing/sailor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(JackieSpectre animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/clothing/sailor.png");
    }
}