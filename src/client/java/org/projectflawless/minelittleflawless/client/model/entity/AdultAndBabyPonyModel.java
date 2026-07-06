package org.projectflawless.minelittleflawless.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

import java.util.Optional;

public abstract class AdultAndBabyPonyModel<E extends TamableTamersPony & GeoAnimatable> extends GeoModel<E> {
    @Override
    public ResourceLocation getModelResource(E animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "geo/tamers_pony.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(E animatable) {
        return ResourceLocation.tryBuild(MineLittleFlawless.MOD_ID, "animations/tamers_pony.animation.json");
    }

    @Override
    public void setCustomAnimations(E animatable, long instanceId, AnimationState<E> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);

        EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

        Optional<GeoBone> head = this.getBone("head");

        head.ifPresent(bone -> {
            bone.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
            bone.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
        });

        Optional<GeoBone> stallion = this.getBone("stallion");
        Optional<GeoBone> horn = this.getBone("horn");
        Optional<GeoBone> wings = this.getBone("wings");
        Optional<GeoBone> extendedRight = this.getBone("extendedRight");
        Optional<GeoBone> extendedLeft = this.getBone("extendedLeft");


        stallion.ifPresent(bone -> bone.setHidden(!animatable.isStallion()));
        horn.ifPresent(bone -> bone.setHidden(!animatable.isUnicorn()));
        wings.ifPresent(bone -> bone.setHidden(!animatable.isPegasus()));
        extendedLeft.ifPresent(bone -> bone.setHidden(true));
        extendedRight.ifPresent(bone -> bone.setHidden(true));
    }
}
