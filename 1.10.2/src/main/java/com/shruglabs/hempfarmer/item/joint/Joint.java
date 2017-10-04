package com.shruglabs.hempfarmer.item.joint;

import javax.annotation.Nullable;

import com.shruglabs.hempfarmer.item.HFDrug;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class Joint extends HFDrug {
	 public int itemUseDuration;
	  
	  public Joint(String name, int maxStack)
	  {
	    super(name, maxStack);
	    this.itemUseDuration = 16;
	  }
	  
	  public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	  {
	    playerIn.setActiveHand(hand);
	    return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	  }
	  
	  @Nullable
	  public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entity)
	  {
	    stack.stackSize -= 1;
	    entity.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 400, 1, true, false));
	    entity.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 400, 2, true, false));
	    entity.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 50, 3, true, false));
	    entity.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 150, 1, true, false));
	    entity.addPotionEffect(new PotionEffect(Potion.getPotionById(24), 400, 2, true, false));
	    smoke(entity, world);
	    return stack;
	  }
	  
	  public int getMaxItemUseDuration(ItemStack stack)
	  {
	    return 16;
	  }
	  
	  public EnumAction getItemUseAction(ItemStack stack)
	  {
	    return EnumAction.BOW;
	  }
	  
	  public void smoke(EntityLivingBase entity, World world)
	  {
	    double x = entity.posX;
	    double y = entity.posY + 1.5D;
	    double z = entity.posZ;
	    world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, x - 0.2D, y, z - 0.2D, -0.05D, 0.05D, 0.05D, new int[0]);
	    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y, z, 0.05D, -0.05D, 0.05D, new int[0]);
	    world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, x + 0.2D, y, z + 0.2D, 0.05D, 0.05D, -0.05D, new int[0]);
	    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x - 0.2D, y, z - 0.2D, 0.05D, -0.05D, -0.05D, new int[0]);
	    world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, x, y, z, -0.05D, -0.05D, 0.05D, new int[0]);
	    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + 0.2D, y, z + 0.2D, -0.05D, -0.05D, -0.05D, new int[0]);
	  }

}
