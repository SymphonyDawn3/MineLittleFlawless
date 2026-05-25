package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.RockstarModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;

public class RockstarRenderLayer extends FlawlessClothingRenderLayer {
    public RockstarRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/rockstar.png"),
                new RockstarModel(entityModels.bakeLayer(RockstarModel.LAYER_LOCATION)),
                Clothing.ROCKSTAR);
    }
}
