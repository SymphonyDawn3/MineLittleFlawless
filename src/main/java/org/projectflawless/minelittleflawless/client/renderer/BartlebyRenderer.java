package org.projectflawless.minelittleflawless.client.renderer;

import org.projectflawless.minelittleflawless.client.model.BartlebyModel;
import org.projectflawless.minelittleflawless.entity.Bartleby;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BartlebyRenderer extends MobRenderer<Bartleby, BartlebyModel> {
	public BartlebyRenderer(EntityRendererProvider.Context context) {
		super(context, new BartlebyModel(context.bakeLayer(BartlebyModel.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Bartleby entity) {
		return ResourceLocation.parse("minelittleflawless:textures/entities/bartleby.png");
	}
}