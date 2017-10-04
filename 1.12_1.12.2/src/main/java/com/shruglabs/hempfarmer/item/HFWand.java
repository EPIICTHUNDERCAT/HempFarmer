package com.shruglabs.hempfarmer.item;

import com.shruglabs.hempfarmer.entity.EntityShotLeaf;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HFWand extends HFItem {

	public static int leafDamage;
	public static int superiorDamage;

	public HFWand(String name) {
		super(name, 1);
		if (this.equals(HFItems.superior_leaf_wand)) {
			this.setMaxDamage(superiorDamage);
			this.setContainerItem(HFItems.broken_superior_leaf_wand);
		} else {
			this.setMaxDamage(leafDamage);
			this.setContainerItem(Items.STICK);
		}
	}

	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		if (stack.getTagCompound().hasKey("wandCooldown")) {
			if (stack.getTagCompound().getInteger("wandCooldown") == 0) {
				if (stack.getTagCompound().hasKey("firing")) {
					stack.getTagCompound().setInteger("firing", stack.getTagCompound().getInteger("firing") + 1);
				} else {
					stack.getTagCompound().setInteger("firing", 1);
				}
				stack.getTagCompound().setInteger("wandCooldown", 10);
			}
		} else {
			if (stack.getTagCompound().hasKey("firing")) {
				stack.getTagCompound().setInteger("firing", stack.getTagCompound().getInteger("firing") + 1);
			} else {
				stack.getTagCompound().setInteger("firing", 1);
			}
			stack.getTagCompound().setInteger("wandCooldown", 10);
		}

		return false;

	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (stack.hasTagCompound()) {
			if (stack.getTagCompound().hasKey("wandCooldown")) {
				if (stack.getTagCompound().getInteger("wandCooldown") > 0) {
					stack.getTagCompound().setInteger("wandCooldown",
							stack.getTagCompound().getInteger("wandCooldown") - 1);
				}

				if (stack.getTagCompound().hasKey("firing")) {
					if (stack.getTagCompound().getInteger("firing") > 0) {
						stack.getTagCompound().setInteger("firing", stack.getTagCompound().getInteger("firing") - 1);
						for (int i = 0; i < 6; ++i) {
							if ((i % 6) == 0) {
								if (!world.isRemote) {
									world.playSound((EntityPlayer) null, entity.posX, entity.posY, entity.posZ,
											SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.NEUTRAL, 1.5F, 10.0F);
									EntityShotLeaf leaf = new EntityShotLeaf(world, (EntityLivingBase) entity);
									leaf.setHeadingFromThrower(entity, entity.rotationPitch, entity.rotationYaw, 0.0F,
											1.0F, 0.0F);
									entity.getEntityWorld().spawnEntity(leaf);
									stack.damageItem(1, (EntityPlayer) entity);
									if (stack.getItemDamage() == stack.getMaxDamage()) {

										entity.replaceItemInInventory(itemSlot, new ItemStack(this.getContainerItem()));
									}
								}
							}
						}
					}
				}

			}

		} else {
			stack.setTagCompound(new NBTTagCompound());
		}
	}

	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
		player.getActiveItemStack().getTagCompound().setBoolean("inUse", true);
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		entityLiving.getActiveItemStack().getTagCompound().setBoolean("inUse", false);
		return stack;
	}

	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		return !state.getBlock().equals(Blocks.TALLGRASS) || !state.equals(Blocks.GRASS) ? 0.0F : 1.0F;
	}

	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos,
			EntityLivingBase entityLiving) {
		return !world.getBlockState(pos).getBlock().equals(Blocks.TALLGRASS)
				|| !world.getBlockState(pos).equals(Blocks.GRASS);
	}

	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return slotChanged || !newStack.isItemEqual(oldStack);
	}

}
