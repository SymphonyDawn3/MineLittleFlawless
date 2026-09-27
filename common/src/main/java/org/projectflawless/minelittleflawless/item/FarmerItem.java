package org.projectflawless.minelittleflawless.item;

import net.minecraft.world.item.Item;
import org.projectflawless.minelittleflawless.Clothing;

public class FarmerItem extends FlawlessClothingItem {
	public FarmerItem(Item.Properties properties) {
		super(properties.stacksTo(1), Clothing.FARMER);
	}
}