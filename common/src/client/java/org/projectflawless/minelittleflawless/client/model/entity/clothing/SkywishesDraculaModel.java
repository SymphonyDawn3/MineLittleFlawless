package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.Skywishes;

public class SkywishesDraculaModel extends AdultAndBabyPonyModel<Skywishes> {
    @Override
    public ResourceLocation getModelResource(Skywishes animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/clothing/skywishes_dracula.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Skywishes animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entity/clothing/skywishes_dracula.png");
    }
}
