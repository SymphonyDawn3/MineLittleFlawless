package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.WishFulfillment;

public class WishFulfillmentModel extends TamersPonyModel<WishFulfillment> {
    @Override
    public ResourceLocation getTextureResource(WishFulfillment animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "textures/entities/wish_fulfillment.png");
    }
}
