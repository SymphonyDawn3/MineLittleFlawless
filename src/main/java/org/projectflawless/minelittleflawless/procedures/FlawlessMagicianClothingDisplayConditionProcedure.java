package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.init.MinelittleflawlessModItems;
import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;

public class FlawlessMagicianClothingDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double clothingType = 0;
		return (entity instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "").equals(BuiltInRegistries.ITEM.getKey(MinelittleflawlessModItems.FLAWLESS_MAGICIAN_CLOTHING.get()).toString());
	}
}