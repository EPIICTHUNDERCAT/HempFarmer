package com.shruglabs.hempfarmer.item.joint;

import com.shruglabs.hempfarmer.item.HFDrug;
import com.shruglabs.hempfarmer.utils.HUtils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Joint extends HFDrug {



	public Joint(String name, int maxStack) {
		super(name, maxStack);

	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		return EnumActionResult.SUCCESS;
	}
	  /**
     * How long it takes to use or consume an item
     */@Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.EAT;
	}

	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ, EnumHand hand) {
		return EnumActionResult.SUCCESS;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entityLiving) {
		EntityPlayer entity = entityLiving instanceof EntityPlayer ? (EntityPlayer) entityLiving : null;

		if (entity == null || !entity.capabilities.isCreativeMode) {

			stack.shrink(1);
		}

		if (!world.isRemote) {
			entity.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 400, 1, true, false));
			entity.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 400, 2, true, false));
			entity.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 50, 3, true, false));
			entity.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 150, 1, true, false));
			entity.addPotionEffect(new PotionEffect(Potion.getPotionById(24), 400, 2, true, false));
			smoke(entity, world);
		}
		return stack;

	}

	public void smoke(EntityLivingBase entity, World world) {
		HUtils.spawnParticles(entity, EnumParticleTypes.SMOKE_NORMAL, 5, entity.posX, entity.posY + 1.5, entity.posZ + 0.5, 0, 0, 0, 0.5);
		
		HUtils.spawnParticles(entity, EnumParticleTypes.SMOKE_LARGE, 5, entity.posX, entity.posY + 1.5, entity.posZ + 0.5, 0, 0, 0, 0.5);
		/*double x = entity.posX;
		double y = entity.posY + 1.5;
		double z = entity.posZ;
		
		world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, x - 0.2, y, z - 0.2, -0.05, 0.05, 0.05);
		world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y, z, 0.05, -0.05, 0.05);
		world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, x + 0.2, y, z + 0.2, 0.05, 0.05, -0.05);
		world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x - 0.2, y, z - 0.2, 0.05, -0.05, -0.05);
		world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, x, y, z, -0.05, -0.05, 0.05);
		world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + 0.2, y, z + 0.2, -0.05, -0.05, -0.05);*/
	}

}
