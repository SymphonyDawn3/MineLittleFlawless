package org.projectflawless.minelittleflawless.mixin;


import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(NaturalSpawner.class)
final class NaturalSpawnerMixin {
    @WrapMethod(method = "spawnMobsForChunkGeneration")
    private static void spawnWithModdedMobsForChunkGeneration(ServerLevelAccessor levelAccessor, Holder<Biome> biome, ChunkPos chunkPos, RandomSource random, Operation<Void> original, @Share("mobCategory") LocalRef<MobCategory> mobCategoryLocalRef) {
        mobCategoryLocalRef.set(MobCategory.CREATURE);
        original.call(levelAccessor, biome, chunkPos, random);

        mobCategoryLocalRef.set(MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT);
        original.call(levelAccessor, biome, chunkPos, random);
    }

    @ModifyArg(
            method = "spawnMobsForChunkGeneration",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/biome/MobSpawnSettings;getMobs(Lnet/minecraft/world/entity/MobCategory;)Lnet/minecraft/util/random/WeightedRandomList;"),
            index = 0
    )
    private static MobCategory supportMobCategoryArgumentForModdedCategories(MobCategory mobCategory, @Share("mobCategory") LocalRef<MobCategory> mobCategoryLocalRef) {
        return mobCategoryLocalRef.get();
    }
}
