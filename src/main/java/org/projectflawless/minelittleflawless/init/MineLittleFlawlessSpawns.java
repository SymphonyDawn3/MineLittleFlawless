package org.projectflawless.minelittleflawless.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MineLittleFlawlessSpawns {
    @SubscribeEvent
    public static void init(SpawnPlacementRegisterEvent event) {
        event.register(MineLittleFlawlessEntities.FLAWLESS.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos,
                 random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)
                        && world.getRawBrightness(pos, 0) > 8), SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(MineLittleFlawlessEntities.TWILIGHT.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos,
                 random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)
                        && world.getRawBrightness(pos, 0) > 8), SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(MineLittleFlawlessEntities.TRIXIE.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos,
                 random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) &&
                        world.getRawBrightness(pos, 0) > 8), SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(MineLittleFlawlessEntities.ARINOS.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, serverLevel,
                                                            spawnType, pos, random)
                        -> Monster.isDarkEnoughToSpawn(serverLevel, pos, random)
                        && Mob.checkMobSpawnRules(entityType, serverLevel, spawnType, pos, random),
                SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
