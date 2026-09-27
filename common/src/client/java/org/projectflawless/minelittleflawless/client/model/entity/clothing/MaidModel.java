package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.StarCatcher;

public class MaidModel extends AdultAndBabyPonyModel<StarCatcher> {
    @Override
    public ResourceLocation getModelResource(StarCatcher animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/clothing/maid.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StarCatcher animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/clothing/maid.png");
    }
}