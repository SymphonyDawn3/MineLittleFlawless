package org.projectflawless.minelittleflawless.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

@EventBusSubscriber
public class Trixie extends TamableTamersPony {
    public Trixie(EntityType<Trixie> type, Level world) {
        super(type, world);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, itemstack -> itemstack.is(Items.BEETROOT), false));
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
            retval = MineLittleFlawlessEntities.FLAWLESS.get().create(serverWorld, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);
        else
            retval = MineLittleFlawlessEntities.TRIXIE.get().create(serverWorld, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (retval != null) {
            retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
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
    public static void init(RegisterSpawnPlacementsEvent event) {
        event.register(MineLittleFlawlessEntities.TRIXIE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8), RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(MineLittleFlawlessEntities.TRIXIE.get(), TamableTamersPony.createAttributes().build());
    }
}
