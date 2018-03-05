package com.shruglabs.hempfarmer.block.cannibis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.shruglabs.hempfarmer.ConfigHandler;
import com.shruglabs.hempfarmer.block.HFBlockCrops;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Indica extends HFBlockCrops {
	
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
	private static final AxisAlignedBB[] INDICA_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.755D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.76D, 1.0D) };

	public Indica(String name) {
		super(name);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return INDICA_AABB[((Integer) state.getValue(this.getAgeProperty())).intValue()];
	}

	@Override
	protected Item getSeed() {
		Item seed;
		Random random = new Random();
		int x = random.nextInt(10) + 1;
		if (x > 7) {
			seed = HFItems.seeds_sativa;
		} else if (x > 9) {
			seed = HFItems.seeds_hemp;
		} else {
			seed = HFItems.seeds_indica;
		}
		return seed;
	}

	@Override
	protected Item getCrop() {
		Item crop;
		Random random = new Random();
		int x = random.nextInt(10) + 1;
		crop = x > 5 ? HFItems.violet_raw_hemp : HFItems.indica_bud;
		this.setCropName(crop.equals(HFItems.violet_raw_hemp) ? "hemp" : "bud");

		return crop;
	}


	@Override
	public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state,
			int fortune) {
		super.getDrops(world, pos, state, fortune);
		List<ItemStack> ret = new ArrayList<ItemStack>();
		int age = getAge(state);
		Random rand = world instanceof World ? ((World) world).rand : new Random();

		if (age >= getMaxAge()) {
			if (rand.nextInt(2 * getMaxAge()) <= age) {
				ret.add(new ItemStack(this.getSeed(), ConfigHandler.indicaSeedsCropAmount));
				if (this.getCropName() == "bud") {
					ret.add(new ItemStack(this.getCrop(), ConfigHandler.indicaBudAmount));
				} else {
					ret.add(new ItemStack(this.getCrop(), ConfigHandler.indicaAmount));
				}

			}
		}
		if (ConfigHandler.enableWand == true) {
			int x = rand.nextInt(100) + 1;
			if (x > 99) {
				ret.add(new ItemStack(HFItems.leaf, rand.nextInt(2) + 1));
			}
		}
		return ret;
	}
}
