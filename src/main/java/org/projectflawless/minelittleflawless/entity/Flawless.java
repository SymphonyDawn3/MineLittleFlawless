package org.projectflawless.minelittleflawless.entity;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.FlawlessAdvancements;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.nbt.CompoundTag;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessTags;

import java.util.Comparator;
import java.util.Objects;

public class Flawless extends TamableTamersPony implements Shearable {
	public static final EntityDataAccessor<String> DATA_CLOTHING = SynchedEntityData.defineId(Flawless.class, EntityDataSerializers.STRING);

    public Flawless(EntityType<Flawless> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_CLOTHING, "");
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.SUGAR), false));
	}

    @Override
    public SoundEvent getAmbientSound() {
        return MineLittleFlawlessSoundEvents.FLAWLESS_AMBIENT;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return MineLittleFlawlessSoundEvents.FLAWLESS_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.FLAWLESS_DEATH;
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !(entityType.is(MineLittleFlawlessTags.SPARKLEMOON_FAMILY));
    }

    @Override
	public boolean hurt(DamageSource damagesource, float amount) {
        String flawlessClothing = getEntityData().get(Flawless.DATA_CLOTHING);

        if (damagesource.is(DamageTypeTags.IS_FIRE)) {
            if (flawlessClothing.equals(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(MineLittleFlawlessItems.TUXEDO)).toString())) {
                return false;
            }
        }

		if (damagesource.is(DamageTypes.FALL))
			return false;

		return super.hurt(damagesource, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag dataTag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, spawnType, livingdata, dataTag);

        String flawlessClothing;
        ItemStack randomFlawlessClothing;

        if (Math.random() < 0.5) {
            flawlessClothing = "";
        } else {
            randomFlawlessClothing = new ItemStack(
                    getRandomItemFromTags(MineLittleFlawlessTags.FLAWLESS_CLOTHING));
            flawlessClothing = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(randomFlawlessClothing.getItem())).toString();
            this.wearClothing(randomFlawlessClothing);
        }

        this.getEntityData().set(DATA_CLOTHING, flawlessClothing);

		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("clothing", this.entityData.get(DATA_CLOTHING));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.entityData.set(DATA_CLOTHING, compound.getString("clothing"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.PASS;

        if (itemstack.is(MineLittleFlawlessTags.FLAWLESS_CLOTHING)) {
            if (this.getEntityData().get(DATA_CLOTHING).isEmpty()) {
                String flawlessClothing = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(itemstack.getItem())).toString();
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.HORSE_SADDLE, SoundSource.AMBIENT, 1, 1);

                this.wearClothing(itemstack);
                this.usePlayerItem(sourceentity, hand, itemstack);
                this.getEntityData().set(DATA_CLOTHING, flawlessClothing);

                if (this.isTame()) {
                    if (sourceentity instanceof ServerPlayer serverPlayer) {
                        FlawlessAdvancements.fashionableFlawless(serverPlayer);
                        FlawlessAdvancements.flawlessFanClub(serverPlayer);
                    }
                }

                retval = InteractionResult.SUCCESS;
            }
        } else if (itemstack.getItem() == Items.SHEARS) {
            if (!this.level().isClientSide) {
                this.shear(SoundSource.PLAYERS);
                this.gameEvent(GameEvent.SHEAR, sourceentity);
                itemstack.hurtAndBreak(1, sourceentity, player -> player.broadcastBreakEvent(hand));
                retval = InteractionResult.SUCCESS;
            } else {
                retval = InteractionResult.CONSUME;
            }
        } else {
            retval = super.mobInteract(sourceentity, hand);
            if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
                this.setPersistenceRequired();
        }

		return retval;
	}

    @Override
    protected void onTameSuccess(Player player, InteractionHand hand) {
        if (player instanceof ServerPlayer serverPlayer) {
            if (!this.getEntityData().get(Flawless.DATA_CLOTHING).isEmpty()) {
                FlawlessAdvancements.fashionableFlawless(serverPlayer);
                FlawlessAdvancements.flawlessFanClub(serverPlayer);
            }
            FlawlessAdvancements.flawlessFriendship(serverPlayer);
            FlawlessAdvancements.flawlessBuddles(serverPlayer);
            FlawlessAdvancements.flawlessEnchilada(serverPlayer);
        }
    }

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		Flawless retval = MineLittleFlawlessEntities.FLAWLESS.create(serverWorld, null, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);
        if (retval != null) {
            retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        }
        return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(Items.SUGAR).test(stack);
	}

    @Override
    public boolean doHurtTarget(Entity source) {
        String flawlessClothing = this.getEntityData().get(Flawless.DATA_CLOTHING);

        if (flawlessClothing.equals(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(MineLittleFlawlessItems.PAJAMAS)).toString())) {
            if (source instanceof LivingEntity livingSource)
                livingSource.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 1));
        }
        if (flawlessClothing.equals(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(MineLittleFlawlessItems.FARMER)).toString())) {
            if (source instanceof LivingEntity livingSource)
                livingSource.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
        }
        if (flawlessClothing.equals(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(MineLittleFlawlessItems.SCHOOLGIRL)).toString())) {
            if (source instanceof LivingEntity livingSource)
                livingSource.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1));
        }

        this.playAttackSound();

        return super.doHurtTarget(source);
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack drop, float offsetY) {
        this.getEntityData().set(DATA_CLOTHING, "");
        this.offClothing(drop);
        return super.spawnAtLocation(drop, offsetY);
    }

    private void playAttackSound() {
        if (this.getEntityData().get(DATA_CLOTHING).equals(MineLittleFlawlessItems.ROCKSTAR.toString())) {
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.NOTE_BLOCK_GUITAR.value(), SoundSource.AMBIENT, 5, (float) (Math.random() * 2));
        }
    }

    public void wearClothing(ItemStack itemstack) {
        AttributeModifier modifier;

        if (itemstack.getItem() == MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING) {
            modifier = new AttributeModifier("clothing_power", 5, AttributeModifier.Operation.ADDITION);
            Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_KNOCKBACK)).addPermanentModifier(modifier);
        }
        if (itemstack.getItem() == MineLittleFlawlessItems.SCHOOLGIRL) {
            modifier = new AttributeModifier("clothing_power", 1, AttributeModifier.Operation.ADDITION);
            Objects.requireNonNull(this.getAttribute(Attributes.KNOCKBACK_RESISTANCE)).addPermanentModifier(modifier);
        }
        if (itemstack.getItem() == MineLittleFlawlessItems.ROCKSTAR) {
            modifier = new AttributeModifier("clothing_power", 0.1, AttributeModifier.Operation.ADDITION);
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).addPermanentModifier(modifier);
        }
    }

    private void offClothing(ItemStack itemstack) {
        if (itemstack.getItem() == MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING) {
            Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_KNOCKBACK)).removeModifiers();
        }
        if (itemstack.getItem() == MineLittleFlawlessItems.SCHOOLGIRL) {
            Objects.requireNonNull(this.getAttribute(Attributes.KNOCKBACK_RESISTANCE)).removeModifiers();
        }
        if (itemstack.getItem() == MineLittleFlawlessItems.ROCKSTAR) {
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifiers();
        }
    }

    public static Player.BedSleepingProblem whenPlayerWakesUp(Player player, BlockPos sleepingPos) {
        String flawlessClothing;
        {
            final Vec3 _center = new Vec3(player.getX(), player.getY(), player.getZ());
            for (Flawless entityiterator : player.level().getEntitiesOfClass(Flawless.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
                if (entityiterator.isTame() && entityiterator.isOwnedBy(player)) {
                    flawlessClothing = entityiterator.getEntityData().get(DATA_CLOTHING);

                    if (flawlessClothing.equals(BuiltInRegistries.ITEM.getKey(MineLittleFlawlessItems.FARMER).toString())) {
                        ItemEntity entityToSpawn = new ItemEntity(player.level(), entityiterator.getX(),
                                entityiterator.getY(), entityiterator.getZ(), new ItemStack(
                                        getRandomItemFromTags(MineLittleFlawlessTags.FARMER_GIFTS)));
                        entityToSpawn.setPickUpDelay(10);
                        player.level().addFreshEntity(entityToSpawn);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void shear(SoundSource source) {
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.HORSE_SADDLE, source, 1, 1);
        String flawlessClothing = this.getEntityData().get(DATA_CLOTHING);

        int i = 1 + this.random.nextInt(3);

        for (int j = 0; j < i; j++) {
            ItemEntity itemEntity = this.spawnAtLocation(BuiltInRegistries.ITEM.get(
                    new ResourceLocation(flawlessClothing)), 1);

            if (itemEntity != null) {
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement()
                        .add(
                                (this.random.nextFloat() - this.random.nextFloat()) * 0.1F,
                                this.random.nextFloat() * 0.05F,
                                (this.random.nextFloat() - this.random.nextFloat()) * 0.1F)
                );
            }
        }
    }

    @Override
    public boolean readyForShearing() {
        return !this.getEntityData().get(DATA_CLOTHING).isEmpty();
    }

    public static Item getRandomItemFromTags(TagKey<Item> tagItem) {
        return Util.getRandomSafe(
                BuiltInRegistries.ITEM.getOrCreateTag(tagItem)
                        .stream()
                        .map(Holder::value)
                        .toList(), RandomSource.create()).orElseThrow();
    }
}