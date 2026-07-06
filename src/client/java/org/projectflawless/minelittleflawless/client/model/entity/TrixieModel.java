package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Trixie;

public class TrixieModel extends TamersPonyModel<Trixie> {
    @Override
    public ResourceLocation getTextureResource(Trixie animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/trixie.png");
    }
}