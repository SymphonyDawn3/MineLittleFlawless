package org.projectflawless.minelittleflawless.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.client.model.entity.TamersPonyModel;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;

public class TamersPonyRenderer<T extends TamableTamersPony, M extends TamersPonyModel<T>>
        extends MobRenderer<T, M> {
    protected final ResourceLocation textureLocation;

    public TamersPonyRenderer(EntityRendererProvider.Context context, M model, ResourceLocation textureLocation) {
        super(context, model, 0.5f);
        this.textureLocation = textureLocation;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return this.textureLocation;
    }
}
