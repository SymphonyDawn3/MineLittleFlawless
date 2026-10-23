package org.projectflawless.minelittleflawless.entity;

import dev.architectury.registry.registries.RegistrySupplier;
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
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.MineLittleFlawlessTags;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

public class Trixiebelle extends TamableTamersPony implements Shearable {
    public boolean spanishVariant = false;

    public Trixiebelle(EntityType<Trixiebelle> type, Level world) {
        super(type, world);
        this.setUnicorn(true);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

        compound.putBoolean("SpanishVariant", this.isSpanishVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        if (compound.contains("SpanishVariant", 1)) {
            this.setSpanishVariant(compound.getBoolean("SpanishVariant"));
        }
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.BREAD), false));
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !this.getType().equals(entityType);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return this.getAmbientVariant().get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return this.getHurtVariant().get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return this.getDeathVariant().get();
    }

    private RegistrySupplier<SoundEvent> getAmbientVariant() {
        return !this.isSpanishVariant() ? MineLittleFlawlessSoundEvents.TRIXIEBELLE_AMBIENT : MineLittleFlawlessSoundEvents.TRIXIEBELLE_AMBIENT_ES;
    }

    private RegistrySupplier<SoundEvent> getHurtVariant() {
        return !this.isSpanishVariant() ? MineLittleFlawlessSoundEvents.TRIXIEBELLE_HURT : MineLittleFlawlessSoundEvents.TRIXIEBELLE_HURT_ES;
    }

    private RegistrySupplier<SoundEvent> getDeathVariant() {
        return !this.isSpanishVariant() ? MineLittleFlawlessSoundEvents.TRIXIEBELLE_DEATH : MineLittleFlawlessSoundEvents.TRIXIEBELLE_DEATH_ES;
    }

    @Override
    @NotNull
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        if (level.getRandom().nextFloat() < 0.14f) {
            this.setClothing(Clothing.TRIXIEBELLE_MEXICAN);
            this.setSpanishVariant(true);
        } else {
            this.setClothing(Clothing.TRIXIEBELLE_JESTER);
            this.setSpanishVariant(false);
        }

        return super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return super.hurt(source, amount);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        Trixiebelle retval = MineLittleFlawlessEntities.TRIXIEBELLE.get().create(level, null, null, otherParent.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (retval != null) {
            retval.finalizeSpawn(level, level.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        }

        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.BREAD);
    }

    public boolean isSpanishVariant() {
        return this.spanishVariant;
    }

    public void setSpanishVariant(boolean toggle) {
        this.spanishVariant = toggle;
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemStack = sourceentity.getItemInHand(hand);
        InteractionResult result;

        if (itemStack.is(MineLittleFlawlessTags.TRIXIEBELLE_CLOTHING)) {
            if (this.getClothing().equals(Clothing.NONE)) {
                ResourceLocation trixiebelleClothing = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.HORSE_SADDLE, SoundSource.AMBIENT, 1.0f, 1.0f);
                this.usePlayerItem(sourceentity, hand, itemStack);
                this.setClothing(trixiebelleClothing);
            }

            result = InteractionResult.sidedSuccess(sourceentity.level().isClientSide());
        } else if (itemStack.getItem() == Items.SHEARS) {
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
        ResourceLocation trixiebelleClothing = this.getClothing();
        this.spawnAtLocation(BuiltInRegistries.ITEM.get(trixiebelleClothing));
    }
}
