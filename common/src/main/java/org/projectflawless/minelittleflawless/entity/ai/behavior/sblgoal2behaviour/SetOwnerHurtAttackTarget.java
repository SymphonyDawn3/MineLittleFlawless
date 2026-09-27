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

public class SetOwnerHurtAttackTarget<E extends TamableAnimal> extends ExtendedBehaviour<E> {
    private static final List<Pair<MemoryModuleType<?>, MemoryStatus>> MEMORIES = ObjectArrayList.of(Pair.of(MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_ABSENT));
    private LivingEntity lastHurtOwnerAttackable;
    private int timestamp;

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
        return MEMORIES;
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, E owner) {
        if (owner.isTame() && !owner.isOrderedToSit()) {
            LivingEntity tamableOwner = owner.getOwner();

            if (tamableOwner == null)
                return false;

            LivingEntity lastHurtByOwner = tamableOwner.getLastHurtMob();

            if (lastHurtByOwner == null)
                return false;

            this.lastHurtOwnerAttackable = lastHurtByOwner;

            int lastHurtTimestamp = tamableOwner.getLastHurtMobTimestamp();

            return (this.timestamp != lastHurtTimestamp) && SensoryUtils.isEntityAttackable(owner, this.lastHurtOwnerAttackable)
                    && owner.wantsToAttack(lastHurtByOwner, this.lastHurtOwnerAttackable);
        } else {
            return false;
        }
    }

    @Override
    protected void start(E entity) {
        BrainUtils.setMemory(entity, MemoryModuleType.ATTACK_TARGET, this.lastHurtOwnerAttackable);

        LivingEntity tamableOwner = entity.getOwner();
        if (tamableOwner != null) {
            this.timestamp = tamableOwner.getLastHurtMobTimestamp();
        }
    }
}
