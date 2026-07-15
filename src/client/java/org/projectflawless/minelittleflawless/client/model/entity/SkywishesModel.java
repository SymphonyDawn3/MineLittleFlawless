package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Skywishes;

public class SkywishesModel extends TamersPonyModel<Skywishes> {
    @Override
    public ResourceLocation getTextureResource(Skywishes animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/skywishes.png");
    }
}
