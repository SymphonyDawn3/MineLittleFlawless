package org.projectflawless.minelittleflawless.fabric;

import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.*;
import net.minecraft.Util;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.MineLittleFlawlessTags;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessSoundEvents;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class MineLittleFlawlessDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        // Generate item models
        pack.addProvider(BlockAndModelGenerator::new);

        // Generate en_us.json language file
        pack.addProvider(LanguageGenerator::new);

        // Generate recipes
        pack.addProvider(RecipeGenerator::new);

        // Generate advancements
        pack.addProvider(AdvancementGenerator::new);

        // Generate tags
        pack.addProvider(BiomeTagGenerator::new);
        pack.addProvider(EntityTypeTagGenerator::new);
        pack.addProvider(ItemTagGenerator::new);
    }

    private static class BlockAndModelGenerator extends FabricModelProvider {
        private BlockModelGenerators blockStateModelGenerator;

        public BlockAndModelGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
            this.blockStateModelGenerator = blockStateModelGenerator;
            this.generateSpawnEggItemModels();
        }

        @Override
        public void generateItemModels(ItemModelGenerators itemModelGenerator) {
            // Materials
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.ROTTEN_SUGAR.get(), ModelTemplates.FLAT_ITEM);

            // Music Discs
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.MUSIC_DISC_WISHLESS_RESONANCE.get(), ModelTemplates.FLAT_ITEM);

            // Flawless clothing
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING.get(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.TUXEDO.get(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.FARMER.get(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.PAJAMAS.get(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.SCHOOLGIRL.get(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.ROCKSTAR.get(), ModelTemplates.FLAT_ITEM);

            // Trixie clothing
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.TRIXIE_MAGICIAN.get(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.TRIXIE_BLACK_MAGICIAN.get(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.TRIXIE_SCHOOLGIRL.get(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.TRIXIE_GIR.get(), ModelTemplates.FLAT_ITEM);

            // Trixiebelle clothing
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.TRIXIEBELLE_JESTER.get(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.TRIXIEBELLE_MEXICAN.get(), ModelTemplates.FLAT_ITEM);

            // Skywishes clothing
            itemModelGenerator.generateFlatItem(MineLittleFlawlessItems.SKYWISHES_DRACULA.get(), ModelTemplates.FLAT_ITEM);
        }

        private void generateSpawnEggItemModel(RegistrySupplier<SpawnEggItem> spawnEgg) {
            this.blockStateModelGenerator.delegateItemModel(spawnEgg.get(), ModelLocationUtils.decorateItemModelLocation("template_spawn_egg"));
        }

        private void generateSpawnEggItemModels() {
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.FLAWLESS_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.FRACTURED_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.TWILIGHT_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.TRIXIE_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.ARINOS_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.LAST_LAUGH_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.CHERRY_CHUCKLES_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.BIBBLEBOP_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.TRICOLOR_JUBILEE_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.TRIXIEBELLE_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.SKYWISHES_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.STAR_CATCHER_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.MARIONETTE_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.JACKIE_SPECTRE_SPAWN_EGG);
            this.generateSpawnEggItemModel(MineLittleFlawlessItems.WISH_FULFILLMENT_SPAWN_EGG);
        }
    }

    private static class LanguageGenerator extends FabricLanguageProvider {

        public LanguageGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            this.generateEntityTranslations(translationBuilder);
            this.generateMaterialTranslations(translationBuilder);
            this.generateMusicDiscTranslations(translationBuilder);
            this.generateSpawnEggTranslations(translationBuilder);
            this.generateFlawlessClothingTranslations(translationBuilder);
            this.generateTrixieClothingTranslations(translationBuilder);
            this.generateTrixiebelleClothingTranslations(translationBuilder);
            this.generateSkywishesClothingTranslations(translationBuilder);
            this.generateSoundEventTranslations(translationBuilder);
            this.generateAdvancementTranslations(translationBuilder);
        }

        private void generateEntityTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(MineLittleFlawlessEntities.BARTLEBY.get(), "Bartleby");
            translationBuilder.add(MineLittleFlawlessEntities.FLAWLESS.get(), "Flawless");
            translationBuilder.add(MineLittleFlawlessEntities.FRACTURED.get(), "Fractured");
            translationBuilder.add(MineLittleFlawlessEntities.TWILIGHT.get(), "Twilight");
            translationBuilder.add(MineLittleFlawlessEntities.TRIXIE.get(), "Trixie");
            translationBuilder.add(MineLittleFlawlessEntities.ARINOS.get(), "Arinos");
            translationBuilder.add(MineLittleFlawlessEntities.LAST_LAUGH.get(), "Last Laugh");
            translationBuilder.add(MineLittleFlawlessEntities.CHERRY_CHUCKLES.get(), "Cherry Chuckles");
            translationBuilder.add(MineLittleFlawlessEntities.BIBBLEBOP.get(), "Bibblebop");
            translationBuilder.add(MineLittleFlawlessEntities.TRICOLOR_JUBILEE.get(), "Tricolor Jubilee");
            translationBuilder.add(MineLittleFlawlessEntities.TRIXIEBELLE.get(), "Trixiebelle");
            translationBuilder.add(MineLittleFlawlessEntities.SKYWISHES.get(), "Skywishes");
            translationBuilder.add(MineLittleFlawlessEntities.STAR_CATCHER.get(), "Star Catcher");
            translationBuilder.add(MineLittleFlawlessEntities.MARIONETTE.get(), "Marionette");
            translationBuilder.add(MineLittleFlawlessEntities.JACKIE_SPECTRE.get(), "Jackie Spectre");
            translationBuilder.add(MineLittleFlawlessEntities.WISH_FULFILLMENT.get(), "Wish Fulfillment");
        }

        private void generateMaterialTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(MineLittleFlawlessItems.ROTTEN_SUGAR.get(), "Rotten Sugar");
        }

        private void generateMusicDiscTranslations(TranslationBuilder translationBuilder) {
            this.generateMusicDiscTranslation(translationBuilder, MineLittleFlawlessItems.MUSIC_DISC_WISHLESS_RESONANCE, "bonzi - Wishless Resonance");
        }

        private void generateMusicDiscTranslation(TranslationBuilder translationBuilder, RegistrySupplier<RecordItem> musicDisc, String title) {
            translationBuilder.add(musicDisc.get(), "Music Disc");
            translationBuilder.add(musicDisc.getId().toLanguageKey("item", "desc"), title);
        }

        private void generateSpawnEggTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(MineLittleFlawlessItems.FLAWLESS_SPAWN_EGG.get(), "Flawless Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.FRACTURED_SPAWN_EGG.get(), "Fractured Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.TWILIGHT_SPAWN_EGG.get(), "Twilight Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.TRIXIE_SPAWN_EGG.get(), "Trixie Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.ARINOS_SPAWN_EGG.get(), "Arinos Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.LAST_LAUGH_SPAWN_EGG.get(), "Last Laugh Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.CHERRY_CHUCKLES_SPAWN_EGG.get(), "Cherry Chuckles Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.BIBBLEBOP_SPAWN_EGG.get(), "Bibblebop Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.TRICOLOR_JUBILEE_SPAWN_EGG.get(), "Tricolor Jubilee Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.TRIXIEBELLE_SPAWN_EGG.get(), "Trixiebelle Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.SKYWISHES_SPAWN_EGG.get(), "Skywishes Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.STAR_CATCHER_SPAWN_EGG.get(), "Star Catcher Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.MARIONETTE_SPAWN_EGG.get(), "Marionette Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.JACKIE_SPECTRE_SPAWN_EGG.get(), "Jackie Spectre Spawn Egg");
            translationBuilder.add(MineLittleFlawlessItems.WISH_FULFILLMENT_SPAWN_EGG.get(), "Wish Fulfillment Spawn Egg");
        }

        private void generateFlawlessClothingTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING.get(), "Flawless Magician Clothing");
            translationBuilder.add(MineLittleFlawlessItems.TUXEDO.get(), "Tuxedo");
            translationBuilder.add(MineLittleFlawlessItems.FARMER.get(), "Farmer");
            translationBuilder.add(MineLittleFlawlessItems.PAJAMAS.get(), "Pajamas");
            translationBuilder.add(MineLittleFlawlessItems.SCHOOLGIRL.get(), "Schoolgirl");
            translationBuilder.add(MineLittleFlawlessItems.ROCKSTAR.get(), "Rockstar");
        }

        private void generateTrixieClothingTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(MineLittleFlawlessItems.TRIXIE_MAGICIAN.get(), "Trixie Magician");
            translationBuilder.add(MineLittleFlawlessItems.TRIXIE_BLACK_MAGICIAN.get(), "Trixie Black Magician");
            translationBuilder.add(MineLittleFlawlessItems.TRIXIE_SCHOOLGIRL.get(), "Trixie Schoolgirl");
            translationBuilder.add(MineLittleFlawlessItems.TRIXIE_GIR.get(), "Trixie Gir");
        }

        private void generateTrixiebelleClothingTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(MineLittleFlawlessItems.TRIXIEBELLE_JESTER.get(), "Trixiebelle Jester");
            translationBuilder.add(MineLittleFlawlessItems.TRIXIEBELLE_MEXICAN.get(), "Trixiebelle Mexican");
        }

        private void generateSkywishesClothingTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add(MineLittleFlawlessItems.SKYWISHES_DRACULA.get(), "Skywishes Dracula");
        }

        private void generateSoundEventTranslations(TranslationBuilder translationBuilder) {
            // Flawless
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.FLAWLESS_AMBIENT, "Flawless speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.FLAWLESS_HURT, "Flawless hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.FLAWLESS_DEATH, "Flawless dies");

            // Fractured
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.FRACTURED_AMBIENT, "Fractured speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.FRACTURED_HURT, "Fractured hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.FRACTURED_DEATH, "Fractured dies");

            // Twilight
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TWILIGHT_AMBIENT, "Twilight speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TWILIGHT_HURT, "Twilight hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TWILIGHT_DEATH, "Twilight dies");

            // Trixie
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRIXIE_AMBIENT, "Trixie speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRIXIE_HURT, "Trixie hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRIXIE_DEATH, "Trixie dies");

            // Generic clown pony jingle
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.CLOWN_PONY_JINGLE, "Clown pony jingles");

            // Arinos
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.ARINOS_AMBIENT, "Arinos speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.ARINOS_HURT, "Arinos hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.ARINOS_DEATH, "Arinos dies");

            // Last Laugh
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.LAST_LAUGH_AMBIENT, "Last Laugh speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.LAST_LAUGH_HURT, "Last Laugh hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.LAST_LAUGH_DEATH, "Last Laugh dies");

            // Cherry Chuckles
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.CHERRY_CHUCKLES_AMBIENT, "Cherry Chuckles speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.CHERRY_CHUCKLES_HURT, "Cherry Chuckles hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.CHERRY_CHUCKLES_DEATH, "Cherry Chuckles dies");

            // Bibblebop
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.BIBBLEBOP_AMBIENT, "Bibblebop speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.BIBBLEBOP_HURT, "Bibblebop hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.BIBBLEBOP_DEATH, "Bibblebop dies");

            // Tricolor Jubilee
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRICOLOR_JUBILEE_AMBIENT, "Tricolor Jubilee speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRICOLOR_JUBILEE_HURT, "Tricolor Jubilee hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRICOLOR_JUBILEE_DEATH, "Tricolor Jubilee dies");

            // Marionette
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.MARIONETTE_AMBIENT, "Marionette speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.MARIONETTE_HURT, "Marionette hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.MARIONETTE_DEATH, "Marionette dies");

            // Trixiebelle, English variant
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRIXIEBELLE_AMBIENT, "Trixiebelle speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRIXIEBELLE_HURT, "Trixiebelle hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRIXIEBELLE_DEATH, "Trixiebelle dies");

            // Trixiebelle, Spanish variant
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRIXIEBELLE_AMBIENT_ES, "Trixiebelle speaks in Spanish");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRIXIEBELLE_HURT_ES, "Trixiebelle hurts in Spanish");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.TRIXIEBELLE_DEATH_ES, "Trixiebelle dies in Spanish");

            // Skywishes
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.SKYWISHES_AMBIENT, "Skywishes speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.SKYWISHES_HURT, "Skywishes hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.SKYWISHES_DEATH, "Skywishes dies");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.SKYWISHES_CLANK, "Skywishes clanks");

            // Star Catcher
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.STAR_CATCHER_AMBIENT, "Star Catcher speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.STAR_CATCHER_HURT, "Star Catcher hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.STAR_CATCHER_DEATH, "Star Catcher dies");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.STAR_CATCHER_CLEAN_ON, "Star Catcher starts cleaning");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.STAR_CATCHER_CLEAN_OFF, "Star Catcher stops cleaning");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.STAR_CATCHER_CLEAN_AROUND, "Star Catcher cleans around");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.STAR_CATCHER_DENY_CLEAN, "Star Catcher denies cleaning");

            // Jackie Spectre
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.JACKIE_SPECTRE_AMBIENT, "Jackie Spectre speaks");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.JACKIE_SPECTRE_HURT, "Jackie Spectre hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.JACKIE_SPECTRE_DEATH, "Jackie Spectre dies");

            // Wish Fulfillment
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_AMBIENT, "Wish Fulfillment blerps");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_HURT, "Wish Fulfillment hurts");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_DEATH, "Wish Fulfillment dies");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_TRADE_ACCEPT, "Wish Fulfillment accepts offer");
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.WISH_FULFILLMENT_TRADE_DENY, "Wish Fulfillment denies offer");

            // Projectiles
            this.generateSoundEventTranslation(translationBuilder, MineLittleFlawlessSoundEvents.LASER_BLAST, "Laser blasts");
        }

        private void generateSoundEventTranslation(TranslationBuilder translationBuilder,
                                                   RegistrySupplier<SoundEvent> soundEventRegistrySupplier,
                                                   String value) {
            translationBuilder.add(this.generateSubtitleDescriptionId(soundEventRegistrySupplier), value);
        }

        private String generateSubtitleDescriptionId(RegistrySupplier<SoundEvent> soundEventRegistrySupplier) {
            return Util.makeDescriptionId("subtitles", soundEventRegistrySupplier.getId());
        }
        
        private void generateAdvancementTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add("advancements.flawless_friendship.title", "Flawless Friendship!");
            translationBuilder.add("advancements.flawless_friendship.descr", "Tame a Flawless!");
            translationBuilder.add("advancements.fashionable_flawless.title", "Fashionable Flawless");
            translationBuilder.add("advancements.fashionable_flawless.descr", "Dress up a tamed Flawless with any clothing!");
            translationBuilder.add("advancements.flawless_buddies.descr", "Tame more than one Flawless!");
            translationBuilder.add("advancements.flawless_buddies.title", "Flawless Buddies!");
            translationBuilder.add("advancements.flawless_enchilada.title", "Flawless Enchilada!");
            translationBuilder.add("advancements.flawless_enchilada.descr", "Tame 6 Flawlesses!");
            translationBuilder.add("advancements.flawless_fan_club.title", "Flawless Fan Club!");
            translationBuilder.add("advancements.flawless_fan_club.descr", "Have every tamed Flawless wear a different clothing!");
        }
    }

    private static class RecipeGenerator extends FabricRecipeProvider {
        public RecipeGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void buildRecipes(Consumer<FinishedRecipe> exporter) {
            // Rotten Sugar recipe
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MineLittleFlawlessItems.ROTTEN_SUGAR.get())
                    .requires(Items.SUGAR)
                    .requires(Items.ROTTEN_FLESH)
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SUGAR))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.ROTTEN_FLESH))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "rotten_sugar"));

            // Farmer Flawless recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.FARMER.get())
                    .define('a', Items.WHEAT)
                    .define('b', Items.STRING)
                    .pattern("aaa")
                    .pattern("b b")
                    .pattern(" b ")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STRING))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "farmer"));

            // Magician Flawless recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING.get())
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
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.PAJAMAS.get())
                    .define('a', Items.WHITE_CARPET)
                    .define('b', ItemTags.CANDLES)
                    .pattern("aaa")
                    .pattern("aba")
                    .pattern("aaa")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_CARPET))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTags.CANDLES).build()))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "pajamas"));

            // Rockstar Flawless recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.ROCKSTAR.get())
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
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.SCHOOLGIRL.get())
                    .define('a', Items.PINK_CARPET)
                    .pattern("aaa")
                    .pattern("a a")
                    .pattern("aaa")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PINK_CARPET))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "schoolgirl"));

            // Tuxedo Flawless recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.TUXEDO.get())
                    .define('a', Items.GRAY_CARPET)
                    .pattern("a a")
                    .pattern("aaa")
                    .pattern("a a")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GRAY_CARPET))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "tuxedo"));

            // Magician Trixie recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.TRIXIE_MAGICIAN.get())
                    .define('a', Items.DIAMOND)
                    .define('b', Items.PURPLE_CARPET)
                    .pattern(" b ")
                    .pattern("bab")
                    .pattern("bbb")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PURPLE_CARPET))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "trixie_magician"));

            // Black Magician Trixie recipe
            ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, MineLittleFlawlessItems.TRIXIE_BLACK_MAGICIAN.get())
                    .requires(MineLittleFlawlessItems.TRIXIE_MAGICIAN.get())
                    .requires(Items.BLACK_DYE)
                    .requires(Items.RED_DYE)
                    .requires(Items.SKELETON_SKULL)
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(MineLittleFlawlessItems.TRIXIE_MAGICIAN.get()))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLACK_DYE))
                    .unlockedBy("has_ingredient_2", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SKELETON_SKULL))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "trixie_black_magician"));

            // Schoolgirl Trixie recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.TRIXIE_SCHOOLGIRL.get())
                    .define('a', Items.WHITE_CARPET)
                    .define('b', Items.PURPLE_CARPET)
                    .pattern("aaa")
                    .pattern(" b ")
                    .pattern(" a ")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_CARPET))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PURPLE_CARPET))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "trixie_schoolgirl"));

            // Gir Trixie recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.TRIXIE_GIR.get())
                    .define('a', Items.BLACK_CARPET)
                    .define('b', Items.LIME_WOOL)
                    .define('c', Items.RED_CARPET)
                    .define('d', Items.IRON_NUGGET)
                    .pattern("aba")
                    .pattern("bcb")
                    .pattern("bdb")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLACK_CARPET))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LIME_WOOL))
                    .unlockedBy("has_ingredient_2", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RED_CARPET))
                    .unlockedBy("has_ingredient_3", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_NUGGET))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "trixie_gir"));

            // Jester Trixiebelle recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.TRIXIEBELLE_JESTER.get())
                    .define('a', Items.GOLD_NUGGET)
                    .define('b', Items.LIME_WOOL)
                    .pattern("a a")
                    .pattern(" b ")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_NUGGET))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LIME_WOOL))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "trixiebelle_jester"));

            // Mexican Trixiebelle recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.TRIXIEBELLE_MEXICAN.get())
                    .define('a', Items.WHEAT)
                    .define('b', Items.LIME_CARPET)
                    .define('c', Items.RED_CARPET)
                    .define('d', Items.YELLOW_CARPET)
                    .pattern(" a ")
                    .pattern("a a")
                    .pattern("bcd")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LIME_CARPET))
                    .unlockedBy("has_ingredient_2", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RED_CARPET))
                    .unlockedBy("has_ingredient_3", InventoryChangeTrigger.TriggerInstance.hasItems(Items.YELLOW_CARPET))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "trixiebelle_mexican"));

            // Dracula Skywishes recipe
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MineLittleFlawlessItems.SKYWISHES_DRACULA.get())
                    .define('a', Items.RED_CARPET)
                    .define('b', Items.WHITE_CARPET)
                    .pattern("aba")
                    .pattern("aaa")
                    .pattern("aba")
                    .unlockedBy("has_ingredient_0", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RED_CARPET))
                    .unlockedBy("has_ingredient_1", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_CARPET))
                    .save(exporter, new ResourceLocation(MineLittleFlawless.MOD_ID, "skywishes_dracula"));
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
                            MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING.get(),
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
                            MineLittleFlawlessItems.TUXEDO.get(),
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
                            MineLittleFlawlessItems.FARMER.get(),
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
                            MineLittleFlawlessItems.FARMER.get(),
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
                            MineLittleFlawlessItems.ROCKSTAR.get(),
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
        public BiomeTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output, Registries.BIOME, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            this.getOrCreateTagBuilder(MineLittleFlawlessTags.SPAWNS_MARIONETTE)
                    .add(
                            Biomes.CHERRY_GROVE,
                            Biomes.OLD_GROWTH_PINE_TAIGA,
                            Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                            Biomes.TAIGA);

            this.getOrCreateTagBuilder(MineLittleFlawlessTags.SPAWNS_WISHCATCHER)
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

            this.getOrCreateTagBuilder(MineLittleFlawlessTags.SPAWNS_TRIXIEBELLE)
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

            this.getOrCreateTagBuilder(MineLittleFlawlessTags.SPAWNS_SKYWISHES)
                    .addTag(MineLittleFlawlessTags.SPAWNS_WISHCATCHER);

            this.getOrCreateTagBuilder(MineLittleFlawlessTags.SPAWNS_STAR_CATCHER)
                    .addTag(MineLittleFlawlessTags.SPAWNS_WISHCATCHER);

            this.getOrCreateTagBuilder(MineLittleFlawlessTags.SPAWNS_JACKIE_SPECTRE)
                    .forceAddTag(BiomeTags.IS_BEACH)
                    .forceAddTag(BiomeTags.IS_OCEAN)
                    .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
                    .forceAddTag(BiomeTags.IS_RIVER)
                    .add(Biomes.STONY_SHORE);
        }
    }

    private static class EntityTypeTagGenerator extends FabricTagProvider.EntityTypeTagProvider {
        public EntityTypeTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            this.getOrCreateTagBuilder(MineLittleFlawlessTags.SPARKLEMOON_FAMILY)
                    .add(
                            MineLittleFlawlessEntities.TWILIGHT.get(),
                            MineLittleFlawlessEntities.TRIXIE.get(),
                            MineLittleFlawlessEntities.FLAWLESS.get(),
                            MineLittleFlawlessEntities.MARIONETTE.get());

            this.getOrCreateTagBuilder(MineLittleFlawlessTags.CLOWN_COLLEGE)
                    .add(
                            MineLittleFlawlessEntities.ARINOS.get(),
                            MineLittleFlawlessEntities.LAST_LAUGH.get(),
                            MineLittleFlawlessEntities.CHERRY_CHUCKLES.get(),
                            MineLittleFlawlessEntities.BIBBLEBOP.get(),
                            MineLittleFlawlessEntities.TRICOLOR_JUBILEE.get());

            this.getOrCreateTagBuilder(EntityTypeTags.FALL_DAMAGE_IMMUNE)
                    .add(
                            MineLittleFlawlessEntities.SKYWISHES.get());
        }
    }

    private static class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
        public ItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            this.getOrCreateTagBuilder(MineLittleFlawlessTags.FARMER_GIFTS)
                    .add(
                            Items.PUMPKIN_SEEDS,
                            Items.NETHER_WART,
                            Items.BEETROOT_SEEDS,
                            Items.COCOA_BEANS,
                            Items.WHEAT_SEEDS,
                            Items.CARROT,
                            Items.POTATO,
                            Items.MELON_SEEDS);

            this.getOrCreateTagBuilder(MineLittleFlawlessTags.FLAWLESS_CLOTHING)
                    .add(
                            MineLittleFlawlessItems.FLAWLESS_MAGICIAN_CLOTHING.get(),
                            MineLittleFlawlessItems.PAJAMAS.get(),
                            MineLittleFlawlessItems.TUXEDO.get(),
                            MineLittleFlawlessItems.SCHOOLGIRL.get(),
                            MineLittleFlawlessItems.FARMER.get(),
                            MineLittleFlawlessItems.ROCKSTAR.get());

            this.getOrCreateTagBuilder(MineLittleFlawlessTags.TRIXIE_CLOTHING)
                    .add(
                            MineLittleFlawlessItems.TRIXIE_MAGICIAN.get(),
                            MineLittleFlawlessItems.TRIXIE_BLACK_MAGICIAN.get(),
                            MineLittleFlawlessItems.TRIXIE_SCHOOLGIRL.get(),
                            MineLittleFlawlessItems.TRIXIE_GIR.get());

            this.getOrCreateTagBuilder(MineLittleFlawlessTags.TRIXIEBELLE_CLOTHING)
                    .add(
                            MineLittleFlawlessItems.TRIXIEBELLE_JESTER.get(),
                            MineLittleFlawlessItems.TRIXIEBELLE_MEXICAN.get());

            this.getOrCreateTagBuilder(MineLittleFlawlessTags.SKYWISHES_CLOTHING)
                    .add(
                            MineLittleFlawlessItems.SKYWISHES_DRACULA.get());

            this.getOrCreateTagBuilder(MineLittleFlawlessTags.FLAWLESS_FOOD)
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

            this.getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                    .add(
                            MineLittleFlawlessItems.MUSIC_DISC_WISHLESS_RESONANCE.get());

            this.getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                    .add(
                            MineLittleFlawlessItems.MUSIC_DISC_WISHLESS_RESONANCE.get());
        }
    }
}
