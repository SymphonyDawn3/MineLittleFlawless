package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.init.MinelittleflawlessModItems;
import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import java.util.Comparator;

public class FlawlessFanClubConditionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean hasMagicianClothing = false;
		boolean hasTuxedoClothing = false;
		boolean hasFarmerClothing = false;
		boolean hasPajamasClothing = false;
		boolean hasSchoolgirlClothing = false;
		boolean hasRockstarClothing = false;
		Entity flawlessOwner = null;
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel _serverLevel0
				&& _plr0.getAdvancements().getOrStartProgress(_serverLevel0.getServer().getAdvancements().get(ResourceLocation.parse("minelittleflawless:flawless_fan_club"))).isDone())) {
			hasMagicianClothing = false;
			hasTuxedoClothing = false;
			hasFarmerClothing = false;
			hasPajamasClothing = false;
			hasSchoolgirlClothing = false;
			hasRockstarClothing = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof FlawlessEntity) {
						flawlessOwner = entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null;
						if (flawlessOwner == entity) {
							if ((entityiterator instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "")
									.equals(BuiltInRegistries.ITEM.getKey(MinelittleflawlessModItems.FLAWLESS_MAGICIAN_CLOTHING.get()).toString())) {
								hasMagicianClothing = true;
							}
							if ((entityiterator instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "").equals(BuiltInRegistries.ITEM.getKey(MinelittleflawlessModItems.TUXEDO.get()).toString())) {
								hasTuxedoClothing = true;
							}
							if ((entityiterator instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "").equals(BuiltInRegistries.ITEM.getKey(MinelittleflawlessModItems.FARMER.get()).toString())) {
								hasFarmerClothing = true;
							}
							if ((entityiterator instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "")
									.equals(BuiltInRegistries.ITEM.getKey(MinelittleflawlessModItems.PAJAMAS.get()).toString())) {
								hasPajamasClothing = true;
							}
							if ((entityiterator instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "")
									.equals(BuiltInRegistries.ITEM.getKey(MinelittleflawlessModItems.SCHOOLGIRL.get()).toString())) {
								hasSchoolgirlClothing = true;
							}
							if ((entityiterator instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "")
									.equals(BuiltInRegistries.ITEM.getKey(MinelittleflawlessModItems.ROCKSTAR.get()).toString())) {
								hasRockstarClothing = true;
							}
						}
					}
				}
			}
			if (hasMagicianClothing && hasTuxedoClothing && hasFarmerClothing && hasPajamasClothing && hasSchoolgirlClothing && hasRockstarClothing) {
				if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
					AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("minelittleflawless:flawless_fan_club"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
	}
}