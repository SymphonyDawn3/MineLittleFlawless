package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.RockstarModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;

public class RockstarRenderLayer extends FlawlessClothingRenderLayer {
    public RockstarRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/rockstar.png"),
                new RockstarModel(entityModels.bakeLayer(RockstarModel.LAYER_LOCATION)),
                BuiltInRegistries.ITEM.getKey(MineLittleFlawlessItems.ROCKSTAR).toString());
    }
}
