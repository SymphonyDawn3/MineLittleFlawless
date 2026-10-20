package org.projectflawless.minelittleflawless;

import com.google.common.collect.ImmutableList;
import dev.architectury.event.events.common.LootEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.projectflawless.minelittleflawless.entity.Flawless;
import org.projectflawless.minelittleflawless.event.PlayerSleepEvent;
import org.projectflawless.minelittleflawless.init.MineLittleFlawlessItems;

import java.util.List;

public class FlawlessEvents {
    private static final List<ResourceLocation> LOOT_TABLES = ImmutableList.of(
            BuiltInLootTables.ANCIENT_CITY,
            BuiltInLootTables.SIMPLE_DUNGEON,
            BuiltInLootTables.STRONGHOLD_CORRIDOR,
            BuiltInLootTables.WOODLAND_MANSION
    );

    public static void init() {
        // This allows farmer Flawless to give you items whenever you go to bed.
        PlayerSleepEvent.SLEEPING.register(Flawless::whenPlayerWakesUp);

        // Add music discs to specified vanilla loot tables
        LootEvent.MODIFY_LOOT_TABLE.register((lootDataManager, id, context,
                                              builtin) -> {
            if (builtin && LOOT_TABLES.contains(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .add(LootItem.lootTableItem(MineLittleFlawlessItems.MUSIC_DISC_WISHLESS_RESONANCE.get()))
                        .setRolls(UniformGenerator.between(0, 1));
                context.addPool(poolBuilder);
            }
        });
    }
}
