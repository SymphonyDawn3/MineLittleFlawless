package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.CherryChuckles;

public class CherryChucklesClownModel extends AdultAndBabyPonyModel<CherryChuckles> {
    @Override
    public ResourceLocation getModelResource(CherryChuckles animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/clothing/cherry_chuckles_clown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CherryChuckles cherryChuckles) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/clothing/cherry_chuckles_clown.png");
    }
}
