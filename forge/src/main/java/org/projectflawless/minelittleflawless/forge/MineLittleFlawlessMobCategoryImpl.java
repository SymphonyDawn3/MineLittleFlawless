package org.projectflawless.minelittleflawless.forge;

import net.minecraft.world.entity.MobCategory;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.MineLittleFlawlessMobCategory;

public enum MineLittleFlawlessMobCategoryImpl {
    ;

    private static final MobCategory MINELITTLEFLAWLESS_MLP_PERSISTENT = MobCategory.create(
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.getName(),
            MineLittleFlawless.MOD_ID,
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.getMax(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.isFriendly(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.isPersistent(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.getDespawnDistance()
    );

    private static final MobCategory MINELITTLEFLAWLESS_MLP_NON_PERSISTENT = MobCategory.create(
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getName(),
            MineLittleFlawless.MOD_ID,
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getMax(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.isFriendly(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.isPersistent(),
            MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getDespawnDistance()
    );

    public static MobCategory getCategory(MineLittleFlawlessMobCategory category) {
        return switch (category) {
            case MINELITTLEFLAWLESS_MLP_PERSISTENT -> MineLittleFlawlessMobCategoryImpl.MINELITTLEFLAWLESS_MLP_PERSISTENT;
            case MINELITTLEFLAWLESS_MLP_NON_PERSISTENT -> MineLittleFlawlessMobCategoryImpl.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT;
        };
    }
}
