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

public class Hemp extends HFBlockCrops {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
	private static final AxisAlignedBB[] HEMP_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1328125D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.265625D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3984375D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.53125D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.6640625D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.796875D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.9296875D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0625, 1.0D) };

	public Hemp(String name) {
		super(name);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return HEMP_AABB[((Integer) state.getValue(this.getAgeProperty())).intValue()];
	}

	@Override
	protected Item getSeed() {
		Item seed;
		Random random = new Random();
		int x = random.nextInt(30) + 1;
		if (x > 27) {
			boolean y = random.nextBoolean();
			seed = y == true ? HFItems.seeds_indica : HFItems.seeds_sativa;
		} else {
			seed = HFItems.seeds_hemp;
		}
		return seed;
	}

	@Override
	protected Item getCrop() {
		Random random = new Random();
		int x = random.nextInt(30) + 1;
		Hemp.crop = x > 27 ? HFItems.bud : HFItems.raw_hemp;
		this.setCropName(crop.equals(HFItems.raw_hemp) ? "hemp" : "bud");
		return HFBlockCrops.crop;
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
				ret.add(new ItemStack(this.getSeed(), ConfigHandler.hempSeedsCropAmount));
				if (this.getCropName() == "bud") {
					ret.add(new ItemStack(this.getCrop(), ConfigHandler.hempBudAmount));
				} else {
					ret.add(new ItemStack(this.getCrop(), ConfigHandler.hempAmount));
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
