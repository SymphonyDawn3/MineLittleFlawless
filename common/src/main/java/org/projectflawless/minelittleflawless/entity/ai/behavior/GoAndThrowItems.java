package org.projectflawless.minelittleflawless.entity.ai.behavior;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.behavior.PositionTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.item.ItemStack;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.util.BrainUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class GoAndThrowItems<E extends LivingEntity & InventoryCarrier> extends ExtendedBehaviour<E> {
    private static final List<Pair<MemoryModuleType<?>, MemoryStatus>> MEMORY_REQUIREMENTS = ObjectArrayList.of(
            Pair.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED),
            Pair.of(MemoryModuleType.WALK_TARGET, MemoryStatus.REGISTERED),
            Pair.of(MemoryModuleType.ITEM_PICKUP_COOLDOWN_TICKS, MemoryStatus.REGISTERED)
    );

    private final Function<E, Optional<PositionTracker>> targetPositionTracker;
    private final float speedModifier;

    public GoAndThrowItems(Function<E, Optional<PositionTracker>> targetPositionTracker, float speedModifier) {
        this.targetPositionTracker = targetPositionTracker;
        this.speedModifier = speedModifier;
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, E entity) {
        return this.canThrowItems(entity);
    }

    @Override
    protected boolean canStillUse(ServerLevel level, E entity, long gameTime) {
        return this.canThrowItems(entity);
    }

    @Override
    protected void start(E entity) {
        this.targetPositionTracker.apply(entity).ifPresent(positionTracker -> {
            WalkTarget walkTarget = new WalkTarget(positionTracker, this.speedModifier, 3);
            BrainUtils.setMemory(entity, MemoryModuleType.LOOK_TARGET, positionTracker);
            BrainUtils.setMemory(entity, MemoryModuleType.WALK_TARGET, walkTarget);
        });
    }

    @Override
    protected void stop(E entity) {
        BrainUtils.clearMemory(entity, MemoryModuleType.LOOK_TARGET);
        BrainUtils.clearMemory(entity, MemoryModuleType.WALK_TARGET);
    }

    @Override
    protected void tick(E entity) {
        Optional<PositionTracker> optional = this.targetPositionTracker.apply(entity);
        if (optional.isPresent()) {
            PositionTracker positionTracker = optional.get();
            double distance = positionTracker.currentPosition().distanceTo(entity.getEyePosition());
            if (distance < 3.0) {
                List<ItemStack> entityItems = entity.getInventory().removeAllItems();

                for (ItemStack itemStack : entityItems) {
                    entity.swing(InteractionHand.MAIN_HAND);
                    BehaviorUtils.throwItem(entity, itemStack, positionTracker.currentPosition());
                }
            }
        }
    }

    private boolean canThrowItems(E entity) {
        if (entity.getInventory().isEmpty()) {
            return false;
        } else {
            Optional<PositionTracker> optional = this.targetPositionTracker.apply(entity);
            return optional.isPresent();
        }
    }
}
