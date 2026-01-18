package org.projectflawless.minelittleflawless.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;

@EventBusSubscriber
public class Twilight extends SparklemoonFamily {
    public Twilight(EntityType<Twilight> type, Level world) {
        super(type, world);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, itemstack -> itemstack.is(Items.BOOK), false));
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        SparklemoonFamily retval;

        if (ageable instanceof Trixie)
            retval = MineLittleFlawlessEntities.FLAWLESS.get().create(serverWorld, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);
        else
            retval = MineLittleFlawlessEntities.TWILIGHT.get().create(serverWorld, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (retval != null) {
            retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
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

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(MineLittleFlawlessEntities.TWILIGHT.get(), SparklemoonFamily.createAttributes().build());
    }
}
