package org.projectflawless.minelittleflawless.event;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;

@FunctionalInterface
public interface PlayerSleepEvent {
    Event<PlayerSleepEvent> SLEEPING = EventFactory.createLoop();

    Player.BedSleepingProblem onPlayerSleep(Player player, BlockPos pos);
}
