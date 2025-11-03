package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.init.MinelittleflawlessModItems;
import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;

public class TuxedoDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "").equals(BuiltInRegistries.ITEM.getKey(MinelittleflawlessModItems.TUXEDO.get()).toString());
	}
}