package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.Bibblebop;

public class BibblebopModel extends TamersPonyModel<Bibblebop> {
    @Override
    public ResourceLocation getTextureResource(Bibblebop bibblebop) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/bibblebop.png");
    }
}
