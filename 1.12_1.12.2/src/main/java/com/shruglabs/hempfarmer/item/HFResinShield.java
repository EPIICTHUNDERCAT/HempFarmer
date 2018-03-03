package com.shruglabs.hempfarmer.item;

import javax.annotation.Nullable;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HFResinShield extends ItemShield {
	
	 public HFResinShield(String name) {
	        this.maxStackSize = 1;
			this.setRegistryName(name);
			this.setUnlocalizedName(name);
			addToItems(this);
	        this.setMaxDamage(336);
	        this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
	            @SideOnly(Side.CLIENT)
	            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
	                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
	            }
	        });
	    }

	private void addToItems(Item item) {
		HFItems.items.add(item);		
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return "Resin Shield";
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTab() {
        return HFCreativeTabs.HempFarmer;
    }
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
	        return repair.getItem() == HFItems.resin ? true : super.getIsRepairable(toRepair, repair);
	}
}
