package org.projectflawless.minelittleflawless.item;

import net.minecraft.world.item.Item;
import org.projectflawless.minelittleflawless.Clothing;

public class PajamasItem extends FlawlessClothingItem {
	public PajamasItem(Item.Properties properties) {
		super(properties.stacksTo(1), Clothing.PAJAMAS);
	}
}