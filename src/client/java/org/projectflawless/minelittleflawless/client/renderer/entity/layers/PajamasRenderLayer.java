package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.PajamasModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;

public class PajamasRenderLayer extends FlawlessClothingRenderLayer {
    public PajamasRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/pajamas.png"),
                new PajamasModel(entityModels.bakeLayer(PajamasModel.LAYER_LOCATION)),
                BuiltInRegistries.ITEM.getKey(MineLittleFlawlessItems.PAJAMAS).toString());
    }
}
