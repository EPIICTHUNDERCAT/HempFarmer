package com.shruglabs.hempfarmer.block;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFBlocks;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class HFBlockCrops extends BlockCrops {

	  public static int seedsGrassRate;
	  public static int seedsCropAmount;
	  public static int hempAmount;
	  public static int budAmount;
	  public static Item crop;
	  public static String cropName;
	  
	  public HFBlockCrops(String name)
	  {
	    setRegistryName(name);
	    setUnlocalizedName(name);
	    setCreativeTab(HFCreativeTabs.HFCrops);
	    addToBlocks(this);
	  }
	  
	  private void addToBlocks(BlockCrops block)
	  {
	    HFBlocks.blocks.add(block);
	  }
	
	
	

	

}
