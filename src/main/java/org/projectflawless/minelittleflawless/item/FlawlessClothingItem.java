package org.projectflawless.minelittleflawless.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.projectflawless.minelittleflawless.FlawlessAdvancements;
import org.projectflawless.minelittleflawless.entity.Flawless;

public class FlawlessClothingItem extends Item {
	public FlawlessClothingItem(Properties properties) {
		super(properties.stacksTo(1));
	}

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand hand) {
        if (interactionTarget instanceof Flawless flawless) {
            if (flawless.getEntityData().get(Flawless.DATA_flawlessClothing).isEmpty()) {
                String flawlessClothing = stack.getItem().toString();
                flawless.level().playSound(null, flawless.getX(), flawless.getY(), flawless.getZ(), SoundEvents.HORSE_SADDLE, SoundSource.AMBIENT, 1, 1);

                flawless.wearClothing(stack);
                stack.consume(1, player);
                flawless.getEntityData().set(Flawless.DATA_flawlessClothing, flawlessClothing);

                if (flawless.isTame()) {
                    if (player instanceof ServerPlayer serverPlayer) {
                        FlawlessAdvancements.fashionableFlawless(serverPlayer);
                        FlawlessAdvancements.flawlessFanClub(serverPlayer);
                    }
                }

                return InteractionResult.sidedSuccess(flawless.level().isClientSide());
            }
        }

        return InteractionResult.PASS;
    }
}