package org.projectflawless.minelittleflawless;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class MineLittleFlawlessDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // Generate recipes
        pack.addProvider(RecipeGenerator::new);

        // Generate advancements
        pack.addProvider(AdvancementGenerator::new);

        // Generate tags
        pack.addProvider(BiomeTagGenerator::new);
        pack.addProvider(EntityTypeTagGenerator::new);
        pack.addProvider(ItemTagGenerator::new);
    }

    private static class RecipeGenerator extends FabricRecipeProvider {
        public RecipeGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void buildRecipes(Consumer<FinishedRecipe> exporter) {
            // Farmer Flawless recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.FARMER)
                    .define('a', Items.WHEAT)
                    .define('b', Items.STRING)
                    .pattern("aaa")
                    .pattern("b b")
                    .pattern(" b ")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STRING))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "farmer"));

            // Magician Flawless recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING)
                    .define('a', Items.BLACK_CARPET)
                    .define('b', Items.PURPLE_CARPET)
                    .define('c', Items.BLACK_WOOL)
                    .pattern("aaa")
                    .pattern("bbb")
                    .pattern("ccc")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLACK_CARPET))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PURPLE_CARPET))
                    .unlockedBy("has_ingredient_2", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLACK_WOOL))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "flawless_magician_clothing"));

            // Pajamas Flawless recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.PAJAMAS)
                    .define('a', Items.WHITE_CARPET)
                    .define('b', ItemTags.CANDLES)
                    .pattern("aaa")
                    .pattern("aba")
                    .pattern("aaa")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_CARPET))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTags.CANDLES).build()))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "pajamas"));

            // Rockstar Flawless recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.ROCKSTAR)
                    .define('a', Items.STRING)
                    .define('b', ItemTags.PLANKS)
                    .define('c', Items.IRON_INGOT)
                    .pattern(" a ")
                    .pattern(" b ")
                    .pattern("c c")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTags.PLANKS).build()))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                    .unlockedBy("has_ingredient_2", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STRING))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "rockstar"));

            // Schoolgirl Flawless recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.SCHOOLGIRL)
                    .define('a', Items.PINK_CARPET)
                    .pattern("aaa")
                    .pattern("a a")
                    .pattern("aaa")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PINK_CARPET))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "schoolgirl"));

            // Tuxedo Flawless recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.TUXEDO)
                    .define('a', Items.GRAY_CARPET)
                    .pattern("a a")
                    .pattern("aaa")
                    .pattern("a a")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GRAY_CARPET))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "tuxedo"));
        }
    }

    private static class AdvancementGenerator extends FabricAdvancementProvider {
        protected AdvancementGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateAdvancement(Consumer<Advancement> consumer) {
            // Flawless Friendship advancement
            Advancement flawlessFriendship = Advancement.Builder
                    .advancement()
                    .display(
                            MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING,
                            Component.translatable("advancements.flawless_friendship.title"),
                            Component.translatable("advancements.flawless_friendship.descr"),
                            new ResourceLocation("block/stone"),
                            FrameType.TASK, true, true, false)
                    .addCriterion("flawless_friendship_0", new ImpossibleTrigger.TriggerInstance())
                    .save(consumer, MineLittleFlawless.MOD_ID + ":flawless_friendship");

            // Fashionable Flawless advancement
            Advancement.Builder
                    .advancement()
                    .parent(flawlessFriendship)
                    .display(
                            MineLittleFlawlessItems.TUXEDO,
                            Component.translatable("advancements.fashionable_flawless.title"),
                            Component.translatable("advancements.fashionable_flawless.descr"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("fashionable_flawless_0", new ImpossibleTrigger.TriggerInstance())
                    .save(consumer, MineLittleFlawless.MOD_ID + ":fashionable_flawless");

            // Flawless Buddies advancement
            Advancement flawlessBuddies = Advancement.Builder
                    .advancement()
                    .parent(flawlessFriendship)
                    .display(
                            MineLittleFlawlessItems.FARMER,
                            Component.translatable("advancements.flawless_buddies.title"),
                            Component.translatable("advancements.flawless_buddies.descr"),
                            null,
                            FrameType.TASK, true, true, false)
                    .addCriterion("flawless_buddies_0", new ImpossibleTrigger.TriggerInstance())
                    .save(consumer, MineLittleFlawless.MOD_ID + ":flawless_buddies");

            // Flawless Enchilada advancement
            Advancement flawlessEnchilada = Advancement.Builder
                    .advancement()
                    .parent(flawlessBuddies)
                    .display(
                            MineLittleFlawlessItems.FARMER,
                            Component.translatable("advancements.flawless_enchilada.title"),
                            Component.translatable("advancements.flawless_enchilada.descr"),
                            null,
                            FrameType.GOAL, true, true, false)
                    .addCriterion("flawless_enchilada_0", new ImpossibleTrigger.TriggerInstance())
                    .save(consumer, MineLittleFlawless.MOD_ID + ":flawless_enchilada");

            // Flawless Fan Club advancement
            Advancement.Builder
                    .advancement()
                    .parent(flawlessEnchilada)
                    .display(
                            MineLittleFlawlessItems.ROCKSTAR,
                            Component.translatable("advancements.flawless_fan_club.title"),
                            Component.translatable("advancements.flawless_fan_club.descr"),
                            null,
                            FrameType.CHALLENGE, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(500))
                    .addCriterion("flawless_fan_club", new ImpossibleTrigger.TriggerInstance())
                    .save(consumer, MineLittleFlawless.MOD_ID + ":flawless_fan_club");
        }
    }

    private static class BiomeTagGenerator extends FabricTagProvider<Biome> {
        private static final TagKey<Biome> SPAWNS_MARIONETTE = TagKey.create(Registries.BIOME, new ResourceLocation(MineLittleFlawless.MOD_ID, "spawns_marionette"));
        private static final TagKey<Biome> SPAWNS_WISHCATCHER = TagKey.create(Registries.BIOME, new ResourceLocation(MineLittleFlawless.MOD_ID, "spawns_wishcatcher"));
        private static final TagKey<Biome> SPAWNS_TRIXIEBELLE = TagKey.create(Registries.BIOME, new ResourceLocation(MineLittleFlawless.MOD_ID, "spawns_trixiebelle"));
        private static final TagKey<Biome> SPAWNS_SKYWISHES = TagKey.create(Registries.BIOME, new ResourceLocation(MineLittleFlawless.MOD_ID, "spawns_skywishes"));
        private static final TagKey<Biome> SPAWNS_STAR_CATCHER = TagKey.create(Registries.BIOME, new ResourceLocation(MineLittleFlawless.MOD_ID, "spawns_star_catcher"));
        private static final TagKey<Biome> SPAWNS_JACKIE_SPECTRE = TagKey.create(Registries.BIOME, new ResourceLocation(MineLittleFlawless.MOD_ID, "spawns_jackie_spectre"));

        public BiomeTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output, Registries.BIOME, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            this.getOrCreateTagBuilder(SPAWNS_MARIONETTE)
                    .add(
                            Biomes.CHERRY_GROVE,
                            Biomes.OLD_GROWTH_PINE_TAIGA,
                            Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                            Biomes.TAIGA);

            this.getOrCreateTagBuilder(SPAWNS_WISHCATCHER)
                    .add(
                            Biomes.CHERRY_GROVE,
                            Biomes.FLOWER_FOREST,
                            Biomes.GROVE,
                            Biomes.MEADOW,
                            Biomes.OLD_GROWTH_PINE_TAIGA,
                            Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                            Biomes.SNOWY_PLAINS,
                            Biomes.SNOWY_TAIGA,
                            Biomes.TAIGA);

            this.getOrCreateTagBuilder(SPAWNS_TRIXIEBELLE)
                    .add(
                            Biomes.BADLANDS,
                            Biomes.ERODED_BADLANDS,
                            Biomes.WOODED_BADLANDS,
                            Biomes.BAMBOO_JUNGLE,
                            Biomes.JUNGLE,
                            Biomes.SPARSE_JUNGLE,
                            Biomes.SAVANNA,
                            Biomes.SAVANNA_PLATEAU,
                            Biomes.WINDSWEPT_SAVANNA,
                            Biomes.DESERT,
                            Biomes.STONY_PEAKS);

            this.getOrCreateTagBuilder(SPAWNS_SKYWISHES)
                    .addTag(SPAWNS_WISHCATCHER);

            this.getOrCreateTagBuilder(SPAWNS_STAR_CATCHER)
                    .addTag(SPAWNS_WISHCATCHER);

            this.getOrCreateTagBuilder(SPAWNS_JACKIE_SPECTRE)
                    .forceAddTag(BiomeTags.IS_BEACH)
                    .forceAddTag(BiomeTags.IS_OCEAN)
                    .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
                    .forceAddTag(BiomeTags.IS_RIVER)
                    .add(Biomes.STONY_SHORE);
        }
    }

    private static class EntityTypeTagGenerator extends FabricTagProvider.EntityTypeTagProvider {
        private static final TagKey<EntityType<?>> SPARKLEMOON_FAMILY = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(MineLittleFlawless.MOD_ID, "sparklemoon_family"));

        public EntityTypeTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            this.getOrCreateTagBuilder(SPARKLEMOON_FAMILY)
                    .add(
                            MineLittleFlawlessEntities.TWILIGHT,
                            MineLittleFlawlessEntities.TRIXIE,
                            MineLittleFlawlessEntities.FLAWLESS,
                            MineLittleFlawlessEntities.MARIONETTE);
        }
    }

    private static class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
        private static final TagKey<Item> FARMER_GIFTS = TagKey.create(Registries.ITEM, new ResourceLocation(MineLittleFlawless.MOD_ID, "farmer_gifts"));
        private static final TagKey<Item> FLAWLESS_CLOTHING = TagKey.create(Registries.ITEM, new ResourceLocation(MineLittleFlawless.MOD_ID, "flawless_clothing"));
        private static final TagKey<Item> FLAWLESS_FOOD = TagKey.create(Registries.ITEM, new ResourceLocation(MineLittleFlawless.MOD_ID, "flawless_food"));

        public ItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            this.getOrCreateTagBuilder(FARMER_GIFTS)
                    .add(
                            Items.PUMPKIN_SEEDS,
                            Items.NETHER_WART,
                            Items.BEETROOT_SEEDS,
                            Items.COCOA_BEANS,
                            Items.WHEAT_SEEDS,
                            Items.CARROT,
                            Items.POTATO,
                            Items.MELON_SEEDS);

            this.getOrCreateTagBuilder(FLAWLESS_CLOTHING)
                    .add(
                            MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING,
                            MineLittleFlawlessItems.PAJAMAS,
                            MineLittleFlawlessItems.TUXEDO,
                            MineLittleFlawlessItems.SCHOOLGIRL,
                            MineLittleFlawlessItems.FARMER,
                            MineLittleFlawlessItems.ROCKSTAR);

            this.getOrCreateTagBuilder(FLAWLESS_FOOD)
                    .add(
                            Items.MELON_SLICE,
                            Items.MUSHROOM_STEW,
                            Items.BAKED_POTATO,
                            Items.CARROT,
                            Items.COOKIE,
                            Items.APPLE,
                            Items.CAKE,
                            Items.GLOW_BERRIES,
                            Items.GOLDEN_CARROT,
                            Items.HONEY_BOTTLE,
                            Items.BREAD,
                            Items.POTATO,
                            Items.BEETROOT_SOUP,
                            Items.SWEET_BERRIES,
                            Items.PUMPKIN_PIE,
                            Items.DRIED_KELP,
                            Items.BEETROOT);
        }
    }
}
