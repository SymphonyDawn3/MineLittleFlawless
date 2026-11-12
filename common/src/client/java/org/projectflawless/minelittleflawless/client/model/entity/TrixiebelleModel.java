package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.entity.Trixiebelle;

public class TrixiebelleModel extends TamersPonyModel<Trixiebelle> {
    @Override
    public ResourceLocation getTextureResource(Trixiebelle animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "textures/entity/trixiebelle.png");
    }
}