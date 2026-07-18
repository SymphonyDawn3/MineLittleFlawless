package org.projectflawless.minelittleflawless;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
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

        // This allows tamed ponies to give the player bad omen if the raider they killed is a captain.
        // It also allows them to give you the Hero of the Village.
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((serverLevel, entity, killedEntity) -> {
            if (killedEntity instanceof Raider raider) {
                if (entity instanceof TamableTamersPony tamersPony && tamersPony.isTame()) {
                    if (tamersPony.getOwner() instanceof Player player) {
                        Raid raid = serverLevel.getRaidAt(killedEntity.blockPosition());

                        if (raid != null) {
                            raid.addHeroOfTheVillage(player);
                        }

                        if (raider.isPatrolLeader() && raid == null && serverLevel.getRaidAt(raider.blockPosition()) == null) {
                            ItemStack itemStack = raider.getItemBySlot(EquipmentSlot.HEAD);

                            if (!itemStack.isEmpty() && ItemStack.matches(itemStack, Raid.getLeaderBannerInstance())) {
                                MobEffectInstance mobEffectInstance = player.getEffect(MobEffects.BAD_OMEN);
                                int i = 1;
                                if (mobEffectInstance != null) {
                                    i += mobEffectInstance.getAmplifier();
                                    player.removeEffectNoUpdate(MobEffects.BAD_OMEN);
                                } else {
                                    i--;
                                }

                                i = Mth.clamp(i, 0, 4);
                                MobEffectInstance mobEffectInstance2 = new MobEffectInstance(MobEffects.BAD_OMEN, 120000, i, false, false, true);
                                if (!raider.level().getGameRules().getBoolean(GameRules.RULE_DISABLE_RAIDS)) {
                                    player.addEffect(mobEffectInstance2);
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
