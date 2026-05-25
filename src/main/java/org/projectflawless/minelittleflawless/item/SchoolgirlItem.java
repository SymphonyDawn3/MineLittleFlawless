package org.projectflawless.minelittleflawless.item;

import net.minecraft.world.item.Item;
import org.projectflawless.minelittleflawless.Clothing;

public class SchoolgirlItem extends FlawlessClothingItem {
	public SchoolgirlItem(Item.Properties properties) {
		super(properties.stacksTo(1), Clothing.SCHOOLGIRL);
	}
}