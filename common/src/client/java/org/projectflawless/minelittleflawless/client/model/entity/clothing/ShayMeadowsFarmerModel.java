package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.ShayMeadows;

public class ShayMeadowsFarmerModel extends AdultAndBabyPonyModel<ShayMeadows> {
    @Override
    public ResourceLocation getModelResource(ShayMeadows animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "geo/clothing/shay_meadows_farmer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ShayMeadows animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "textures/entity/clothing/shay_meadows_farmer.png");
    }
}
