package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.neoforged.neoforge.event.entity.living.AnimalTameEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

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
		String flawlessClothing = "";
		ItemStack newClothing = ItemStack.EMPTY;
		double tamedFlawlessCount = 0;
		if (entity instanceof FlawlessEntity) {
			flawlessClothing = entity instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "";
			if ((flawlessClothing).isEmpty()) {
				newClothing = new ItemStack(
						(BuiltInRegistries.ITEM.getRandomElementOf(ItemTags.create(ResourceLocation.parse("minelittleflawless:flawless_clothing")), RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()))
						.copy();
				flawlessClothing = BuiltInRegistries.ITEM.getKey(newClothing.getItem()).toString();
				FlawlessWearClothingProcedure.execute(entity, newClothing);
				if (entity instanceof FlawlessEntity _datEntSetS)
					_datEntSetS.getEntityData().set(FlawlessEntity.DATA_flawlessClothing, flawlessClothing);
			}
			FashionableFlawlessConditionProcedure.execute(sourceentity);
			FlawlessFriendshipConditionProcedure.execute(sourceentity);
			FlawlessBuddiesConditionProcedure.execute(world, x, y, z, sourceentity);
			FlawlessEnchiladaConditionProcedure.execute(world, x, y, z, sourceentity);
			FlawlessFanClubConditionProcedure.execute(world, x, y, z, sourceentity);
		}
	}
}