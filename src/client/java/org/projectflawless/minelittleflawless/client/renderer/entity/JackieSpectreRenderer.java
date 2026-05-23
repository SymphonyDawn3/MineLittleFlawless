package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.JackieSpectreModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.SailorLayer;
import org.projectflawless.minelittleflawless.entity.JackieSpectre;

public class JackieSpectreRenderer extends TamersPonyRenderer<JackieSpectre, JackieSpectreModel> {
    public JackieSpectreRenderer(EntityRendererProvider.Context context) {
        super(context, new JackieSpectreModel(context.bakeLayer(JackieSpectreModel.LAYER_LOCATION)),
                new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/jackie_spectre.png"));

        this.addLayer(new SailorLayer(this));
    }
}
