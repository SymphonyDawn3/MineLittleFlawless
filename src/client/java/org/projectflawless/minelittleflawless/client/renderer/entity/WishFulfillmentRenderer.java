package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.WishFulfillmentModel;
import org.projectflawless.minelittleflawless.entity.WishFulfillment;

public class WishFulfillmentRenderer extends TamersPonyRenderer<WishFulfillment, WishFulfillmentModel> {

    public WishFulfillmentRenderer(EntityRendererProvider.Context context) {
        super(context, new WishFulfillmentModel());
    }
}
