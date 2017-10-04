package com.shruglabs.hempfarmer.block;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HFBlockDirt extends Block {

	protected boolean playerDestroyed = false;
	public boolean fromOil = false;

	public HFBlockDirt(String name) {
		super(Material.GROUND);
		this.setHardness(0.5F);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.blockSoundType = SoundType.GROUND;
		this.setCreativeTab(HFCreativeTabs.HFMisc);
		addToBlocks(this);
	}

	private void addToBlocks(HFBlockDirt block) {
		HFBlocks.blocks.add(block);
	}

	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		entityIn.fall(fallDistance = 0, 0.0F);
	}

	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		fromOil = true;
		return this.getDefaultState();
	}

}
