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

	public HempMilkBucket(String name, int maxStack) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		addToItems(this);
		this.setCreativeTab(HFCreativeTabs.FOOD);
		this.setContainerItem(Items.BUCKET);
	}

	private void addToItems(Item item) {
		HFItems.items.add(item);
	}

	@Override
	@Nullable
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		if (entityLiving instanceof EntityPlayer && !((EntityPlayer) entityLiving).capabilities.isCreativeMode) {
			stack.shrink(1);
		}

		if (!worldIn.isRemote) {
			entityLiving.curePotionEffects(new ItemStack(Items.MILK_BUCKET));
		}

		if (entityLiving instanceof EntityPlayer) {
			((EntityPlayer) entityLiving).addStat(StatList.getObjectUseStats(this));
		}

		return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
	}
	
	


}
