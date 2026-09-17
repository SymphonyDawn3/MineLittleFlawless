package org.projectflawless.minelittleflawless.entity.ai.behavior.sblgoal2behaviour;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.util.BrainUtils;

import java.util.List;

public class SitWhenOrderedTo<E extends TamableAnimal> extends ExtendedBehaviour<E> {
    private static final List<Pair<MemoryModuleType<?>, MemoryStatus>> MEMORIES = ObjectArrayList.of(Pair.of(MemoryModuleType.WALK_TARGET, MemoryStatus.REGISTERED));
    public SitWhenOrderedTo() {
        this.noTimeout();
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
        return MEMORIES;
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, E owner) {
        if (!owner.isTame()) {
            return false;
        } else if (owner.isInWaterOrBubble()) {
            return false;
        } else if (!owner.onGround()) {
            return false;
        } else {
            LivingEntity tamedOwner = owner.getOwner();

            if (tamedOwner == null) {
                return true;
            } else {
                return (owner.distanceToSqr(tamedOwner) < 144) && (tamedOwner.getLastHurtByMob() != null) ? false : owner.isOrderedToSit();
            }
        }
    }

    @Override
    protected boolean shouldKeepRunning(E entity) {
        return entity.isOrderedToSit();
    }

    @Override
    protected void start(E entity) {
        entity.setInSittingPose(true);
    }

    @Override
    protected void tick(E entity) {
        entity.getNavigation().stop();
        BrainUtils.clearMemory(entity, MemoryModuleType.WALK_TARGET);
    }

    @Override
    protected void stop(E entity) {
        entity.setInSittingPose(false);
    }
}
