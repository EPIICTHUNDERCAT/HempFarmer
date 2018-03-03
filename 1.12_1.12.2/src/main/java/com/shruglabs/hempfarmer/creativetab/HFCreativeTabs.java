package com.shruglabs.hempfarmer.creativetab;

import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HFCreativeTabs extends CreativeTabs {

	public HFCreativeTabs(int index, String label) {
		super(index, label);
	}

	public static final HFCreativeTabs HempFarmer = new HFCreativeTabs(CreativeTabs.getNextID(), "hempfarmer") {
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(HFItems.indica_joint);
		}
	};
	

	@Override
	public ItemStack getTabIconItem() {
		return null;
	}

}
