package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.entity.Flawless;

public class FlawlessModel extends TamersPonyModel<Flawless> {
    @Override
    public ResourceLocation getTextureResource(Flawless animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "textures/entity/flawless.png");
    }
}