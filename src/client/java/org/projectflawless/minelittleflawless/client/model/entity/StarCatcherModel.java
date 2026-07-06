package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.StarCatcher;

public class StarCatcherModel extends TamersPonyModel<StarCatcher> {
    @Override
    public ResourceLocation getTextureResource(StarCatcher animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/star_catcher.png");
    }
}
