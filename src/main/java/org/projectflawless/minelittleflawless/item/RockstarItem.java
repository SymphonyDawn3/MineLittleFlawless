package org.projectflawless.minelittleflawless.item;

import net.minecraft.world.item.Item;
import org.projectflawless.minelittleflawless.Clothing;

public class RockstarItem extends FlawlessClothingItem {
	public RockstarItem(Item.Properties properties) {
		super(properties.stacksTo(1), Clothing.ROCKSTAR);
	}
}