package com.shruglabs.hempfarmer.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

public class HFOreDictionary extends OreDictionary {

	public static void init(FMLInitializationEvent event) {

		// crop
		registerOre("cropHemp", new ItemStack(HFItems.raw_hemp));
		registerOre("cropHemp", new ItemStack(HFItems.violet_raw_hemp));
		registerOre("cropHemp", new ItemStack(HFItems.lime_raw_hemp));
		registerOre("cropBud", new ItemStack(HFItems.bud));
		registerOre("cropBud", new ItemStack(HFItems.indica_bud));
		registerOre("cropBud", new ItemStack(HFItems.sativa_bud));

		// dry hemp
		registerOre("dryHemp", new ItemStack(HFItems.dry_hemp));
		registerOre("dryHemp", new ItemStack(HFItems.violet_dry_hemp));
		registerOre("dryHemp", new ItemStack(HFItems.lime_dry_hemp));

		// dirt
		registerOre("dirt", new ItemStack(HFBlocks.oily_dirt));
		registerOre("dirt", new ItemStack(HFBlocks.resin_dirt));
		registerOre("dirt", new ItemStack(HFBlocks.violet_dirt));
		registerOre("dirt", new ItemStack(HFBlocks.lime_dirt));
		registerOre("dirt", new ItemStack(Blocks.DIRT));

		// burlap
		registerOre("bulap", new ItemStack(HFBlocks.burlap));
		registerOre("bulap", new ItemStack(HFBlocks.oily_burlap));
		registerOre("bulap", new ItemStack(HFBlocks.resin_burlap));
		registerOre("bulap", new ItemStack(HFBlocks.violet_burlap));
		registerOre("bulap", new ItemStack(HFBlocks.lime_burlap));
		registerOre("bulap", new ItemStack(HFBlocks.burlap_block));
		registerOre("bulap", new ItemStack(HFBlocks.oily_burlap_block));
		registerOre("bulap", new ItemStack(HFBlocks.resin_burlap_block));
		registerOre("bulap", new ItemStack(HFBlocks.violet_burlap_block));
		registerOre("bulap", new ItemStack(HFBlocks.lime_burlap_block));

		// misc
		registerOre("paper", new ItemStack(HFItems.hemp_paper));
		registerOre("listAllmilk",new ItemStack(HFItems.hemp_milk_bucket));
		registerOre("bucketMilk", new ItemStack(HFItems.hemp_milk_bucket));
		registerOre("bucketMilk", new ItemStack(Items.MILK_BUCKET));
		registerOre("hempseedsCrushed", new ItemStack(HFItems.seeds_hemp_crushed));
		registerOre("hempseedsCrushed", new ItemStack(HFItems.seeds_indica_crushed));
		registerOre("hempseedsCrushed", new ItemStack(HFItems.seeds_sativa_crushed));
	}

}
