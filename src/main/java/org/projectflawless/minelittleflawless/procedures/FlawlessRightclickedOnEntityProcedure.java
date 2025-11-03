package org.projectflawless.minelittleflawless.procedures;

import org.projectflawless.minelittleflawless.entity.FlawlessEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

public class FlawlessRightclickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		String flawlessClothing = "";
		ItemStack itemInHand = ItemStack.EMPTY;
		ItemStack droppedClothing = ItemStack.EMPTY;
		itemInHand = itemstack.copy();
		if (itemInHand.is(ItemTags.create(ResourceLocation.parse("minelittleflawless:flawless_clothing")))) {
			if ((entity instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "").isEmpty()) {
				flawlessClothing = BuiltInRegistries.ITEM.getKey(itemInHand.getItem()).toString();
				if (world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.horse.saddle")), SoundSource.AMBIENT, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.horse.saddle")), SoundSource.AMBIENT, 1, 1, false);
						}
					}
				}
				FlawlessWearClothingProcedure.execute(entity, itemInHand);
				if (getEntityGameType(sourceentity) == GameType.SURVIVAL) {
					itemstack.shrink(1);
				}
				if (entity instanceof FlawlessEntity _datEntSetS)
					_datEntSetS.getEntityData().set(FlawlessEntity.DATA_flawlessClothing, flawlessClothing);
			}
		}
		if (itemInHand.getItem() == Items.SHEARS) {
			flawlessClothing = entity instanceof FlawlessEntity _datEntS ? _datEntS.getEntityData().get(FlawlessEntity.DATA_flawlessClothing) : "";
			if (!(flawlessClothing).isEmpty()) {
				droppedClothing = new ItemStack(BuiltInRegistries.ITEM.getValue(ResourceLocation.parse((flawlessClothing).toLowerCase(java.util.Locale.ENGLISH)))).copy();
				if (world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.saddle.unequip")), SoundSource.AMBIENT, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.saddle.unequip")), SoundSource.AMBIENT, 1, 1, false);
						}
					}
				}
				FlawlessOffClothingProcedure.execute(entity, droppedClothing);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, droppedClothing);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				flawlessClothing = "";
				if (entity instanceof FlawlessEntity _datEntSetS)
					_datEntSetS.getEntityData().set(FlawlessEntity.DATA_flawlessClothing, flawlessClothing);
				if (getEntityGameType(sourceentity) == GameType.SURVIVAL) {
					if (world instanceof ServerLevel _level) {
						itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}