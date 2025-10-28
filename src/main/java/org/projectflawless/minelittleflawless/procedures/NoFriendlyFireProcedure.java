package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;

public class NoFriendlyFireProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;

		TamableAnimal flawlessHerself = (TamableAnimal) entity;
		LivingEntity flawlessOwner = flawlessHerself.getOwner();
		LivingEntity entityOwnerHit = flawlessOwner.getLastHurtMob();
		
		return !(entityOwnerHit instanceof FlawlessEntity);
	}
}