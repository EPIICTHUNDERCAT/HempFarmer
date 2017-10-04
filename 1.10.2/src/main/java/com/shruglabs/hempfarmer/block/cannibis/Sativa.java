package com.shruglabs.hempfarmer.block.cannibis;

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

public class Sativa extends HFBlockCrops {
	 public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
	  private static final AxisAlignedBB[] SATIVA_AABB = { new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.19D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.38D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.57D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.76D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.95D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.14D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.33D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.52D, 1.0D) };
	  
	  public Sativa(String name)
	  {
	    super(name);
	  }
	  
	  public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	  {
	    return SATIVA_AABB[((Integer)state.getValue(getAgeProperty())).intValue()];
	  }
	  
	  protected Item getSeed()
	  {
	    Random random = new Random();
	    int x = random.nextInt(100) + 1;
	    Item seed;
	    
	    if (x > 97)
	    {
	      boolean y = random.nextBoolean();
	      seed = HFItems.seeds_indica;
	    }
	    else
	    {
	      
	      if (x > 90) {
	        seed = HFItems.seeds_hemp;
	      } else {
	        seed = HFItems.seeds_sativa;
	      }
	    }
	    return seed;
	  }
	  
	  protected Item getCrop()
	  {
	    Random random = new Random();
	    int x = random.nextInt(100) + 1;
	    Item crop = x > 70 ? HFItems.lime_raw_hemp : HFItems.sativa_bud;
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
	          ret.add(new ItemStack(getCrop(), hempAmount));
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
