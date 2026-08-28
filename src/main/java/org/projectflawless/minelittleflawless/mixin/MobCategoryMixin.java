package org.projectflawless.minelittleflawless.mixin;

import net.minecraft.world.entity.MobCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MobCategory.class)
enum MobCategoryMixin {
    MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT("minelittleflawless_mlp_persistent", 10, true, true, 128),
    MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT("minelittleflawless_mlp_non_persistent", 35, true, false, 128);

    @Shadow
    MobCategoryMixin(String name, int max, boolean isFriendly, boolean isPersistent, int despawnDistance) {

    }
}
