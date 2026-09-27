package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.Fractured;

public class FracturedTuxedoModel extends AdultAndBabyPonyModel<Fractured> {
    @Override
    public ResourceLocation getModelResource(Fractured animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/clothing/fractured_tuxedo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Fractured animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/clothing/fractured_tuxedo.png");
    }
}
