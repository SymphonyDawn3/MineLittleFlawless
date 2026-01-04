package org.projectflawless.minelittleflawless.entity;

import static org.projectflawless.minelittleflawless.init.MinelittleflawlessModEntities.FLAWLESS;

import org.projectflawless.minelittleflawless.init.MinelittleflawlessModItems;
import org.projectflawless.minelittleflawless.procedures.*;
import org.projectflawless.minelittleflawless.init.MinelittleflawlessModEntities;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.common.IShearable;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;

import java.util.List;
import javax.annotation.Nullable;

@EventBusSubscriber
public class FlawlessEntity extends TamableAnimal implements IShearable {
	public static final EntityDataAccessor<String> DATA_flawlessClothing = SynchedEntityData.defineId(FlawlessEntity.class, EntityDataSerializers.STRING);

	public FlawlessEntity(EntityType<FlawlessEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_flawlessClothing, "");
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new BreedGoal(this, 1));
		this.goalSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(3, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Monster.class, false, false));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, (float) 6));
		this.goalSelector.addGoal(7, new FollowOwnerGoal(this, 1, (float) 10, (float) 2));
		this.goalSelector.addGoal(8, new TemptGoal(this, 1, Ingredient.of(Items.SUGAR), false));
		this.goalSelector.addGoal(9, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(11, new FloatGoal(this));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.cat.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.cat.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.cat.death"));
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
        String flawlessClothing = getEntityData().get(FlawlessEntity.DATA_flawlessClothing);

        if (damagesource.is(DamageTypeTags.IS_FIRE)) {
            if (flawlessClothing.equals(MinelittleflawlessModItems.TUXEDO.get().toString())) {
                return false;
            }
        }

		if (damagesource.is(DamageTypes.FALL))
			return false;

		return super.hurtServer(level, damagesource, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, @Nullable SpawnGroupData livingdata) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);

        String flawlessClothing;
        ItemStack randomFlawlessClothing;

        if (Math.random() < 0.5) {
            flawlessClothing = "";
        } else {
            randomFlawlessClothing = new ItemStack(
                    BuiltInRegistries.ITEM.getRandomElementOf(
                            ItemTags.create(
                                    ResourceLocation.parse("minelittleflawless:flawless_clothing")), RandomSource.create())
                            .orElseThrow());
            flawlessClothing = randomFlawlessClothing.getItem().toString();
            this.wearClothing(randomFlawlessClothing);
        }

        this.getEntityData().set(DATA_flawlessClothing, flawlessClothing);

		return retval;
	}

	@Override
	public void addAdditionalSaveData(ValueOutput valueOutput) {
		super.addAdditionalSaveData(valueOutput);
		valueOutput.putString("DataflawlessClothing", this.entityData.get(DATA_flawlessClothing));
	}

	@Override
	public void readAdditionalSaveData(ValueInput valueInput) {
		super.readAdditionalSaveData(valueInput);
		this.entityData.set(DATA_flawlessClothing, valueInput.getStringOr("DataflawlessClothing", ""));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.PASS;

        if (this.isFood(itemstack) || itemstack.is(ItemTags.create(ResourceLocation.parse("minelittleflawless:flawless_food")))) {
            if (this.isTame() && this.isOwnedBy(sourceentity)) {
                if (this.getHealth() < this.getMaxHealth()) {
                    FoodProperties foodproperties = itemstack.get(DataComponents.FOOD);
                    float nutrition = foodproperties != null ? (float) foodproperties.nutrition() * 10 : 1;
                    this.heal(nutrition);
                    this.usePlayerItem(sourceentity, hand, itemstack);
                    retval = InteractionResult.SUCCESS;
                }
            }
            else if (this.isFood(itemstack)) {
                this.usePlayerItem(sourceentity, hand, itemstack);
                if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceentity)) {
                    this.tame(sourceentity);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6);
                }
                this.setPersistenceRequired();
                retval = InteractionResult.SUCCESS;
            }
        } else if (itemstack.is(ItemTags.create(ResourceLocation.parse("minelittleflawless:flawless_clothing")))) {
            if (this.getEntityData().get(DATA_flawlessClothing).isEmpty()) {
                String flawlessClothing = itemstack.getItem().toString();
                this.level().playSound(null, this.blockPosition(), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.horse.saddle")), SoundSource.AMBIENT, 1, 1);

                this.wearClothing(itemstack);
                this.usePlayerItem(sourceentity, hand, itemstack);
                this.getEntityData().set(DATA_flawlessClothing, flawlessClothing);

                if (this.isTame()) {
                    FashionableFlawlessConditionProcedure.execute(sourceentity);
                    FlawlessFanClubConditionProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), sourceentity);
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
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		FlawlessEntity retval = MinelittleflawlessModEntities.FLAWLESS.get().create(serverWorld, EntitySpawnReason.BREEDING);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(Items.SUGAR).test(stack);
	}

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !(this.getType() == entityType);
    }

    @Override
    public List<ItemStack> onSheared(@Nullable Player player, ItemStack item, Level level, BlockPos pos) {
        level.playSound(null, this.blockPosition(), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.saddle.unequip")), SoundSource.AMBIENT, 1, 1);
        String flawlessClothing = this.getEntityData().get(DATA_flawlessClothing);
        return List.of(new ItemStack(BuiltInRegistries.ITEM.getValue(ResourceLocation.parse(flawlessClothing))));
    }

    @Override
    public void spawnShearedDrop(ServerLevel level, BlockPos pos, ItemStack drop) {
        IShearable.super.spawnShearedDrop(level, pos, drop);
        this.getEntityData().set(DATA_flawlessClothing, "");
        this.offClothing(drop);
    }

    private void wearClothing(ItemStack itemstack) {
        AttributeModifier modifier;

        if (itemstack.getItem() == MinelittleflawlessModItems.FLAWLESS_MAGICIAN_CLOTHING.get()) {
            modifier = new AttributeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"), 5, AttributeModifier.Operation.ADD_VALUE);
            this.getAttribute(Attributes.ATTACK_KNOCKBACK).addPermanentModifier(modifier);
        }
        if (itemstack.getItem() == MinelittleflawlessModItems.SCHOOLGIRL.get()) {
            modifier = new AttributeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"), 1, AttributeModifier.Operation.ADD_VALUE);
            this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).addPermanentModifier(modifier);
            this.getAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).addPermanentModifier(modifier);
        }
        if (itemstack.getItem() == MinelittleflawlessModItems.ROCKSTAR.get()) {
            modifier = new AttributeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"), 0.1, AttributeModifier.Operation.ADD_VALUE);
            this.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
        }
    }

    private void offClothing(ItemStack itemstack) {
        if (itemstack.getItem() == MinelittleflawlessModItems.FLAWLESS_MAGICIAN_CLOTHING.get()) {
            this.getAttribute(Attributes.ATTACK_KNOCKBACK).removeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"));
        }
        if (itemstack.getItem() == MinelittleflawlessModItems.SCHOOLGIRL.get()) {
            this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"));
            this.getAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).removeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"));
        }
        if (itemstack.getItem() == MinelittleflawlessModItems.ROCKSTAR.get()) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("minelittleflawless:clothing_power"));
        }
    }

    @SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(MinelittleflawlessModEntities.FLAWLESS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8), RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 200);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 15);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.TEMPT_RANGE, 10);
		return builder;
	}

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(FLAWLESS.get(), createAttributes().build());
    }
}