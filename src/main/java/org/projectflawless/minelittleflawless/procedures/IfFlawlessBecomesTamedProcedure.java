package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.neoforged.neoforge.event.entity.living.AnimalTameEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

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
		execute(event, event.getAnimal());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		String flawlessClothing = "";
		ItemStack newClothing = ItemStack.EMPTY;
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
		}
	}
}