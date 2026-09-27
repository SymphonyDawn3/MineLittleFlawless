package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.Bibblebop;

public class BibblebopClownModel extends AdultAndBabyPonyModel<Bibblebop> {
    @Override
    public ResourceLocation getModelResource(Bibblebop animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/clothing/bibblebop_clown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Bibblebop bibblebop) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/clothing/bibblebop_clown.png");
    }
}
