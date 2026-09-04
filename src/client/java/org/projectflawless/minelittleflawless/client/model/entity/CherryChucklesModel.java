package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.CherryChuckles;

public class CherryChucklesModel extends TamersPonyModel<CherryChuckles> {
    @Override
    public ResourceLocation getTextureResource(CherryChuckles cherryChuckles) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/cherry_chuckles.png");
    }
}
