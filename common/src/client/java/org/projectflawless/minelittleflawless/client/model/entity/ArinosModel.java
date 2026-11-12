package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.entity.Arinos;

public class ArinosModel extends TamersPonyModel<Arinos> {
    @Override
    public ResourceLocation getTextureResource(Arinos animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "textures/entity/arinos.png");
    }
}