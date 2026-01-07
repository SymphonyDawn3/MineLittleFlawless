package org.projectflawless.minelittleflawless;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import java.util.List;
import java.util.stream.Stream;

public class FlawlessAdvancements {
    private static class InternalFlawlessAdvancement {
        final private ServerPlayer serverPlayer;
        final private PlayerAdvancements playerAdvancements;
        private AdvancementHolder advHolder;
        private AdvancementProgress progress;

        private InternalFlawlessAdvancement(ServerPlayer serverPlayer, ResourceLocation advancementResource) {
            this.serverPlayer = serverPlayer;
            this.playerAdvancements = serverPlayer.getAdvancements();
            MinecraftServer minecraftServer = serverPlayer.getServer();
            if (minecraftServer != null) {
                this.advHolder = minecraftServer.getAdvancements().get(advancementResource);
                if (this.advHolder != null) {
                    this.progress = this.playerAdvancements.getOrStartProgress(this.advHolder);
                }
            }
        }

        private void processAdvancement(long flawlessMaxCount, boolean needsToBeClothed) {
            if (!this.progress.isDone()) {
                final Vec3 _center = new Vec3(this.serverPlayer.getX(), this.serverPlayer.getY(), this.serverPlayer.getZ());

                List<FlawlessEntity> flawlesses = serverPlayer.level().getEntitiesOfClass(FlawlessEntity.class, new AABB(_center, _center).inflate(64 / 2d),
                        flawless ->
                            flawless.isTame()
                                    && flawless.isOwnedBy(this.serverPlayer));

                Stream<String> flawlessClothingStream = flawlesses.stream()
                        .map(flawless -> flawless.getEntityData().get(FlawlessEntity.DATA_flawlessClothing))
                        .filter(flawlessClothing -> needsToBeClothed != flawlessClothing.isEmpty());

                long flawlessCount = needsToBeClothed ? flawlessClothingStream.distinct().count() : flawlessClothingStream.count();

                if (flawlessCount >= flawlessMaxCount) {
                    for (String criteria : this.progress.getRemainingCriteria())
                        this.playerAdvancements.award(this.advHolder, criteria);
                }
            }
        }
    }

    public static void flawlessFriendship(ServerPlayer serverPlayer) {
        InternalFlawlessAdvancement flawlessAdvancement = new InternalFlawlessAdvancement(
                serverPlayer, ResourceLocation.parse("minelittleflawless:flawless_friendship"));

        flawlessAdvancement.processAdvancement(1, false);
    }

    public static void fashionableFlawless(ServerPlayer serverPlayer) {
        InternalFlawlessAdvancement flawlessAdvancement = new InternalFlawlessAdvancement(
                serverPlayer, ResourceLocation.parse("minelittleflawless:fashionable_flawless"));

        flawlessAdvancement.processAdvancement(1, true);
    }

    public static void flawlessBuddles(ServerPlayer serverPlayer) {
        InternalFlawlessAdvancement flawlessAdvancement = new InternalFlawlessAdvancement(
                serverPlayer, ResourceLocation.parse("minelittleflawless:flawless_buddies"));

        flawlessAdvancement.processAdvancement(2, false);
    }

    public static void flawlessEnchilada(ServerPlayer serverPlayer) {
        InternalFlawlessAdvancement flawlessAdvancement = new InternalFlawlessAdvancement(
                serverPlayer, ResourceLocation.parse("minelittleflawless:flawless_enchilada"));

        flawlessAdvancement.processAdvancement(6, false);
    }

    public static void flawlessFanClub(ServerPlayer serverPlayer) {
        InternalFlawlessAdvancement flawlessAdvancement = new InternalFlawlessAdvancement(
                serverPlayer, ResourceLocation.parse("minelittleflawless:flawless_fan_club"));

        flawlessAdvancement.processAdvancement(6, true);
    }
}
