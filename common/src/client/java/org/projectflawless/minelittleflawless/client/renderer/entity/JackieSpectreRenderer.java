package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.PonySize;
import org.projectflawless.minelittleflawless.client.model.entity.JackieSpectreModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.SailorLayer;
import org.projectflawless.minelittleflawless.entity.JackieSpectre;

public class JackieSpectreRenderer extends TamersPonyRenderer<JackieSpectre, JackieSpectreModel> {
    public JackieSpectreRenderer(EntityRendererProvider.Context context) {
        super(context, new JackieSpectreModel(), PonySize.SMALL);
        this.addRenderLayer(new SailorLayer(this));
    }
}
