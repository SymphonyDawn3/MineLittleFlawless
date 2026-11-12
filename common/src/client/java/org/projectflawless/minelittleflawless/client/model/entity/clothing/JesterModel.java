package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.Arinos;

public class JesterModel extends AdultAndBabyPonyModel<Arinos> {
    @Override
    public ResourceLocation getModelResource(Arinos animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "geo/clothing/jester.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Arinos animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "textures/entity/clothing/jester.png");
    }
}