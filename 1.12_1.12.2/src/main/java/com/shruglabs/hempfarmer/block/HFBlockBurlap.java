package com.shruglabs.hempfarmer.block;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HFBlockBurlap extends Block {

	protected static AxisAlignedBB AABB;

	public HFBlockBurlap(Material material, String name) {
		super(material);
		this.setHardness(0.35F);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.blockSoundType = SoundType.PLANT;
		this.setCreativeTab(HFCreativeTabs.HFMisc);
		addToBlocks(this);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (state.getBlock().getRegistryName().toString().endsWith("_block")) {
			AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		} else {
			AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
		}
		return AABB;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos) {
		return super.canPlaceBlockAt(world, pos) && this.canBlockStay(world, pos);
	}

	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
		this.checkForDrop(worldIn, pos, state);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		entityIn.fall(fallDistance = 0, 0.0F);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return state.getBlock().getRegistryName().toString().endsWith("_block");
	}

	private void addToBlocks(HFBlockBurlap block) {
		HFBlocks.blocks.add(block);
	}

	private boolean canBlockStay(World world, BlockPos pos) {
		boolean stays;
		Block block = this.blockState.getBlock();
		if (block.getRegistryName().toString().endsWith("_block")) {
			stays = true;
		} else {
			stays = world.isBlockFullCube(pos.down()) && !world.isAirBlock(pos.down());
		}

		return stays;
	}

	private boolean checkForDrop(World world, BlockPos pos, IBlockState state) {
		boolean drop;
		if (!this.canBlockStay(world, pos)) {
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockToAir(pos);
			drop = false;
		} else {
			drop = true;
		}
		return drop;
	}

}
