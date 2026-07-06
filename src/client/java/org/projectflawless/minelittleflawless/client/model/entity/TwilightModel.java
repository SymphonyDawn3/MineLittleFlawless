package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Twilight;

public class TwilightModel extends TamersPonyModel<Twilight> {
    @Override
    public ResourceLocation getTextureResource(Twilight animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/twilight.png");
    }
}