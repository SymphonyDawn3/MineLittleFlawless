package org.projectflawless.minelittleflawless.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;

public class Marionette extends TamableTamersPony {
    public Marionette(EntityType<Marionette> type, Level world) {
        super(type, world);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        Marionette babyMarionette = MineLittleFlawlessEntities.MARIONETTE.create(level, null, null,
                otherParent.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (babyMarionette != null)
            babyMarionette.finalizeSpawn(level, level.getCurrentDifficultyAt(babyMarionette.blockPosition()),
                    MobSpawnType.BREEDING, null, null);

        return babyMarionette;
    }
}
