package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.projectflawless.minelittleflawless.PonySize;
import org.projectflawless.minelittleflawless.client.model.entity.SkywishesModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.LaserHoofLayer;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.SkywishesDraculaLayer;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.SkywishesGlowMaskLayer;
import org.projectflawless.minelittleflawless.entity.Skywishes;

public class SkywishesRenderer extends TamersPonyRenderer<Skywishes, SkywishesModel> {
    public SkywishesRenderer(EntityRendererProvider.Context context) {
        super(context, new SkywishesModel(), PonySize.MEDIUM);
        this.addRenderLayer(new LaserHoofLayer(this));
        // This is for her glowing eyes.
        this.addRenderLayer(new SkywishesGlowMaskLayer(this));
        this.addRenderLayer(new SkywishesDraculaLayer(this));
    }
}
