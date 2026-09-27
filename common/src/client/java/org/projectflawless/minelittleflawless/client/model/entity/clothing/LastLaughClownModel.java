package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.LastLaugh;

public class LastLaughClownModel extends AdultAndBabyPonyModel<LastLaugh> {
    @Override
    public ResourceLocation getModelResource(LastLaugh animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/clothing/last_laugh_clown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LastLaugh lastLaugh) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/clothing/last_laugh_clown.png");
    }
}
