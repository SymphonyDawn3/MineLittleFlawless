package org.projectflawless.minelittleflawless.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.Clothing;
import org.projectflawless.minelittleflawless.FlawlessAdvancements;
import org.projectflawless.minelittleflawless.Utils;
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
import org.projectflawless.minelittleflawless.item.FlawlessClothingItem;

import java.util.Comparator;
import java.util.Objects;

public class Flawless extends TamableTamersPony implements Shearable {
	public static final EntityDataAccessor<String> DATA_CLOTHING = SynchedEntityData.defineId(Flawless.class, EntityDataSerializers.STRING);

    public Flawless(EntityType<Flawless> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
        this.setGuaranteedDrop(EquipmentSlot.CHEST);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_CLOTHING, Clothing.NONE.toString());
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
        ResourceLocation flawlessClothing = this.getClothing();

        if (damagesource.is(DamageTypeTags.IS_FIRE)) {
            if (flawlessClothing.equals(Clothing.TUXEDO)) {
                return false;
            }
        }

		if (damagesource.is(DamageTypes.FALL))
			return false;

		return super.hurt(damagesource, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag dataTag) {
        this.setUnicorn(true);

		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, spawnType, livingdata, dataTag);

        ResourceLocation flawlessClothing;
        FlawlessClothingItem randomFlawlessClothing;

        if (Math.random() < 0.5) {
            flawlessClothing = Clothing.NONE;
        } else {
            randomFlawlessClothing = (FlawlessClothingItem) Utils.getRandomItemFromTags(MineLittleFlawlessTags.FLAWLESS_CLOTHING);
            flawlessClothing = randomFlawlessClothing.getClothing();

            this.wearClothing(randomFlawlessClothing);
        }

        this.setClothing(flawlessClothing);

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

        if (compound.contains("clothing")) {
            this.entityData.set(DATA_CLOTHING, compound.getString("clothing"));
        }
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.PASS;

        if (itemstack.is(MineLittleFlawlessTags.FLAWLESS_CLOTHING)) {
            if (this.getClothing().equals(Clothing.NONE)) {
                ResourceLocation flawlessClothing = ((FlawlessClothingItem) itemstack.getItem()).getClothing();
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.HORSE_SADDLE, SoundSource.AMBIENT, 1, 1);

                this.wearClothing((FlawlessClothingItem) itemstack.getItem());
                this.usePlayerItem(sourceentity, hand, itemstack);
                this.setClothing(flawlessClothing);

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
            if (!this.getClothing().equals(Clothing.NONE)) {
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
        ResourceLocation flawlessClothing = this.getClothing();

        if (flawlessClothing.equals(Clothing.PAJAMAS)) {
            if (source instanceof LivingEntity livingSource)
                livingSource.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 1));
        }
        if (flawlessClothing.equals(Clothing.FARMER)) {
            if (source instanceof LivingEntity livingSource)
                livingSource.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
        }
        if (flawlessClothing.equals(Clothing.SCHOOLGIRL)) {
            if (source instanceof LivingEntity livingSource)
                livingSource.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1));
        }

        this.playAttackSound();

        return super.doHurtTarget(source);
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack drop, float offsetY) {
        if (drop.getItem() instanceof FlawlessClothingItem flawlessClothingItem) {
            this.setClothing(Clothing.NONE);
            this.offClothing(flawlessClothingItem);
        }
        return super.spawnAtLocation(drop, offsetY);
    }

    private void dropClothing() {
        ResourceLocation flawlessClothing = this.getClothing();
        this.spawnAtLocation(BuiltInRegistries.ITEM.get(flawlessClothing));
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource damageSource, int looting, boolean hitByPlayer) {
        this.dropClothing();
    }

    private void playAttackSound() {
        if (this.getClothing().equals(Clothing.ROCKSTAR)) {
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.NOTE_BLOCK_GUITAR.value(), SoundSource.AMBIENT, 5, (float) (Math.random() * 2));
        }
    }

    public void wearClothing(FlawlessClothingItem clothingItem) {
        AttributeModifier modifier;

        if (clothingItem == MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING) {
            modifier = new AttributeModifier("clothing_power", 5, AttributeModifier.Operation.ADDITION);
            Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_KNOCKBACK)).addPermanentModifier(modifier);
        }
        if (clothingItem == MineLittleFlawlessItems.SCHOOLGIRL) {
            modifier = new AttributeModifier("clothing_power", 1, AttributeModifier.Operation.ADDITION);
            Objects.requireNonNull(this.getAttribute(Attributes.KNOCKBACK_RESISTANCE)).addPermanentModifier(modifier);
        }
        if (clothingItem == MineLittleFlawlessItems.ROCKSTAR) {
            modifier = new AttributeModifier("clothing_power", 0.1, AttributeModifier.Operation.ADDITION);
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).addPermanentModifier(modifier);
        }
    }

    private void offClothing(FlawlessClothingItem clothingItem) {
        if (clothingItem == MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING) {
            Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_KNOCKBACK)).removeModifiers();
        }
        if (clothingItem == MineLittleFlawlessItems.SCHOOLGIRL) {
            Objects.requireNonNull(this.getAttribute(Attributes.KNOCKBACK_RESISTANCE)).removeModifiers();
        }
        if (clothingItem == MineLittleFlawlessItems.ROCKSTAR) {
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifiers();
        }
    }

    public static Player.BedSleepingProblem whenPlayerWakesUp(Player player, BlockPos sleepingPos) {
        ResourceLocation flawlessClothing;
        {
            final Vec3 _center = new Vec3(player.getX(), player.getY(), player.getZ());
            for (Flawless entityiterator : player.level().getEntitiesOfClass(Flawless.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
                if (entityiterator.isTame() && entityiterator.isOwnedBy(player)) {
                    flawlessClothing = entityiterator.getClothing();

                    if (flawlessClothing.equals(Clothing.FARMER)) {
                        ItemEntity entityToSpawn = new ItemEntity(player.level(), entityiterator.getX(),
                                entityiterator.getY(), entityiterator.getZ(), new ItemStack(
                                        Utils.getRandomItemFromTags(MineLittleFlawlessTags.FARMER_GIFTS)));
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
        this.dropClothing();
    }

    @Override
    public boolean readyForShearing() {
        return !this.getClothing().equals(Clothing.NONE);
    }

    public ResourceLocation getClothing() {
        return new ResourceLocation(this.getEntityData().get(DATA_CLOTHING));
    }

    public void setClothing(ResourceLocation clothing) {
        this.getEntityData().set(DATA_CLOTHING, clothing.toString());
    }
}