package org.projectflawless.minelittleflawless.entity;

import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;
import org.projectflawless.minelittleflawless.MineLittleFlawlessTags;

public class Trixie extends TamableTamersPony implements Shearable {
    public static final ResourceLocation[] CLOTHING_TYPES = { Clothing.NONE, Clothing.TRIXIE_MAGICIAN,
            Clothing.TRIXIE_BLACK_MAGICIAN, Clothing.TRIXIE_GIR, Clothing.TRIXIE_SCHOOLGIRL };

    public Trixie(EntityType<Trixie> type, Level world) {
        super(type, world);
        this.setUnicorn(true);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.BEETROOT), false));
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !(entityType.is(MineLittleFlawlessTags.SPARKLEMOON_FAMILY));
    }

    @Override
    public SoundEvent getAmbientSound() {
        return MineLittleFlawlessSoundEvents.TRIXIE_AMBIENT.get();
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return MineLittleFlawlessSoundEvents.TRIXIE_HURT.get();
    }

    @Override
    public SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.TRIXIE_DEATH.get();
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        ResourceLocation randomClothing = Util.getRandom(CLOTHING_TYPES, level.getRandom());
        this.setClothing(randomClothing);

        return super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        TamableTamersPony retval;

        if (ageable instanceof Twilight)
            retval = MineLittleFlawlessEntities.FLAWLESS.get().create(serverWorld, null, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);
        else
            retval = MineLittleFlawlessEntities.TRIXIE.get().create(serverWorld, null, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (retval != null) {
            retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        }
        return retval;
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemStack = sourceentity.getItemInHand(hand);
        InteractionResult result;

        if (itemStack.is(MineLittleFlawlessTags.TRIXIE_CLOTHING)) {
            if (this.getClothing().equals(Clothing.NONE)) {
                ResourceLocation trixieClothing = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.HORSE_SADDLE, SoundSource.AMBIENT, 1.0f, 1.0f);
                this.usePlayerItem(sourceentity, hand, itemStack);
                this.setClothing(trixieClothing);
            }

            result = InteractionResult.sidedSuccess(sourceentity.level().isClientSide());
        } else if (itemStack.is(Items.SHEARS)) {
            if (!this.level().isClientSide()) {
                this.shear(SoundSource.PLAYERS);
                this.gameEvent(GameEvent.SHEAR, sourceentity);
                itemStack.hurtAndBreak(1, sourceentity, player -> player.broadcastBreakEvent(hand));
                result = InteractionResult.SUCCESS;
            } else {
                result = InteractionResult.CONSUME;
            }
        } else {
            result = super.mobInteract(sourceentity, hand);
        }

        return result;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.BEETROOT);
    }

    @Override
    public boolean canMate(Animal otherAnimal) {
        if ((otherAnimal == this) || (otherAnimal instanceof Flawless))
            return false;

        return this.isInLove() && otherAnimal.isInLove();
    }

    @Override
    public void shear(SoundSource source) {
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.HORSE_SADDLE, source, 1.0f, 1.0f);
        this.dropClothing();
        this.setClothing(Clothing.NONE);
    }

    @Override
    public boolean readyForShearing() {
        return !this.getClothing().equals(Clothing.NONE);
    }

    private void dropClothing() {
        ResourceLocation trixieClothing = this.getClothing();
        this.spawnAtLocation(BuiltInRegistries.ITEM.get(trixieClothing));
    }
}
