package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.init.MinelittleflawlessModItems;
import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.BuiltInRegistries;

import javax.annotation.Nullable;

@EventBusSubscriber
public class IfFlawlessIsAttackingProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		String flawlessClothing = "";
		if (sourceentity instanceof FlawlessEntity) {
			flawlessClothing = sourceentity instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "";
			if ((flawlessClothing).equals(BuiltInRegistries.ITEM.getKey(MinelittleflawlessModItems.PAJAMAS.get()).toString())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 1));
			}
			if ((flawlessClothing).equals(BuiltInRegistries.ITEM.getKey(MinelittleflawlessModItems.FARMER.get()).toString())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
			}
			if ((flawlessClothing).equals(BuiltInRegistries.ITEM.getKey(MinelittleflawlessModItems.SCHOOLGIRL.get()).toString())) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 200, 1));
			}
		}
	}
}