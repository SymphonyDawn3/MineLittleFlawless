package org.projectflawless.minelittleflawless.entity.ai.sensor;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.NearestVisibleLivingEntities;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.tslat.smartbrainlib.api.core.sensor.EntityFilteringSensor;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.entity.Flawless;
import org.projectflawless.minelittleflawless.entity.Fractured;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSBLSensors;

import java.util.Optional;
import java.util.function.BiPredicate;

public class FracturedSpecificSensor extends EntityFilteringSensor<LivingEntity, Fractured> {
    private final BiPredicate<LivingEntity, Fractured> findPredicate = (livingEntity, fractured) -> livingEntity instanceof Flawless;

    @Override
    protected MemoryModuleType<LivingEntity> getMemory() {
        return MemoryModuleType.INTERACTION_TARGET;
    }

    @Override
    protected BiPredicate<LivingEntity, Fractured> predicate() {
        return this.findPredicate;
    }

    @Override
    protected @Nullable LivingEntity findMatches(Fractured entity, NearestVisibleLivingEntities matcher) {
        Optional<LivingEntity> closestFlawless = matcher.findClosest(livingEntity -> predicate().test(livingEntity, entity));

        return closestFlawless.orElse(null);
    }

    @Override
    public SensorType<? extends ExtendedSensor<?>> type() {
        return MineLittleFlawlessSBLSensors.FRACTURED_SPECIFIC.get();
    }
}
