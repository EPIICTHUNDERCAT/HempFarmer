package com.shruglabs.hempfarmer.item.edibles;

import javax.annotation.Nullable;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFItems;
import com.shruglabs.hempfarmer.utils.HUtils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class PotBrownie extends ItemFood {

	public PotBrownie(String name) {
		super(2, 0.0F, false);
		
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(HFCreativeTabs.HempFarmer);
		this.setAlwaysEdible();
		addToItems(this);
	}

	public void addToItems(Item item) {
		HFItems.items.add(item);
	}

@Override
public EnumAction getItemUseAction(ItemStack stack) {
	return EnumAction.EAT;
}

	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		playerIn.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}

	@Override
	@Nullable
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		int x = HUtils.random.nextInt(10000) + 2500;
		entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(8), x, 6, true, false));
		entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(17), x, 1, true, false));
		entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(2), x, 1, true, false));
		entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(16), x, 5, true, false));
		x = HUtils.random.nextInt(4000) + 1500;
		entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(9), x, 5, true, false));
		entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(11), x + 100, 5, true, false));
		entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(24), x - 60, 5, true, false));
		entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(25), x - 60, 5, true, false));
		stack.shrink(1);
		return stack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 16;
	}
}
