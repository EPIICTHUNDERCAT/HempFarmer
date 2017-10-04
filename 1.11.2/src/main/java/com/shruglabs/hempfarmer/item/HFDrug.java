package com.shruglabs.hempfarmer.item;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.item.Item;

public class HFDrug extends Item {

	public HFDrug(String name, int maxStack) {
		this.setMaxStackSize(maxStack);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(HFCreativeTabs.HFDrugs);
		addToItems(this);
	}

	private void addToItems(Item item) {
		HFItems.items.add(item);
	}
}
