package com.shruglabs.hempfarmer.block.cannibis;

import com.shruglabs.hempfarmer.ConfigHandler;
import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFBlocks;
import com.shruglabs.hempfarmer.init.HFItems;
import com.shruglabs.hempfarmer.utils.HUtils;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Hemp extends BlockCrops {
	public static final AxisAlignedBB[] HEMP_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1328125D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.265625D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3984375D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.53125D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.6640625D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.796875D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.9296875D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0625, 1.0D) };

	private final Item[] crops;
	
	public Hemp() {
		this(HEMP_TYPE.HYBRID);
	}
	
	public Hemp(HEMP_TYPE type) {
		String name;
		this.crops = new Item[2];
		switch(type)
		{
			case INDICA:
				name = "indica_crop";
				this.crops[0] = HFItems.violet_raw_hemp;
				this.crops[1] = HFItems.indica_bud;
				break;
			case SATIVA:
				name = "sativa_crop";
				this.crops[0] = HFItems.lime_raw_hemp;
				this.crops[1] = HFItems.sativa_bud;
				break;
			default:
				name = "hemp_crop";
				crops[0] = HFItems.raw_hemp;
				crops[1] = HFItems.bud;
				break;
		}
		
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(HFCreativeTabs.HempFarmer);
		HFBlocks.blocks.add(this);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return HEMP_AABB[((Integer) state.getValue(this.getAgeProperty())).intValue()];
	}

	@Override
	protected Item getSeed() {
		return HFItems.seeds_hemp;
	}

	@Override
	protected Item getCrop() {
		return crops[HUtils.random.nextInt(2)];
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		int i;
		
		if (getAge(state) >= getMaxAge()) {
			Item crop = getCrop();
			int s;
			if(crop == HFItems.raw_hemp)
			{
				i = ConfigHandler.hempAmount;
				s = ConfigHandler.hempSeedsCropAmount;
			}
			else if(crop == HFItems.bud)
			{
				i = ConfigHandler.hempBudAmount;
				s = ConfigHandler.hempSeedsCropAmount;
			}
			else if(crop == HFItems.lime_raw_hemp)
			{
				i = ConfigHandler.sativaAmount;
				s = ConfigHandler.sativaSeedsCropAmount;
			}
			else if(crop == HFItems.sativa_bud)
			{
				i = ConfigHandler.sativaBudAmount;
				s = ConfigHandler.sativaSeedsCropAmount;
			}
			else if(crop == HFItems.violet_raw_hemp)
			{
				i = ConfigHandler.indicaAmount;
				s = ConfigHandler.indicaSeedsCropAmount;
			}
			else
			{
				i = ConfigHandler.indicaBudAmount;
				s = ConfigHandler.indicaSeedsCropAmount;
			}
			
			i = HUtils.random.nextInt(i + 1);
			if (i > 0)
				drops.add(new ItemStack(crop, i));
			
			i = HUtils.random.nextInt(s + 1);
			if(i > 0)
				drops.add(new ItemStack(getSeed(), i));
		}
		
		if (ConfigHandler.enableWand && HUtils.random.nextInt(100) > 75)
			drops.add(new ItemStack(HFItems.leaf, HUtils.random.nextInt(2) + 1));
	}
}
