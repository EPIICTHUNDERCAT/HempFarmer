package com.shruglabs.hempfarmer.block.burlap;

import com.shruglabs.hempfarmer.block.HFBlockBurlap;
import com.shruglabs.hempfarmer.init.HFBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Burlap extends HFBlockBurlap {

	public Burlap(Material material, String name) {
		super(material, name);
	}

	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		entityIn.fall(fallDistance = 0, 0.0F);
	}

	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		Block block = world.getBlockState(pos.down()).getBlock();
		if (block.equals(Blocks.DIRT) || block.equals(Blocks.GRASS)) {
			if (!this.getRegistryName().toString().endsWith("_block")) {
				if (!world.isRemote) {
					world.setBlockState(pos.down(), HFBlocks.covered_dirt.getDefaultState());
				}
			}
		}
		return this.getDefaultState();
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
		Block block = world.getBlockState(pos.down()).getBlock();
		if (block.equals(HFBlocks.covered_dirt)) {
			if (!world.isRemote) {
				world.setBlockState(pos.down(), Blocks.DIRT.getDefaultState());
			}
		}
	}

}
