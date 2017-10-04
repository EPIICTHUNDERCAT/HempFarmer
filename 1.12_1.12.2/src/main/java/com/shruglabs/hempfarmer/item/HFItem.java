package com.shruglabs.hempfarmer.item;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.item.Item;

public class HFItem extends Item {

	public HFItem(String name, int maxStack) {
		this.setMaxStackSize(maxStack);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(HFCreativeTabs.HFMisc);
		addToItems(this);
	}
	


	private void addToItems(Item item) {
		HFItems.items.add(item);
	}



	

}