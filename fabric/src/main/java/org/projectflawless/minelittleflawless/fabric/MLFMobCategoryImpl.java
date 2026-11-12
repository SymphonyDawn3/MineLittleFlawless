package org.projectflawless.minelittleflawless.fabric;

import net.minecraft.world.entity.MobCategory;
import org.projectflawless.minelittleflawless.MLFMobCategory;

public enum MLFMobCategoryImpl {
    ;

    public static MobCategory getCategory(MLFMobCategory category) {
        return switch (category) {
            case MINELITTLEFLAWLESS_MLP_PERSISTENT -> MobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT;
            case MINELITTLEFLAWLESS_MLP_NON_PERSISTENT -> MobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT;
        };
    }
}
