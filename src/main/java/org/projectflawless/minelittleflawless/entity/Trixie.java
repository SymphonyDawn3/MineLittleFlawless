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
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

@Mod.EventBusSubscriber
public class Trixie extends TamableTamersPony {
    public Trixie(EntityType<Trixie> type, Level world) {
        super(type, world);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.BEETROOT), false));
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !(entityType.is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minelittleflawless:sparklemoon_family"))));
    }

    @Override
    public SoundEvent getAmbientSound() {
        return MineLittleFlawlessSoundEvents.TRIXIE_SPEAK.get();
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
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        TamableTamersPony retval;

        if (ageable instanceof Twilight)
            retval = MineLittleFlawlessEntities.FLAWLESS.get().create(serverWorld, null, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);
        else
            retval = MineLittleFlawlessEntities.TRIXIE.get().create(serverWorld, null, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (retval != null) {
            ForgeEventFactory.onFinalizeSpawn(retval, serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        }
        return retval;
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

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(MineLittleFlawlessEntities.TRIXIE.get(), TamableTamersPony.createAttributes().build());
    }
}
