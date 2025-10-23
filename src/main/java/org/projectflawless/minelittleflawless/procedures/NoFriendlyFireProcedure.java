package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.minecraft.world.entity.Entity;

public class NoFriendlyFireProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(entity instanceof FlawlessEntity);
	}
}