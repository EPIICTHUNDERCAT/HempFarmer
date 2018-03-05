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

public class Sativa extends HFBlockCrops {

	
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
	private static final AxisAlignedBB[] SATIVA_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.19D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.38D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.57D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.76D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.95D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.14D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.33D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.52D, 1.0D) };

	public Sativa(String name) {
		super(name);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SATIVA_AABB[((Integer) state.getValue(this.getAgeProperty())).intValue()];
	}

	@Override
	protected Item getSeed() {
		Item seed;
		Random random = new Random();
		int x = random.nextInt(10) + 1;
		if (x > 7) {
			seed = HFItems.seeds_indica;
		} else if (x > 9) {
			seed = HFItems.seeds_hemp;
		} else {
			seed = HFItems.seeds_sativa;
		}
		return seed;
	}

	@Override
	protected Item getCrop() {
		Item crop;
		Random random = new Random();
		int x = random.nextInt(10) + 1;
		crop = x > 5 ? HFItems.lime_raw_hemp : HFItems.sativa_bud;
		this.setCropName(crop.equals(HFItems.lime_raw_hemp) ? "hemp" : "bud");
		
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
				ret.add(new ItemStack(this.getSeed(), ConfigHandler.sativaSeedsCropAmount));
				if (this.getCropName() == "bud") {
					ret.add(new ItemStack(this.getCrop(), ConfigHandler.sativaBudAmount));
				} else {
					ret.add(new ItemStack(this.getCrop(), ConfigHandler.sativaAmount));
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
