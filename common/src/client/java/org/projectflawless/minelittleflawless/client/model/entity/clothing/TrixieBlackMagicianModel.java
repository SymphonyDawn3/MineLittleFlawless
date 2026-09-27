package org.projectflawless.minelittleflawless.client.model.entity.clothing;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.AdultAndBabyPonyModel;
import org.projectflawless.minelittleflawless.entity.Trixie;

public class TrixieBlackMagicianModel extends AdultAndBabyPonyModel<Trixie> {
    @Override
    public ResourceLocation getModelResource(Trixie animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/clothing/trixie_black_magician.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Trixie animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/clothing/trixie_black_magician.png");
    }
}
