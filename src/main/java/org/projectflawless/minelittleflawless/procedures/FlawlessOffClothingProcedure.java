package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.init.MinelittleflawlessModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

public class FlawlessOffClothingProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == MinelittleflawlessModItems.FLAWLESS_MAGICIAN_CLOTHING.get()) {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).removeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"));
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).removeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"));
			}
		}
		if (itemstack.getItem() == MinelittleflawlessModItems.SCHOOLGIRL.get()) {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"));
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).removeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"));
			}
		}
		if (itemstack.getItem() == MinelittleflawlessModItems.ROCKSTAR.get()) {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"));
			}
		}
	}
}