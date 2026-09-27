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
import net.tslat.smartbrainlib.util.SensoryUtils;

import java.util.List;

public class SetOwnerHurtByAttackTarget<E extends TamableAnimal> extends ExtendedBehaviour<E> {
    private static final List<Pair<MemoryModuleType<?>, MemoryStatus>> MEMORIES = ObjectArrayList.of(Pair.of(MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_ABSENT));
    private LivingEntity lastHurtByMobAttackable;
    private int timestamp;

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
        return MEMORIES;
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, E owner) {
        if (owner.isTame() && !owner.isOrderedToSit()) {
            LivingEntity tamedOwner = owner.getOwner();

            if (tamedOwner == null)
                return false;

            LivingEntity lastHurtByMob = tamedOwner.getLastHurtByMob();

            if (lastHurtByMob == null)
                return false;

            this.lastHurtByMobAttackable = lastHurtByMob;

            int lastHurtByMobTimestamp = tamedOwner.getLastHurtByMobTimestamp();

            return (this.timestamp != lastHurtByMobTimestamp) && SensoryUtils.isEntityAttackable(owner, lastHurtByMob)
                    && owner.wantsToAttack(lastHurtByMob, tamedOwner);
        } else {
            return false;
        }
    }

    @Override
    protected void start(E entity) {
        BrainUtils.setMemory(entity, MemoryModuleType.ATTACK_TARGET, this.lastHurtByMobAttackable);

        LivingEntity tamedOwner = entity.getOwner();
        if (tamedOwner != null)
            this.timestamp = tamedOwner.getLastHurtByMobTimestamp();
    }
}
