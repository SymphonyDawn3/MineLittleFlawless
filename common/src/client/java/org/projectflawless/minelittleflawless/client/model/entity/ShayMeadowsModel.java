package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.entity.ShayMeadows;

public class ShayMeadowsModel extends TamersPonyModel<ShayMeadows> {
    @Override
    public ResourceLocation getTextureResource(ShayMeadows animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "textures/entity/shay_meadows.png");
    }
}
