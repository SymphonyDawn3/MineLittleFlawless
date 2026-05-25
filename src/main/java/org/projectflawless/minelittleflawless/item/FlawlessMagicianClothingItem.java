package org.projectflawless.minelittleflawless.item;

import net.minecraft.world.item.Item;
import org.projectflawless.minelittleflawless.Clothing;

public class FlawlessMagicianClothingItem extends FlawlessClothingItem {
	public FlawlessMagicianClothingItem(Item.Properties properties) {
		super(properties.stacksTo(1), Clothing.FLAWLESS_MAGICIAN_CLOTHING);
	}
}