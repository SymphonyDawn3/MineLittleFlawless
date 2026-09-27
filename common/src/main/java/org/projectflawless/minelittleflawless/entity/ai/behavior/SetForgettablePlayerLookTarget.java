package org.projectflawless.minelittleflawless.entity.ai.behavior;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.EntityTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.player.Player;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetPlayerLookTarget;
import net.tslat.smartbrainlib.util.BrainUtils;
import net.tslat.smartbrainlib.util.RandomUtil;

public class SetForgettablePlayerLookTarget<E extends LivingEntity> extends SetPlayerLookTarget<E> {
    @Override
    protected void start(E entity) {
        BrainUtils.setForgettableMemory(entity, MemoryModuleType.LOOK_TARGET, new EntityTracker(this.target, true), entity.getRandom().nextInt(40, 80));
    }

    @Override
    protected boolean defaultPredicate(E entity, Player player) {
        return super.defaultPredicate(entity, player) && RandomUtil.percentChance(0.02f);
    }
}
