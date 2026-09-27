package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.TricolorJubilee;

public class TricolorJubileeModel extends TamersPonyModel<TricolorJubilee> {
    @Override
    public ResourceLocation getTextureResource(TricolorJubilee tricolorJubilee) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/tricolor_jubilee.png");
    }
}
