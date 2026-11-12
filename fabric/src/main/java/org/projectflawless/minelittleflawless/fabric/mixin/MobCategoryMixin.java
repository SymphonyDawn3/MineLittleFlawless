package org.projectflawless.minelittleflawless.fabric.mixin;

import net.minecraft.world.entity.MobCategory;
import org.projectflawless.minelittleflawless.MLFMobCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MobCategory.class)
enum MobCategoryMixin {
    MINELITTLEFLAWLESS_MLP_PERSISTENT(
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.getName(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.getMax(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.isFriendly(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.isPersistent(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getDespawnDistance()
    ),
    MINELITTLEFLAWLESS_MLP_NON_PERSISTENT(
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getName(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getMax(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.isFriendly(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.isPersistent(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getDespawnDistance()
    );

    @Shadow
    MobCategoryMixin(String name, int max, boolean isFriendly, boolean isPersistent, int despawnDistance) {

    }
}
