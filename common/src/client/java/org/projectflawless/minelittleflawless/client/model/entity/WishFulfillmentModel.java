package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.entity.WishFulfillment;

public class WishFulfillmentModel extends TamersPonyModel<WishFulfillment> {
    @Override
    public ResourceLocation getTextureResource(WishFulfillment animatable) {
        return ResourceLocation.tryBuild(MLF.MOD_ID, "textures/entity/wish_fulfillment.png");
    }
}
