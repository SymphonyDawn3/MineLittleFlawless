package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.StarCatcherModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.MaidLayer;
import org.projectflawless.minelittleflawless.entity.StarCatcher;

public class StarCatcherRenderer extends TamersPonyRenderer<StarCatcher, StarCatcherModel> {
    public StarCatcherRenderer(EntityRendererProvider.Context context) {
        super(context, new StarCatcherModel(context.bakeLayer(StarCatcherModel.LAYER_LOCATION)),
                new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/star_catcher.png"));

        this.addLayer(new MaidLayer(this));
    }
}
