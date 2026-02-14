package org.projectflawless.minelittleflawless.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.projectflawless.minelittleflawless.FlawlessAdvancements;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
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
import net.minecraft.tags.ItemTags;
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

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Flawless extends TamableTamersPony implements IForgeShearable {
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
        return MineLittleFlawlessSoundEvents.FLAWLESS_SPEAK.get();
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return MineLittleFlawlessSoundEvents.FLAWLESS_HURT.get();
    }

    @Override
    public SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.FLAWLESS_DEATH.get();
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !(entityType.is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minelittleflawless:sparklemoon_family"))));
    }

    @Override
	public boolean hurt(DamageSource damagesource, float amount) {
        String flawlessClothing = getEntityData().get(Flawless.DATA_CLOTHING);

        if (damagesource.is(DamageTypeTags.IS_FIRE)) {
            if (flawlessClothing.equals(Objects.requireNonNull(MineLittleFlawlessItems.TUXEDO.getId()).toString())) {
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
                    Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ItemTags.create(
                            ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "flawless_clothing")))
                            .getRandomElement(RandomSource.create()).orElseThrow());
            flawlessClothing = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(randomFlawlessClothing.getItem())).toString();
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

        if (itemstack.is(ItemTags.create(ResourceLocation.parse("minelittleflawless:flawless_clothing")))) {
            if (this.getEntityData().get(DATA_CLOTHING).isEmpty()) {
                String flawlessClothing = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(itemstack.getItem())).toString();
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
            retval = itemstack.interactLivingEntity(sourceentity, this, hand);
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
		Flawless retval = MineLittleFlawlessEntities.FLAWLESS.get().create(serverWorld, null, null, ageable.blockPosition(), MobSpawnType.BREEDING, false, false);
        if (retval != null) {
            ForgeEventFactory.onFinalizeSpawn(retval, serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
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

        if (flawlessClothing.equals(Objects.requireNonNull(MineLittleFlawlessItems.PAJAMAS.getId()).toString())) {
            if (source instanceof LivingEntity livingSource)
                livingSource.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 1));
        }
        if (flawlessClothing.equals(Objects.requireNonNull(MineLittleFlawlessItems.FARMER.getId()).toString())) {
            if (source instanceof LivingEntity livingSource)
                livingSource.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
        }
        if (flawlessClothing.equals(Objects.requireNonNull(MineLittleFlawlessItems.SCHOOLGIRL.getId()).toString())) {
            if (source instanceof LivingEntity livingSource)
                livingSource.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1));
        }

        this.playAttackSound();

        return super.doHurtTarget(source);
    }

    @Override
    public List<ItemStack> onSheared(@Nullable Player player, @NotNull ItemStack item, Level level, BlockPos pos, int fortune) {
        level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.HORSE_SADDLE, SoundSource.AMBIENT, 1, 1);
        String flawlessClothing = this.getEntityData().get(DATA_CLOTHING);
        return List.of(new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse(flawlessClothing)))));
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack drop, float offsetY) {
        this.getEntityData().set(DATA_CLOTHING, "");
        this.offClothing(drop);
        return super.spawnAtLocation(drop, offsetY);
    }

    private void playAttackSound() {
        if (this.getEntityData().get(DATA_CLOTHING).equals(MineLittleFlawlessItems.ROCKSTAR.get().toString())) {
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.NOTE_BLOCK_GUITAR.get(), SoundSource.AMBIENT, 5, (float) (Math.random() * 2));
        }
    }

    public void wearClothing(ItemStack itemstack) {
        AttributeModifier modifier;

        if (itemstack.getItem() == MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING.get()) {
            modifier = new AttributeModifier("clothing_power", 5, AttributeModifier.Operation.ADDITION);
            Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_KNOCKBACK)).addPermanentModifier(modifier);
        }
        if (itemstack.getItem() == MineLittleFlawlessItems.SCHOOLGIRL.get()) {
            modifier = new AttributeModifier("clothing_power", 1, AttributeModifier.Operation.ADDITION);
            Objects.requireNonNull(this.getAttribute(Attributes.KNOCKBACK_RESISTANCE)).addPermanentModifier(modifier);
        }
        if (itemstack.getItem() == MineLittleFlawlessItems.ROCKSTAR.get()) {
            modifier = new AttributeModifier("clothing_power", 0.1, AttributeModifier.Operation.ADDITION);
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).addPermanentModifier(modifier);
        }
    }

    private void offClothing(ItemStack itemstack) {
        if (itemstack.getItem() == MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING.get()) {
            Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_KNOCKBACK)).removeModifiers();
        }
        if (itemstack.getItem() == MineLittleFlawlessItems.SCHOOLGIRL.get()) {
            Objects.requireNonNull(this.getAttribute(Attributes.KNOCKBACK_RESISTANCE)).removeModifiers();
        }
        if (itemstack.getItem() == MineLittleFlawlessItems.ROCKSTAR.get()) {
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifiers();
        }
    }

    @SubscribeEvent
    public static void whenPlayerWakesUp(PlayerWakeUpEvent event) {
        Player player = event.getEntity();
        String flawlessClothing;
        {
            final Vec3 _center = new Vec3(player.getX(), player.getY(), player.getZ());
            for (Flawless entityiterator : player.level().getEntitiesOfClass(Flawless.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
                if (entityiterator.isTame() && entityiterator.isOwnedBy(player)) {
                    flawlessClothing = entityiterator.getEntityData().get(DATA_CLOTHING);

                    if (flawlessClothing.equals(MineLittleFlawlessItems.FARMER.get().toString())) {
                        ItemEntity entityToSpawn = new ItemEntity(player.level(), entityiterator.getX(),
                                entityiterator.getY(), entityiterator.getZ(), new ItemStack(
                                        Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ItemTags.create(
                                                ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID,
                                                        "farmer_gifts"))).getRandomElement(RandomSource.create())
                                                .orElseThrow()));
                        entityToSpawn.setPickUpDelay(10);
                        player.level().addFreshEntity(entityToSpawn);
                    }
                }
            }
        }
    }
}