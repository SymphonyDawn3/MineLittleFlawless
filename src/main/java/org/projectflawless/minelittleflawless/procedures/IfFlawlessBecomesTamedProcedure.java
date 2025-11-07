package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.neoforged.neoforge.event.entity.living.AnimalTameEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class IfFlawlessBecomesTamedProcedure {
	@SubscribeEvent
	public static void onEntityTamed(AnimalTameEvent event) {
		execute(event, event.getAnimal().level(), event.getAnimal().getX(), event.getAnimal().getY(), event.getAnimal().getZ(), event.getAnimal(), event.getTamer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof FlawlessEntity) {
			if (!(entity instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "").isEmpty()) {
				FashionableFlawlessConditionProcedure.execute(sourceentity);
			}
			FlawlessFriendshipConditionProcedure.execute(sourceentity);
			FlawlessBuddiesConditionProcedure.execute(world, x, y, z, sourceentity);
			FlawlessEnchiladaConditionProcedure.execute(world, x, y, z, sourceentity);
			FlawlessFanClubConditionProcedure.execute(world, x, y, z, sourceentity);
		}
	}
}