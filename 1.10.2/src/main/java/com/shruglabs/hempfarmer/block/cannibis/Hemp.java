package com.shruglabs.hempfarmer.block.cannibis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

public class Hemp extends HFBlockCrops { public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
private static final AxisAlignedBB[] HEMP_AABB = { new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1328125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.265625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3984375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.53125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.6640625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.796875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.9296875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0625D, 1.0D) };

public Hemp(String name)
{
  super(name);
}

public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
{
  return HEMP_AABB[((Integer)state.getValue(getAgeProperty())).intValue()];
}

protected Item getSeed()
{
  Random random = new Random();
  int x = random.nextInt(100) + 1;
  Item seed;
  
  if (x > 90)
  {
    boolean y = random.nextBoolean();
    seed = y == true ? HFItems.seeds_indica : HFItems.seeds_sativa;
  }
  else
  {
    seed = HFItems.seeds_hemp;
  }
  return seed;
}

protected Item getCrop()
{
  Random random = new Random();
  int x = random.nextInt(100) + 1;
  crop = x > 90 ? HFItems.bud : HFItems.raw_hemp;
  cropName = crop.getRegistryName().toString().endsWith("bud") ? "bud" : "hemp";
  return crop;
}

public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
{
  List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
  int age = getAge(state);
  Random rand = (world instanceof World) ? ((World)world).rand : new Random();
  if (age >= getMaxAge())
  {
    int k = 3 + fortune;
    for (int i = 0; i < 3 + fortune; i++) {
      if (rand.nextInt(2 * getMaxAge()) <= age)
      {
        ret.add(new ItemStack(getSeed(), seedsCropAmount));
        if (cropName == "bud") {
          ret.add(new ItemStack(getCrop(), budAmount));
        } else {
          ret.add(new ItemStack(getCrop(), hempAmount));
        }
      }
    }
  }
  int x = rand.nextInt(100) + 1;
  if (x > 99) {
    ret.add(new ItemStack(HFItems.leaf, rand.nextInt(2) + 1));
  }
  return ret;
}
}
