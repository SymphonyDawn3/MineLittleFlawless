package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.client.model.entity.JackieSpectreModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.SailorLayer;
import org.projectflawless.minelittleflawless.entity.JackieSpectre;

public class JackieSpectreRenderer extends TamersPonyRenderer<JackieSpectre, JackieSpectreModel> {
    public JackieSpectreRenderer(EntityRendererProvider.Context context) {
        super(context, new JackieSpectreModel(), 0.7f, 0.28f);
        this.addRenderLayer(new SailorLayer(this));
    }
}
