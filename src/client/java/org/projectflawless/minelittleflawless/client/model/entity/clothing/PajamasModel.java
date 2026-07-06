package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.Flawless;

public class PajamasModel extends AdultAndBabyPonyModel<Flawless> {
    @Override
    public ResourceLocation getModelResource(Flawless animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/pajamas.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Flawless animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/pajamas.png");
    }
}