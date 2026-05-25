package org.projectflawless.minelittleflawless.item;

import net.minecraft.world.item.Item;
import org.projectflawless.minelittleflawless.Clothing;

public class TuxedoItem extends FlawlessClothingItem {
	public TuxedoItem(Item.Properties properties) {
		super(properties.stacksTo(1), Clothing.TUXEDO);
	}
}