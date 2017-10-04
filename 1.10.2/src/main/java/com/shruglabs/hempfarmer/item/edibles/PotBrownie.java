package com.shruglabs.hempfarmer.item.edibles;

import java.util.Random;

import javax.annotation.Nullable;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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
	public final int itemUseDuration;
	  private final int healAmount;
	  private final float saturationModifier;
	  private final boolean isWolfsFavoriteMeat;
	  private boolean alwaysEdible;
	  
	  public PotBrownie(String name)
	  {
	    super(2, 0.0F, false);
	    this.itemUseDuration = 16;
	    this.healAmount = 0;
	    this.isWolfsFavoriteMeat = false;
	    this.saturationModifier = 0.0F;
	    this.alwaysEdible = true;
	    setRegistryName(name);
	    setUnlocalizedName(name);
	    setCreativeTab(HFCreativeTabs.HFFoods);
	    
	    addToItems(this);
	  }
	  
	  public void addToItems(Item item)
	  {
	    HFItems.items.add(item);
	  }
	  
	  public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	  {
	    playerIn.setActiveHand(hand);
	    return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	  }
	  
	  @Nullable
	  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	  {
	    Random random = new Random();
	    int x = random.nextInt(1000) + 250;
	    entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(8), x, 6, true, false));
	    entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(17), x, 1, true, false));
	    entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(2), x, 1, true, false));
	    entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(16), x, 5, true, false));
	    x = random.nextInt(400) + 150;
	    entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(9), x, 5, true, false));
	    entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(11), x + 100, 5, true, false));
	    entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(24), x - 60, 5, true, false));
	    entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(25), x - 60, 5, true, false));
	    stack.stackSize -= 1;
	    return stack;
	  }
	  
	  public int getMaxItemUseDuration(ItemStack stack)
	  {
	    return 16;
	  }
}
