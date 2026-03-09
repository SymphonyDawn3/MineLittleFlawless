package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.TuxedoModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;

public class TuxedoRenderLayer extends FlawlessClothingRenderLayer {
    public TuxedoRenderLayer(FlawlessRenderer renderer) {
        super(renderer, new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/tuxedo.png"),
                new TuxedoModel(entityModels.bakeLayer(TuxedoModel.LAYER_LOCATION)),
                BuiltInRegistries.ITEM.getKey(MineLittleFlawlessItems.TUXEDO).toString());
    }
}
