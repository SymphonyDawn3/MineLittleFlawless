package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.ArinosModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.JesterLayer;
import org.projectflawless.minelittleflawless.entity.Arinos;

public class ArinosRenderer extends TamersPonyRenderer<Arinos, ArinosModel> {
    public ArinosRenderer(EntityRendererProvider.Context context) {
        super(context, new ArinosModel(context.bakeLayer(ArinosModel.LAYER_LOCATION)),
                new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/arinos.png"));

        this.addLayer(new JesterLayer(this));
    }
}
