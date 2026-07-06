package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.Flawless;

public class FlawlessMagicianClothingModel extends AdultAndBabyPonyModel<Flawless> {
    @Override
    public ResourceLocation getModelResource(Flawless animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/flawless_magician_clothing.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Flawless animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/flawless_magician_clothing.png");
    }
}