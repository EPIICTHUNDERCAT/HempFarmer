package com.shruglabs.hempfarmer.creativetab;

import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HFCreativeTabs extends CreativeTabs {
	public HFCreativeTabs(int index, String label)
	  {
	    super(index, label);
	  }
	  
	  public static final HFCreativeTabs HFCombat = new HFCreativeTabs(CreativeTabs.getNextID(), "hfcombat")
	  {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem()
	    {
	      return HFItems.resin_sword;
	    }
	  };
	  public static final HFCreativeTabs HFCrops = new HFCreativeTabs(CreativeTabs.getNextID(), "hfcrops")
	  {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem()
	    {
	      return HFItems.leaf;
	    }
	  };
	  public static final HFCreativeTabs HFMisc = new HFCreativeTabs(CreativeTabs.getNextID(), "hfmisc")
	  {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem()
	    {
	      return HFItems.hemp_oil;
	    }
	  };
	  public static final HFCreativeTabs HFDrugs = new HFCreativeTabs(CreativeTabs.getNextID(), "hfdrugs")
	  {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem()
	    {
	      return HFItems.regs_joint;
	    }
	  };
	  public static final HFCreativeTabs HFFoods = new HFCreativeTabs(CreativeTabs.getNextID(), "hffoods")
	  {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem()
	    {
	      return HFItems.bowl_hemp_hearts;
	    }
	  };
	  
	  public Item getTabIconItem()
	  {
	    return null;
	  }

}
