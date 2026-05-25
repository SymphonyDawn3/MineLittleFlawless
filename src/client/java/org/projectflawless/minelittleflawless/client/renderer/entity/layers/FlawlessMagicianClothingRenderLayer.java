package org.projectflawless.minelittleflawless.client.renderer.entity.layers;

import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.client.model.entity.clothing.FlawlessMagicianClothingModel;
import org.projectflawless.minelittleflawless.client.renderer.entity.FlawlessRenderer;

public class FlawlessMagicianClothingRenderLayer extends FlawlessClothingRenderLayer {
    public FlawlessMagicianClothingRenderLayer(FlawlessRenderer renderer) {
        super(
                renderer,
                new ResourceLocation(MineLittleFlawless.MOD_ID, "textures/entities/flawless_magician_clothing.png"),
                new FlawlessMagicianClothingModel(entityModels.bakeLayer(FlawlessMagicianClothingModel.LAYER_LOCATION)),
                Clothing.FLAWLESS_MAGICIAN_CLOTHING);
    }
}
