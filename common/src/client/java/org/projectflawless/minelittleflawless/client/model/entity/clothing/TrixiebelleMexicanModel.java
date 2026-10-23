package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.Trixiebelle;

public class TrixiebelleMexicanModel extends AdultAndBabyPonyModel<Trixiebelle> {
    @Override
    public ResourceLocation getModelResource(Trixiebelle animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/clothing/trixiebelle_mexican.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Trixiebelle animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entity/clothing/trixiebelle_mexican.png");
    }
}
