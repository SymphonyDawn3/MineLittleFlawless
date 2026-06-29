package org.projectflawless.minelittleflawless;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.projectflawless.minelittleflawless.entity.Flawless;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;

public class FlawlessEvents {
    public static void init() {
        // This allows farmer Flawless to give you items whenever you go to bed.
        EntitySleepEvents.ALLOW_SLEEPING.register(Flawless::whenPlayerWakesUp);

        // This allows tamed ponies to make their enemies drop XP and items otherwise only obtainable only by players
        // and tamed wolves.
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            Entity entity1 = source.getEntity();
            if (entity1 instanceof TamableTamersPony tamersPony && tamersPony.isTame()) {
                if (tamersPony.getOwner() instanceof Player player)
                    entity.setLastHurtByPlayer(player);
            }
            return true;
        });
    }
}
