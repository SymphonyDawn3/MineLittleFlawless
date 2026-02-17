package org.projectflawless.minelittleflawless.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

public class Twilight extends TamableTamersPony {
    public Twilight(EntityType<Twilight> type, Level world) {
        super(type, world);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.BOOK), false));
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !(entityType.is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minelittleflawless:sparklemoon_family"))));
    }

    @Override
    public SoundEvent getAmbientSound() {
        return MineLittleFlawlessSoundEvents.TWILIGHT_SPEAK;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return MineLittleFlawlessSoundEvents.TWILIGHT_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.TWILIGHT_DEATH;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        TamableTamersPony retval;

        if (ageable instanceof Trixie)
            retval = MineLittleFlawlessEntities.FLAWLESS.create(serverWorld, null, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);
        else
            retval = MineLittleFlawlessEntities.TWILIGHT.create(serverWorld, null, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (retval != null) {
            retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        }
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.BOOK);
    }

    @Override
    public boolean canMate(Animal otherAnimal) {
        if ((otherAnimal == this) || (otherAnimal instanceof Flawless))
            return false;

        return this.isInLove() && otherAnimal.isInLove();
    }
}
