package com.shruglabs.hempfarmer.block.dirt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.shruglabs.hempfarmer.block.HFBlockDirt;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class VioletDirt extends HFBlockDirt {

	public VioletDirt(String name) {
		super(name);
		this.blockSoundType = SoundType.SLIME;
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
		playerDestroyed = true;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> ret = new ArrayList<ItemStack>();
		Random rand = world instanceof World ? ((World) world).rand : RANDOM;
		Item item = null;
		if (playerDestroyed && !fromOil) {
			item = Blocks.DIRT.getItemDropped(state, rand, fortune);
		} else {
			item = this.getItemDropped(state, rand, fortune);
		}
		if (item != null) {
			ret.add(new ItemStack(item, 1));
		}
		return ret;
	}

	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		EntityPlayer player = null;
		if (world.getPlayerEntityByName(entity.getName()) != null) {
			player = world.getPlayerEntityByName(entity.getName());
		}
		if (player != null) {
			if (!world.isRemote) {
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 60, 5));
			} else {
				player.setVelocity(0.0, 1.75, 0.0);
			}
		}
	}
}
