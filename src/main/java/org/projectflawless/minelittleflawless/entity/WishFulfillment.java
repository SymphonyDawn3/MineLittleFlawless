package org.projectflawless.minelittleflawless.entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.ServerLevelAccessor;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.entity.ai.behavior.WishWithPlayer;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntSupplier;

public class WishFulfillment extends TamableTamersPony implements Merchant, SmartBrainOwner<WishFulfillment> {
    public final IntSupplier rerollMaxUse = () -> this.getRandom().nextInt(3, 21);
    private MerchantOffers wishingOffers = new MerchantOffers();
    private int wishingLevel = 1;
    private int wishingXp;
    private int nextWishingDay;
    private Player wisher;
    private final Item itemForTrading = Items.EMERALD;
    private final ImmutableList<SimpleWeightedRandomList<MerchantOffer>> predefinedOffers = ImmutableList.of(
            // Level 1
            SimpleWeightedRandomList.<MerchantOffer>builder().add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(1, 6)),
                            new ItemStack(Items.RAW_COPPER), this.rerollMaxUse.getAsInt(), 1, 1.0f), 90).add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(2, 7)),
                            new ItemStack(Items.RAW_IRON), this.rerollMaxUse.getAsInt(), 1, 1.0f), 80).add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(3, 8)),
                            new ItemStack(Items.RAW_GOLD), this.rerollMaxUse.getAsInt(), 1, 1.0f),75).add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(4, 9)),
                            new ItemStack(Items.DIAMOND), this.rerollMaxUse.getAsInt(), 1, 1.0f), 20).add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(5, 10)),
                            new ItemStack(Items.ANCIENT_DEBRIS), this.rerollMaxUse.getAsInt(), 1, 1.0f), 15).build(),
            // Level 2
            SimpleWeightedRandomList.<MerchantOffer>builder().add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(6, 11)),
                            new ItemStack(Items.COPPER_INGOT), this.rerollMaxUse.getAsInt(), 1, 1.0f), 80).add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(7, 12)),
                            new ItemStack(Items.IRON_INGOT), this.rerollMaxUse.getAsInt(), 3, 1.0f), 60).add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(8, 13)),
                            new ItemStack(Items.GOLD_INGOT), this.rerollMaxUse.getAsInt(), 5, 1.0f), 50).add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(9, 14)),
                            new ItemStack(Items.NETHERITE_INGOT), this.rerollMaxUse.getAsInt(), 7, 1.0f), 10).build(),
            // Level 3
            SimpleWeightedRandomList.<MerchantOffer>builder().add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(10, 15)),
                            new ItemStack(Items.COPPER_BLOCK), this.rerollMaxUse.getAsInt(), 3, 1.0f), 70).add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(11, 16)),
                            new ItemStack(Items.IRON_BLOCK), this.rerollMaxUse.getAsInt(), 6, 1.0f), 40).add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(12, 17)),
                            new ItemStack(Items.GOLD_BLOCK), this.rerollMaxUse.getAsInt(), 9, 1.0f), 25).add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(13, 18)),
                            new ItemStack(Items.DIAMOND_BLOCK), this.rerollMaxUse.getAsInt(), 12, 1.0f), 10).add(
                    new MerchantOffer(new ItemStack(this.itemForTrading, this.getRandom().nextInt(14, 19)),
                            new ItemStack(Items.NETHERITE_BLOCK), this.rerollMaxUse.getAsInt(), 15, 1.0f), 5).build()
    );

    public WishFulfillment(EntityType<WishFulfillment> type, Level world) {
        super(type, world);
        this.setUnicorn(true);
        this.setToNextWishingDay();
    }

    @Override
    public List<? extends ExtendedSensor<WishFulfillment>> getSensors() {
        return ImmutableList.of();
    }

    @Override
    public BrainActivityGroup<WishFulfillment> getIdleTasks() {
        return BrainActivityGroup.idleTasks(
                new WishWithPlayer()
        );
    }

    @Override
    protected Brain.Provider<WishFulfillment> brainProvider() {
        return new SmartBrainProvider<>(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(9, new TemptGoal(this, 1, Ingredient.of(Items.CHORUS_FRUIT), false));
    }

    @Override
    protected void customServerAiStep() {
        if (this.isNight() && this.canRestock()) {
            this.restockAll();
            this.setToNextWishingDay();
        }

        this.tickBrain(this);

        super.customServerAiStep();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

        var merchantOffers = this.getOffers();
        if (!merchantOffers.isEmpty()) {
            compound.put("Offers", merchantOffers.createTag());
        }

        compound.putInt("NextWishingDay", this.nextWishingDay);
        compound.putInt("WishingLevel", this.wishingLevel);
        compound.putInt("WishingXP", this.getVillagerXp());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        if (compound.contains("Offers")) {
            this.overrideOffers(new MerchantOffers(compound.getCompound("Offers")));
        }

        if (compound.contains("NextWishingDay")) {
            this.nextWishingDay = compound.getInt("NextWishingDay");
        }

        if (compound.contains("WishingLevel")) {
            this.wishingLevel = compound.getInt("WishingLevel");
        }

        if (compound.contains("WishingXP")) {
            this.overrideXp(compound.getInt("WishingXP"));
        }
    }

    @Override
    public boolean canAttackType(EntityType<?> entityType) {
        return !entityType.equals(MineLittleFlawlessEntities.WISH_FULFILLMENT) || !entityType.equals(MineLittleFlawlessEntities.FLAWLESS);
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return true;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_DEATH;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        WishFulfillment wishFulfillmentBaby = MineLittleFlawlessEntities.WISH_FULFILLMENT.create(level, null, null, otherParent.blockPosition(), MobSpawnType.BREEDING, false, false);

        if (wishFulfillmentBaby != null) {
            wishFulfillmentBaby.finalizeSpawn(level, level.getCurrentDifficultyAt(wishFulfillmentBaby.blockPosition()), MobSpawnType.BREEDING, null, null);
        }

        return wishFulfillmentBaby;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        this.generateFirstWishes();

        return super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
    }

    private void generateFirstWishes() {
        this.generateWishesForLevel(this.wishingLevel);
    }

    private void generateWishesForLevel(int wishingLevel) {
        MerchantOffers selectedOffers = new MerchantOffers();

        while (selectedOffers.size() < 2) {
            MerchantOffer randomOffer = this.predefinedOffers.get(wishingLevel-1).getRandomValue(this.getRandom()).orElseThrow();

            if (selectedOffers.stream().noneMatch(merchantOffer -> merchantOffer.getResult().is(randomOffer.getResult().getItem())))
                selectedOffers.add(randomOffer);
        }

        this.wishingOffers.addAll(selectedOffers);
        this.wishingOffers.sort(Comparator.comparingInt(merchantOffer -> merchantOffer.getBaseCostA().getCount()));
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.CHORUS_FRUIT);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (hand == InteractionHand.MAIN_HAND) {
            ItemStack itemStack = player.getMainHandItem();

            if (itemStack.isEmpty()) {
                if (this.isNight() && this.isFullMoon() && !this.isAllOutOfStock() && !this.isBaby()) {
                    this.setTradingPlayer(player);
                    this.openTradingScreen(player, this.getDisplayName(), this.wishingLevel);
                } else {
                    if (!this.isClientSide()) {
                        this.playWishDenySound();
                        this.ambientSoundTime -= this.getAmbientSoundInterval();
                    }
                }

                return InteractionResult.sidedSuccess(this.level().isClientSide());
            }
        }

        return super.mobInteract(player, hand);
    }

    private void setToNextWishingDay() {
        int next = this.getDay() + 8;
        this.nextWishingDay = next - (next % 8);
    }

    private int getDay() {
        return Mth.floor((float)this.level().dayTime() / 24000L);
    }

    private boolean isFullMoon() {
        return this.level().getMoonPhase() == 0;
    }

    private boolean isNight() {
        return this.level().isNight();
    }

    @Override
    public boolean showProgressBar() {
        return this.wishingLevel < this.maxOfferLevel();
    }

    @Override
    public int getVillagerXp() {
        return this.wishingXp;
    }

    @Override
    public MerchantOffers getOffers() {
        return this.wishingOffers;
    }

    @Override
    public void overrideOffers(MerchantOffers offers) {
        this.wishingOffers = offers;
    }

    @Override
    public void setTradingPlayer(Player tradingPlayer) {
        this.wisher = tradingPlayer;
    }

    @Override
    public void notifyTrade(MerchantOffer offer) {
        offer.increaseUses();

        int nextWishingLevelUpXp = this.nextLevelUpXp(this.wishingLevel);
        if (this.getVillagerXp() >= nextWishingLevelUpXp - 1) {
            this.wishingLevel++;

            if (this.wishingLevel <= this.maxOfferLevel()) {
                this.generateWishesForLevel(this.wishingLevel);
            }
        }
        this.setPersistenceRequired();
    }

    private int nextLevelUpXp(int wishingLevel) {
        return VillagerData.getMaxXpPerLevel(wishingLevel);
    }

    private int maxOfferLevel() {
        return this.predefinedOffers.size();
    }

    @Override
    public void notifyTradeUpdated(ItemStack stack) {
        if (!this.isClientSide() && this.ambientSoundTime > -this.getAmbientSoundInterval() + 20) {
            this.ambientSoundTime = -this.getAmbientSoundInterval();
            this.playSound(stack.isEmpty() ? MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_TRADE_DENY : MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_TRADE_ACCEPT,
                    this.getSoundVolume(), this.getVoicePitch());
        }
    }

    @Override
    public Player getTradingPlayer() {
        return this.wisher;
    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_TRADE_ACCEPT;
    }

    @Override
    public boolean isClientSide() {
        return this.level().isClientSide;
    }

    @Override
    public void overrideXp(int xp) {
        this.wishingXp = xp;
    }

    @Override
    public boolean canRestock() {
        return this.getDay() == this.nextWishingDay;
    }

    private boolean isAllOutOfStock() {
        return this.getOffers().stream().allMatch(MerchantOffer::isOutOfStock);
    }

    private void restockAll() {
        this.getOffers().forEach(MerchantOffer::resetUses);
    }

    private void playWishDenySound() {
        this.playSound(MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_TRADE_DENY, this.getSoundVolume(), this.getVoicePitch());
    }
}
