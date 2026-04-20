package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.FarmerModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;

public class FarmerRenderLayer extends FlawlessClothingRenderLayer {
    public FarmerRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/farmer.png"),
                new FarmerModel(entityModels.bakeLayer(FarmerModel.LAYER_LOCATION)),
                BuiltInRegistries.ITEM.getKey(MineLittleFlawlessItems.FARMER).toString());
    }
}
