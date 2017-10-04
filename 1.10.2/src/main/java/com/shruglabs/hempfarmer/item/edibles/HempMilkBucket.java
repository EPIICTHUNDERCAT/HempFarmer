package com.shruglabs.hempfarmer.item.edibles;

import javax.annotation.Nullable;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class HempMilkBucket extends ItemBucketMilk {
	 public HempMilkBucket(String name, int maxStack)
	  {
	    setRegistryName(name);
	    setUnlocalizedName(name);
	    addToItems(this);
	    setCreativeTab(HFCreativeTabs.FOOD);
	  }
	  
	  private void addToItems(Item item)
	  {
	    HFItems.items.add(item);
	  }
	  
	  @Nullable
	  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	  {
	    if (((entityLiving instanceof EntityPlayer)) && (!((EntityPlayer)entityLiving).capabilities.isCreativeMode)) {
	      stack.stackSize -= 1;
	    }
	    if (!worldIn.isRemote) {
	      entityLiving.curePotionEffects(new ItemStack(Items.MILK_BUCKET));
	    }
	    if ((entityLiving instanceof EntityPlayer)) {
	      ((EntityPlayer)entityLiving).addStat(StatList.getObjectUseStats(this));
	    }
	    return stack.stackSize <= 0 ? new ItemStack(Items.BUCKET) : stack;
	  }

}
