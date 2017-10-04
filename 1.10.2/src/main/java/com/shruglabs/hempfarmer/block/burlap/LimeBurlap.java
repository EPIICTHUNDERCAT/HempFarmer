package com.shruglabs.hempfarmer.block.burlap;

import com.shruglabs.hempfarmer.block.HFBlockBurlap;
import com.shruglabs.hempfarmer.block.HFBlockDirt;
import com.shruglabs.hempfarmer.init.HFBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LimeBurlap extends HFBlockBurlap {

	public LimeBurlap(Material material, String name) {
		super(material, name);
		this.setTickRandomly(true);
	}

	
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {

		Block block = world.getBlockState(pos.down()).getBlock();
		if (block.equals(Blocks.DIRT) || block.equals(Blocks.GRASS)) {
			if (!this.getRegistryName().toString().endsWith("_block")) {
				HFBlockDirt blockOut = (HFBlockDirt) HFBlocks.lime_dirt;
				blockOut.fromOil = false;
				if (!world.isRemote) {
					world.setBlockState(pos.down(), blockOut.getDefaultState());
				}
			}
		}
		return this.getDefaultState();
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
		Block block = world.getBlockState(pos.down()).getBlock();
		if (block.equals(HFBlocks.lime_dirt)) {
			if (!world.isRemote) {
				world.setBlockState(pos.down(), Blocks.DIRT.getDefaultState());
			}
		}
	}

	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		IBlockState state = world.getBlockState(pos);
		if (state.getBlock().getRegistryName().toString().endsWith("_block")) {
			EntityPlayer player = null;
			if (world.getPlayerEntityByName(entity.getName()) != null) {
				player = world.getPlayerEntityByName(entity.getName());
			}
			if (player != null) {
				if (!world.isRemote) {
					player.heal(0.1F);
				}
			}
		}
	}

}
