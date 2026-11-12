package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.Bibblebop;

public class BibblebopClownModel extends AdultAndBabyPonyModel<Bibblebop> {
    @Override
    public ResourceLocation getModelResource(Bibblebop animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "geo/clothing/bibblebop_clown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Bibblebop bibblebop) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "textures/entity/clothing/bibblebop_clown.png");
    }
}
