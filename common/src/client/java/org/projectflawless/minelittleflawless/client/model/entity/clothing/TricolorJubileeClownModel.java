package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.TricolorJubilee;

public class TricolorJubileeClownModel extends AdultAndBabyPonyModel<TricolorJubilee> {
    @Override
    public ResourceLocation getModelResource(TricolorJubilee animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/clothing/tricolor_jubilee_clown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TricolorJubilee tricolorJubilee) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/clothing/tricolor_jubilee_clown.png");
    }
}
