package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Marionette;

public class MarionetteModel extends TamersPonyModel<Marionette> {
    @Override
    public ResourceLocation getTextureResource(Marionette animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/marionette.png");
    }
}
