package org.projectflawless.minelittleflawless.client.model.entity.projectile;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.entity.projectile.Laser;
import software.bernie.geckolib.model.GeoModel;

public class LaserModel extends GeoModel<Laser> {
    @Override
    public ResourceLocation getModelResource(Laser animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "geo/projectiles/laser.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Laser animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "textures/entity/projectiles/laser.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Laser animatable) {
        return null;
    }
}
