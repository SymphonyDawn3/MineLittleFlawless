package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.init.MinelittleflawlessModItems;
import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;

public class FlawlessEntityIsHurtProcedure {
	public static boolean execute(DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return false;
		String flawlessClothing = "";
		flawlessClothing = entity instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "";
		if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("minecraft:is_fire")))) {
			if (BuiltInRegistries.ITEM.getValue(ResourceLocation.parse((flawlessClothing).toLowerCase(java.util.Locale.ENGLISH))) == MinelittleflawlessModItems.TUXEDO.get()) {
				return false;
			}
		}
		return true;
	}
}