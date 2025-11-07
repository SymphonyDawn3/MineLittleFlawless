package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class FlawlessOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String flawlessClothing = "";
		ItemStack randomFlawlessClothing = ItemStack.EMPTY;
		if (Math.random() < 0.5) {
			flawlessClothing = "";
		} else {
			randomFlawlessClothing = new ItemStack(
					(BuiltInRegistries.ITEM.getRandomElementOf(ItemTags.create(ResourceLocation.parse("minelittleflawless:flawless_clothing")), RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
			flawlessClothing = BuiltInRegistries.ITEM.getKey(randomFlawlessClothing.getItem()).toString();
			FlawlessWearClothingProcedure.execute(entity, randomFlawlessClothing);
		}
		if (entity instanceof FlawlessEntity _datEntSetS)
			_datEntSetS.getEntityData().set(FlawlessEntity.DATA_flawlessClothing, flawlessClothing);
	}
}