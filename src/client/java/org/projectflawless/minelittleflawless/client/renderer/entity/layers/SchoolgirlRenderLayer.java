package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.SchoolgirlModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;

public class SchoolgirlRenderLayer extends FlawlessClothingRenderLayer {
    public SchoolgirlRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/schoolgirl.png"),
                new SchoolgirlModel(entityModels.bakeLayer(SchoolgirlModel.LAYER_LOCATION)),
                Clothing.SCHOOLGIRL);
    }
}
