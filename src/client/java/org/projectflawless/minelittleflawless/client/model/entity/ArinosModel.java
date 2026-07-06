package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Arinos;

public class ArinosModel extends TamersPonyModel<Arinos> {
    @Override
    public ResourceLocation getTextureResource(Arinos animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/arinos.png");
    }
}