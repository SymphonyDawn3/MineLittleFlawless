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
    public static <E extends LivingEntity> ExtendedBehaviour<E> create(float speedModifier, boolean hasTarget, int maxDistToWalk) {
        return create(livingEntity -> true, speedModifier, hasTarget, maxDistToWalk);
    }

    public static <E extends LivingEntity> ExtendedBehaviour<E> create(Predicate<E> canWalkToItem, float speedModifier, boolean hasTarget, int maxDistToWalk) {
        return new ExtendedBehaviour<>() {
            private ItemEntity itemEntity;

            @Override
            protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
                return ObjectArrayList.of(
                        Pair.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED),
                        Pair.of(MemoryModuleType.WALK_TARGET, hasTarget ? MemoryStatus.REGISTERED : MemoryStatus.VALUE_ABSENT),
                        Pair.of(MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM, MemoryStatus.VALUE_PRESENT),
                        Pair.of(MemoryModuleType.ITEM_PICKUP_COOLDOWN_TICKS, MemoryStatus.REGISTERED)
                );
            }

            @Override
            protected boolean checkExtraStartConditions(ServerLevel level, E entity) {
                ItemEntity itemEntity = BrainUtils.getMemory(entity, MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM);

                if (itemEntity != null) {
                    this.itemEntity = itemEntity;
                    return !BrainUtils.hasMemory(entity, MemoryModuleType.ITEM_PICKUP_COOLDOWN_TICKS)
                            && canWalkToItem.test(entity)
                            && this.itemEntity.closerThan(entity, maxDistToWalk)
                            && entity.level().getWorldBorder().isWithinBounds(this.itemEntity.blockPosition());
                } else {
                    return false;
                }
            }

            @Override
            protected void start(E entity) {
                WalkTarget walkTarget = new WalkTarget(new EntityTracker(this.itemEntity, false), speedModifier, 0);
                BrainUtils.setMemory(entity, MemoryModuleType.LOOK_TARGET, new EntityTracker(this.itemEntity, true));
                BrainUtils.setMemory(entity, MemoryModuleType.WALK_TARGET, walkTarget);
            }

            @Override
            protected void stop(E entity) {
                BrainUtils.clearMemory(entity, MemoryModuleType.LOOK_TARGET);
                BrainUtils.clearMemory(entity, MemoryModuleType.WALK_TARGET);
            }

            @Override
            protected boolean shouldKeepRunning(E entity) {
                return BrainUtils.hasMemory(entity, MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM);
            }
        };
    }
}
