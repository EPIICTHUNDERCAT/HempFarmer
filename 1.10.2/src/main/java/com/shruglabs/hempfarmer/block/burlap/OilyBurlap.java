package com.shruglabs.hempfarmer.block.burlap;

import com.shruglabs.hempfarmer.block.HFBlockBurlap;
import com.shruglabs.hempfarmer.block.HFBlockDirt;
import com.shruglabs.hempfarmer.init.HFBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OilyBurlap extends HFBlockBurlap {

	public OilyBurlap(Material material, String name) {
		super(material, name);
		this.slipperiness = 0.96F;
	}

	
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		Block block = world.getBlockState(pos.down()).getBlock();
		if (block.equals(Blocks.DIRT) || block.equals(Blocks.GRASS)) {
			if (!this.getRegistryName().toString().endsWith("_block")) {
				HFBlockDirt blockOut = (HFBlockDirt) HFBlocks.oily_dirt;
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
		if (block.equals(HFBlocks.oily_dirt)) {
			if (!world.isRemote) {
				world.setBlockState(pos.down(), Blocks.DIRT.getDefaultState());
			}
		}
	}

}
