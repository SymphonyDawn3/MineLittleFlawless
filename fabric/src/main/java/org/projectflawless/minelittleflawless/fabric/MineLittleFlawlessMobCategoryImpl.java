package org.projectflawless.minelittleflawless.fabric;

import net.minecraft.world.entity.MobCategory;
import org.projectflawless.minelittleflawless.MineLittleFlawlessMobCategory;

public enum MineLittleFlawlessMobCategoryImpl {
    ;

    public static MobCategory getCategory(MineLittleFlawlessMobCategory category) {
        return switch (category) {
            case MINELITTLEFLAWLESS_MLP_PERSISTENT -> MobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT;
            case MINELITTLEFLAWLESS_MLP_NON_PERSISTENT -> MobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT;
        };
    }
}
