package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.init.MinelittleflawlessModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

public class FlawlessWearClothingProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == MinelittleflawlessModItems.FLAWLESS_MAGICIAN_CLOTHING.get()) {
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"), 5, AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).addPermanentModifier(modifier);
				}
			}
		}
		if (itemstack.getItem() == MinelittleflawlessModItems.SCHOOLGIRL.get()) {
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"), 1, AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).addPermanentModifier(modifier);
				}
			}
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"), 1, AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).addPermanentModifier(modifier);
				}
			}
		}
		if (itemstack.getItem() == MinelittleflawlessModItems.ROCKSTAR.get()) {
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"), 0.1, AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
				}
			}
		}
	}
}