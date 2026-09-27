package org.projectflawless.minelittleflawless.entity;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.behaviour.AllApplicableBehaviours;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.AnimatableMeleeAttack;
import net.tslat.smartbrainlib.api.core.behaviour.custom.look.LookAtTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.BreedWithPartner;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.*;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetRandomWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetWalkTargetToAttackTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.InvalidateAttackTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetRandomLookTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.TargetOrRetaliate;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;

import net.tslat.smartbrainlib.api.core.sensor.custom.GenericAttackTargetSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.HurtBySensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.ItemTemptingSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyPlayersSensor;
import net.tslat.smartbrainlib.util.BrainUtils;
import net.tslat.smartbrainlib.util.RandomUtil;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.entity.ai.behavior.BeInvisible;
import org.projectflawless.minelittleflawless.entity.ai.behavior.BeSilent;
import org.projectflawless.minelittleflawless.entity.ai.behavior.SetForgettablePlayerLookTarget;
import org.projectflawless.minelittleflawless.entity.ai.behavior.sblgoal2behaviour.SetOwnerHurtAttackTarget;
import org.projectflawless.minelittleflawless.entity.ai.behavior.sblgoal2behaviour.SetOwnerHurtByAttackTarget;
import org.projectflawless.minelittleflawless.entity.ai.behavior.sblgoal2behaviour.SitWhenOrderedTo;
import org.projectflawless.minelittleflawless.entity.ai.sensor.FracturedSpecificSensor;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

import java.util.List;
import java.util.Optional;

public class Fractured extends TamableTamersPony implements SmartBrainOwner<Fractured> {
    public Fractured(EntityType<Fractured> type, Level world) {
        super(type, world);
        this.setUnicorn(true);
        this.setClothing(Clothing.FRACTURED_TUXEDO);
    }

    @Override
    protected void registerGoals() {
    }

    @Override
    public List<ExtendedSensor<Fractured>> getSensors() {
        return ObjectArrayList.of(
                new NearbyLivingEntitySensor<>(),
                new ItemTemptingSensor<Fractured>()
                        .temptedWith(Fractured::isFood),
                new NearbyPlayersSensor<>(),
                new HurtBySensor<>(),
                new GenericAttackTargetSensor<>(),
                new FracturedSpecificSensor()
        );
    }

    @Override
    public BrainActivityGroup<Fractured> getCoreTasks() {
        return BrainActivityGroup.coreTasks(
                new FloatToSurfaceOfFluid<>(),
                new LookAtTarget<>(),
                new MoveToWalkTarget<>(),
                new BeInvisible(),
                new BeSilent()
        );
    }

    @Override
    public BrainActivityGroup<Fractured> getIdleTasks() {
        return BrainActivityGroup.idleTasks(
                new SetForgettablePlayerLookTarget<>(),
                new SetRandomLookTarget<>(),
                new SetRandomWalkTarget<>().startCondition(fractured -> RandomUtil.oneInNChance(180)),
                new AllApplicableBehaviours<>(
                        new FollowEntity<Fractured, LivingEntity>()
                                .following(Fractured::getFollowingFlawless)
                                .stopFollowingWithin(2.0)
                                .startCondition(fractured -> !fractured.isTame() && fractured.level().isDay()),
                        new FollowParent<>(),
                        new FollowOwner<>()
                                .stopFollowingWithin(2.0)
                                .startCondition(fractured -> !fractured.isOrderedToSit())
                ).whenStopping(fractured -> BrainUtils.clearMemory(fractured, MemoryModuleType.LOOK_TARGET)),
                new FollowTemptation<>().followIf((fractured, player) -> !fractured.isInvisible()),
                new TargetOrRetaliate<>()
                        .attackablePredicate(this::shouldAttack),
                new SetOwnerHurtAttackTarget<>(),
                new SetOwnerHurtByAttackTarget<>(),
                new BreedWithPartner<>(),
                new SitWhenOrderedTo<>()
        );
    }

    @Override
    public BrainActivityGroup<Fractured> getFightTasks() {
        return BrainActivityGroup.fightTasks(
                new InvalidateAttackTarget<Fractured>()
                        .invalidateIf(this::shouldInvalidateAttack)
                        .whenStarting(fractured -> BrainUtils.clearMemory(fractured, MemoryModuleType.LOOK_TARGET)),
                new SetWalkTargetToAttackTarget<>().speedMod((fractured, livingEntity) -> 1.2f),
                new AnimatableMeleeAttack<>(0)
        );
    }

    @Override
    protected void customServerAiStep() {
        this.tickBrain(this);
        super.customServerAiStep();
    }

    @Override
    protected Brain.Provider<?> brainProvider() {
        return new SmartBrainProvider<>(this, true, false);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return MineLittleFlawlessSoundEvents.FRACTURED_AMBIENT.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return MineLittleFlawlessSoundEvents.FRACTURED_HURT.get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.FRACTURED_DEATH.get();
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        Fractured babyFractured = (Fractured) this.getType().create(level, null, null, otherParent.blockPosition(), MobSpawnType.BREEDING, false, false);
        if (babyFractured != null) {
            if (this.isTame() && (this.getOwner() instanceof Player player)) {
                babyFractured.tame(player);
            }

            babyFractured.finalizeSpawn(level, level.getCurrentDifficultyAt(babyFractured.blockPosition()), MobSpawnType.BREEDING, null, null);
        }

        return babyFractured;
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return this.isFlawlessNotAround() && this.level().isNight();
    }

    private boolean shouldAttack(LivingEntity target) {
        if (target instanceof Raider raider && raider.getCurrentRaid() != null && !this.isTame()) {
            return false;
        } else if (target instanceof Player player) {
            return this.shouldBeAggressive(player);
        } else {
                return target instanceof Enemy;
        }
    }

    private boolean shouldInvalidateAttack(Fractured fractured, LivingEntity target) {
        return (target instanceof Player player) && !fractured.isTame() && !fractured.shouldBeAggressive(player);
    }

    public boolean shouldBeAggressive(Player player) {
        return !this.isTame() && !this.isBaby() && this.level().isNight() && this.isFlawlessNotAround() && !this.hasFoodInHand(player);
    }

    private boolean hasFoodInHand(LivingEntity target) {
        return this.isFood(target.getMainHandItem()) || this.isFood(target.getOffhandItem());
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(MineLittleFlawlessItems.ROTTEN_SUGAR.get());
    }

    @Nullable
    public LivingEntity getFollowingFlawless() {
        Optional<LivingEntity> nearestFlawless = this.getNearestFlawless();

        return nearestFlawless.orElse(null);
    }

    public boolean isFlawlessNotAround() {
        Optional<LivingEntity> nearestFlawless = this.getNearestFlawless();

        return nearestFlawless.isEmpty();
    }

    private Optional<LivingEntity> getNearestFlawless() {
        LivingEntity visibleFlawless = BrainUtils.getMemory(this, MemoryModuleType.INTERACTION_TARGET);

        return Optional.ofNullable(visibleFlawless);
    }
}
