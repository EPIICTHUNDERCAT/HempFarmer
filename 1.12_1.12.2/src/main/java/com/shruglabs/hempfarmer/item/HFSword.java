package com.shruglabs.hempfarmer.item;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class HFSword extends ItemSword{
	
	public static ToolMaterial RESIN = EnumHelper.addToolMaterial("RESIN", 3, 30, 6.0F, 3.0F, 30);
	
	private final float attackDamage;
	private final ToolMaterial material;
	
	public HFSword(String name, ToolMaterial material, Item item) {
		super(material);
		this.material = material;
		material.setRepairItem(new ItemStack(item));
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(HFCreativeTabs.HempFarmer);
		this.setMaxDamage(material.getMaxUses());
		this.attackDamage = 3.0F + this.material.getAttackDamage();
		addToItems(this);
	}

	private void addToItems(Item item) {
		HFItems.items.add(item);
	}

	public float getAttackDamage() {
		return attackDamage;
	}
	

}


