package org.projectflawless.minelittleflawless;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.MobCategory;

public enum MineLittleFlawlessMobCategory {
    MINELITTLEFLAWLESS_MLP_PERSISTENT("minelittleflawless_mlp_persistent", 10, true, true, 128),
    MINELITTLEFLAWLESS_MLP_NON_PERSISTENT("minelittleflawless_mlp_non_persistent", 35, true, false, 128);

    private final String name;
    private final int max;
    private final boolean isFriendly;
    private final boolean isPersistent;
    private final int despawnDistance;

    MineLittleFlawlessMobCategory(String name, int max, boolean isFriendly, boolean isPersistent, int despawnDistance) {
        this.name = name;
        this.max = max;
        this.isFriendly = isFriendly;
        this.isPersistent = isPersistent;
        this.despawnDistance = despawnDistance;
    }

    @ExpectPlatform
    public static MobCategory getCategory(MineLittleFlawlessMobCategory category) {
        throw new AssertionError();
    }

    public String getName() {
        return this.name;
    }

    public int getMax() {
        return this.max;
    }

    public boolean isFriendly() {
        return this.isFriendly;
    }

    public boolean isPersistent() {
        return this.isPersistent;
    }

    public int getDespawnDistance() {
        return this.despawnDistance;
    }
}
