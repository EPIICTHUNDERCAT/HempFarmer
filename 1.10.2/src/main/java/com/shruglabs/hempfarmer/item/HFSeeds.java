package com.shruglabs.hempfarmer.item;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.MinecraftForge;

public class HFSeeds extends ItemSeeds implements net.minecraftforge.common.IPlantable{

	 private Block crops;
	  
	  public HFSeeds(String name, Block crop, int weight)
	  {
	    super(crop, Blocks.FARMLAND);
	    this.crops = crop;
	    setRegistryName(name);
	    setUnlocalizedName(name);
	    setCreativeTab(HFCreativeTabs.HFCrops);
	    register(this, weight);
	    addToItems(this);
	  }
	  
	  private void addToItems(Item item)
	  {
	    HFItems.items.add(item);
	  }
	  
	  private void register(HFSeeds seeds, int weight)
	  {
	    MinecraftForge.addGrassSeed(new ItemStack(seeds), weight);
	  }
	  
	  public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	  {
	    IBlockState state = worldIn.getBlockState(pos);
	    if ((facing == EnumFacing.UP) && (playerIn.canPlayerEdit(pos.offset(facing), facing, stack)) && (state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this)) && (worldIn.isAirBlock(pos.up())))
	    {
	      worldIn.setBlockState(pos.up(), this.crops.getDefaultState());
	      stack.stackSize -= 1;
	      return EnumActionResult.SUCCESS;
	    }
	    return EnumActionResult.FAIL;
	  }
	  
	  public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
	  {
	    return EnumPlantType.Crop;
	  }
	  
	  public IBlockState getPlant(IBlockAccess world, BlockPos pos)
	  {
	    return this.crops.getDefaultState();
	  }
}
	

