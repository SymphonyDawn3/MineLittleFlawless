package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.LastLaugh;

public class LastLaughModel extends TamersPonyModel<LastLaugh> {
    @Override
    public ResourceLocation getTextureResource(LastLaugh lastLaugh) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/last_laugh.png");
    }
}
