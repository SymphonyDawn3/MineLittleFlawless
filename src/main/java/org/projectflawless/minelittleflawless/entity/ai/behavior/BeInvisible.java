package org.projectflawless.minelittleflawless.entity.ai.behavior;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import org.projectflawless.minelittleflawless.entity.Fractured;

import java.util.List;
/**
 * Fractured-specific behaviour.
 */
public class BeInvisible extends ExtendedBehaviour<Fractured> {
    private static final List<Pair<MemoryModuleType<?>, MemoryStatus>> MEMORIES = ObjectArrayList.of(Pair.of(MemoryModuleType.INTERACTION_TARGET, MemoryStatus.REGISTERED), Pair.of(MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryStatus.REGISTERED));

    public BeInvisible() {
        this.noTimeout();
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
        return MEMORIES;
    }

    @Override
    protected void start(Fractured entity) {
        entity.setInvisible(true);
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, Fractured owner) {
        return this.okToBeInvisibleNow(level, owner);
    }

    @Override
    protected boolean shouldKeepRunning(Fractured entity) {
        return this.checkExtraStartConditions((ServerLevel) entity.level(), entity);
    }

    @Override
    protected void stop(Fractured entity) {
        entity.setInvisible(false);
    }

    private boolean okToBeInvisibleNow(ServerLevel level, Fractured owner) {
        return !owner.isTame() && level.isDay();
    }

}
