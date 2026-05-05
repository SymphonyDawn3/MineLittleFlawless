package org.projectflawless.minelittleflawless.entity.ai.behavior;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.EntityTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.entity.item.ItemEntity;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.util.BrainUtils;

import java.util.List;
import java.util.function.Predicate;

public class GoToWantedItem {
    public static <E extends LivingEntity> ExtendedBehaviour<E> create(float speedModifier, boolean hasTarget) {
        return create(livingEntity -> true, speedModifier, hasTarget);
    }

    public static <E extends LivingEntity> ExtendedBehaviour<E> create(Predicate<E> canWalkToItem, float speedModifier, boolean hasTarget) {
        return new ExtendedBehaviour<>() {
            private ItemEntity itemEntity;

            @Override
            protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
                return ObjectArrayList.of(
                        Pair.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED),
                        Pair.of(MemoryModuleType.WALK_TARGET, hasTarget ? MemoryStatus.REGISTERED : MemoryStatus.VALUE_ABSENT),
                        Pair.of(MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM, MemoryStatus.VALUE_PRESENT)
                );
            }

            @Override
            protected boolean checkExtraStartConditions(ServerLevel level, E entity) {
                this.itemEntity = BrainUtils.getMemory(entity, MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM);

                return canWalkToItem.test(entity) && entity.level().getWorldBorder().isWithinBounds(this.itemEntity.blockPosition());
            }

            @Override
            protected void start(E entity) {
                WalkTarget walkTarget = new WalkTarget(new EntityTracker(this.itemEntity, false), speedModifier, 0);
                BrainUtils.setMemory(entity, MemoryModuleType.LOOK_TARGET, new EntityTracker(this.itemEntity, true));
                BrainUtils.setMemory(entity, MemoryModuleType.WALK_TARGET, walkTarget);
            }

            @Override
            protected void stop(E entity) {
                BrainUtils.clearMemories(entity, MemoryModuleType.LOOK_TARGET, MemoryModuleType.WALK_TARGET);
            }

            @Override
            protected boolean shouldKeepRunning(E entity) {
                return this.itemEntity.isAlive();
            }
        };
    }
}
