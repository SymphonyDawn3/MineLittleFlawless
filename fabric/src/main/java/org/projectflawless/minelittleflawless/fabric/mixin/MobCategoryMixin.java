package org.projectflawless.minelittleflawless.fabric.mixin;

import net.minecraft.world.entity.MobCategory;
import org.projectflawless.minelittleflawless.MineLittleFlawlessMobCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MobCategory.class)
enum MobCategoryMixin {
    MINELITTLEFLAWLESS_MLP_PERSISTENT(
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.getName(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.getMax(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.isFriendly(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.isPersistent(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getDespawnDistance()
    ),
    MINELITTLEFLAWLESS_MLP_NON_PERSISTENT(
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getName(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getMax(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.isFriendly(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.isPersistent(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getDespawnDistance()
    );

    @Shadow
    MobCategoryMixin(String name, int max, boolean isFriendly, boolean isPersistent, int despawnDistance) {

    }
}
