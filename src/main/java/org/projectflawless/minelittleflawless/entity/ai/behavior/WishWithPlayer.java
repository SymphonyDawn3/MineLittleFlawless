package org.projectflawless.minelittleflawless.entity.ai.behavior;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.player.Player;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import org.projectflawless.minelittleflawless.entity.WishFulfillment;

import java.awt.*;
import java.util.List;

public class WishWithPlayer extends ExtendedBehaviour<WishFulfillment> {
    public WishWithPlayer() {
        this.noTimeout();
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
        return ImmutableList.of();
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, WishFulfillment owner) {
        if (!owner.isAlive() || owner.isInWater() || !owner.onGround() || owner.hurtMarked) {
            return false;
        }
        else {
            Player player = owner.getTradingPlayer();
            if (player == null)
                return false;
            else
                return owner.distanceToSqr(player) < 16.0;
        }
    }

    @Override
    protected boolean shouldKeepRunning(WishFulfillment entity) {
        Player tradingPlayer = entity.getTradingPlayer();
        return tradingPlayer != null && tradingPlayer.containerMenu != null;
    }

    @Override
    protected void tick(WishFulfillment entity) {
        entity.getNavigation().stop();

        Player tradingPlayer = entity.getTradingPlayer();
        if (tradingPlayer != null)
            entity.getLookControl().setLookAt(tradingPlayer);
    }

    @Override
    protected void stop(WishFulfillment entity) {
        entity.setTradingPlayer(null);
    }
}
