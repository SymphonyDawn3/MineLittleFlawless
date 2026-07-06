package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.JackieSpectre;

public class JackieSpectreModel extends TamersPonyModel<JackieSpectre> {
    @Override
    public ResourceLocation getTextureResource(JackieSpectre animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/jackie_spectre.png");
    }
}
