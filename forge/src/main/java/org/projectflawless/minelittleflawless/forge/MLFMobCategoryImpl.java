package org.projectflawless.minelittleflawless.forge;

import net.minecraft.world.entity.MobCategory;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.MLFMobCategory;

public enum MLFMobCategoryImpl {
    ;

    private static final MobCategory MINELITTLEFLAWLESS_MLP_PERSISTENT = MobCategory.create(
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.getName(),
            MLF.MOD_ID,
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.getMax(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.isFriendly(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.isPersistent(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT.getDespawnDistance()
    );

    private static final MobCategory MINELITTLEFLAWLESS_MLP_NON_PERSISTENT = MobCategory.create(
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getName(),
            MLF.MOD_ID,
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getMax(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.isFriendly(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.isPersistent(),
            MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT.getDespawnDistance()
    );

    public static MobCategory getCategory(MLFMobCategory category) {
        return switch (category) {
            case MINELITTLEFLAWLESS_MLP_PERSISTENT -> MLFMobCategoryImpl.MINELITTLEFLAWLESS_MLP_PERSISTENT;
            case MINELITTLEFLAWLESS_MLP_NON_PERSISTENT -> MLFMobCategoryImpl.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT;
        };
    }
}
