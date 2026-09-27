package org.projectflawless.minelittleflawless.client.renderer.entity;

import org.projectflawless.minelittleflawless.client.model.entity.FlawlessModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.layers.*;
import org.projectflawless.minelittleflawless.entity.Flawless;
import net.minecraft.client.renderer.entity.EntityRendererProvider;


public class FlawlessRenderer extends TamersPonyRenderer<Flawless, FlawlessModel> {
    public FlawlessRenderer(EntityRendererProvider.Context context) {
		super(context, new FlawlessModel());
        this.addRenderLayer(new FlawlessMagicianClothingRenderLayer(this));
        this.addRenderLayer(new TuxedoRenderLayer(this));
        this.addRenderLayer(new FarmerRenderLayer(this));
        this.addRenderLayer(new PajamasRenderLayer(this));
        this.addRenderLayer(new SchoolgirlRenderLayer(this));
        this.addRenderLayer(new RockstarRenderLayer(this));
    }
}