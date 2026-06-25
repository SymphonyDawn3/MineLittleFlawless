package org.projectflawless.minelittleflawless.entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.EntityTracker;
import net.minecraft.world.entity.ai.behavior.PositionTracker;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.behaviour.FirstApplicableBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.custom.look.LookAtTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.MoveToWalkTarget;
import net.tslat.smartbrainlib.api.core.sensor.PredicateSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyPlayersSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearestItemSensor;
import net.tslat.smartbrainlib.util.BrainUtils;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.entity.ai.behavior.GoAndThrowItems;
import org.projectflawless.minelittleflawless.entity.ai.behavior.GoToWantedItem;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

import java.util.List;
import java.util.Optional;

public class StarCatcher extends TamableTamersPony implements InventoryCarrier, SmartBrainOwner<StarCatcher> {
    private static final EntityDataAccessor<Boolean> CLEAN_DATA_ID = SynchedEntityData.defineId(StarCatcher.class, EntityDataSerializers.BOOLEAN);
    private final SimpleContainer inventory = new SimpleContainer(3);

    public StarCatcher(EntityType<StarCatcher> type, Level world) {
        super(type, world);
    }

    @Override
    public List<? extends PredicateSensor<?, ? extends StarCatcher>> getSensors() {
        return List.of(
                new NearestItemSensor<>(),
                new NearbyPlayersSensor<StarCatcher>().setPredicate(
                        (player, entity) -> !player.isSpectator() && entity.isOwnedBy(player))
        );
    }

    @Override
    protected Brain.Provider<StarCatcher> brainProvider() {
        return new SmartBrainProvider<>(this, true, false);
    }

    @Override
    public BrainActivityGroup<StarCatcher> getCoreTasks() {
        return BrainActivityGroup.coreTasks(
                new LookAtTarget<>(),
                new MoveToWalkTarget<>()
        );
    }

    @Override
    public BrainActivityGroup<? extends StarCatcher> getIdleTasks() {
        return BrainActivityGroup.idleTasks(
                new FirstApplicableBehaviour<>(
                        GoToWantedItem.create(StarCatcher::canPickUpLoot, 1.75f, true),
                        new GoAndThrowItems<>(StarCatcher::trackTarget, 1f)
                )
        );
    }

    @Override
    protected void customServerAiStep() {
        this.tickBrain(this);
        super.customServerAiStep();
    }

    @Override
    public SimpleContainer getInventory() {
        return this.inventory;
    }

    @Override
    public boolean canPickUpLoot() {
        if (this.level().isClientSide()) {
            return this.getEntityData().get(CLEAN_DATA_ID);
        } else {
            return super.canPickUpLoot();
        }
    }

    @Override
    public void setCanPickUpLoot(boolean canPickUpLoot) {
        this.getEntityData().set(CLEAN_DATA_ID, canPickUpLoot);
        super.setCanPickUpLoot(canPickUpLoot);
    }

    @Override
    public boolean wantsToPickUp(ItemStack stack) {
        // True if her inventory is not full and she can pick up through cleaning mode.
        return this.inventory.canAddItem(stack);
    }

    @Override
    protected void pickUpItem(ItemEntity itemEntity) {
        InventoryCarrier.pickUpItem(this, this, itemEntity);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(CLEAN_DATA_ID, false);
        this.getEntityData().set(CLEAN_DATA_ID, this.canPickUpLoot());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.writeInventoryToTag(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.readInventoryFromTag(compound);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.HONEY_BOTTLE), false));
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        if (this.canPickUpLoot())
            return MineLittleFlawlessSoundEvents.STAR_CATCHER_CLEAN_AROUND;
        else
            return MineLittleFlawlessSoundEvents.STAR_CATCHER_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return MineLittleFlawlessSoundEvents.STAR_CATCHER_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.STAR_CATCHER_DEATH;
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !this.getType().equals(entityType);
    }

    @Override
    protected void usePlayerItem(Player player, InteractionHand hand, ItemStack stack) {
        if (stack.is(Items.HONEY_BOTTLE) && !player.getAbilities().instabuild) {
            ItemStack glassBottle = new ItemStack(Items.GLASS_BOTTLE);
            if (!player.getInventory().add(glassBottle)) {
                player.drop(stack, false);
            }
        }
        super.usePlayerItem(player, hand, stack);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        StarCatcher retval = MineLittleFlawlessEntities.STAR_CATCHER.create(level, null, null, otherParent.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (retval != null) {
            retval.finalizeSpawn(level, level.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        }

        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.HONEY_BOTTLE);
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource damageSource, int looting, boolean hitByPlayer) {
        for (ItemStack item : this.inventory.items) {
            this.spawnAtLocation(item);
        }
        this.inventory.clearContent();
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemStack = sourceentity.getMainHandItem();

        // Set her to grab items around the vicinity if she is owned by the same player.
        if (itemStack.is(Items.BRUSH) && this.isOwnedBy(sourceentity)) {
            // If there are no items to pick up, don't go any further.
            if (!BrainUtils.hasMemory(this, MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM)) {
                boolean canPickUpLoot = this.canPickUpLoot();
                if (canPickUpLoot) {
                    this.consumeCleanToggle(false, sourceentity, itemStack, hand);
                }
                this.playSound(MineLittleFlawlessSoundEvents.STAR_CATCHER_DENY_CLEAN, this.getSoundVolume(), this.getVoicePitch());

                return canPickUpLoot ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
            }

            this.consumeCleanToggle(!this.canPickUpLoot(), sourceentity, itemStack, hand);

            this.playSound(this.canPickUpLoot() ? MineLittleFlawlessSoundEvents.STAR_CATCHER_CLEAN_ON
                    : MineLittleFlawlessSoundEvents.STAR_CATCHER_CLEAN_OFF, this.getSoundVolume(), this.getVoicePitch());

            return InteractionResult.SUCCESS;
        }

        return super.mobInteract(sourceentity, hand);
    }

    private void consumeCleanToggle(boolean toggle, Player player, ItemStack stack, InteractionHand hand) {
        this.setCanPickUpLoot(toggle);
        this.playSound(MineLittleFlawlessSoundEvents.STAR_CATCHER_CLEAN_TOGGLE);
        stack.hurtAndBreak(1, player, player1 -> {
            player1.broadcastBreakEvent(hand);
            this.setCanPickUpLoot(false);
        });
    }

    private static Optional<PositionTracker> trackTarget(StarCatcher starCatcher) {
        return BrainUtils.hasMemory(starCatcher, MemoryModuleType.NEAREST_VISIBLE_PLAYER)
                ? Optional.of(new EntityTracker(BrainUtils.getMemory(starCatcher, MemoryModuleType.NEAREST_VISIBLE_PLAYER), false))
                : Optional.empty();
    }
}
