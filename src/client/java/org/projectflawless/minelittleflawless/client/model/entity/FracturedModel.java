package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Fractured;

public class FracturedModel extends TamersPonyModel<Fractured> {
    @Override
    public ResourceLocation getTextureResource(Fractured animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/fractured.png");
    }
}
