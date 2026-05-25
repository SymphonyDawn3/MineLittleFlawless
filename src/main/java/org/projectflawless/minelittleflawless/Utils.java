package org.projectflawless.minelittleflawless;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;

public class Utils {
    public static Item getRandomItemFromTags(TagKey<Item> tagItem) {
        Holder<Item> itemHolder = BuiltInRegistries.ITEM.getOrCreateTag(tagItem)
                .getRandomElement(RandomSource.create()).orElseThrow();
        return itemHolder.value();
    }
}
