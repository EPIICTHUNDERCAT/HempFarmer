package com.shruglabs.hempfarmer.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class HFRecipes {
	@SubscribeEvent
	public static void FurnaceRegister(FMLPreInitializationEvent event) {

		FurnaceRecipes.instance().addSmelting(HFItems.raw_hemp, new ItemStack(HFItems.dry_hemp), 0.1F);
		FurnaceRecipes.instance().addSmelting(HFItems.violet_raw_hemp, new ItemStack(HFItems.violet_dry_hemp), 0.1F);
		FurnaceRecipes.instance().addSmelting(HFItems.hemp_oil, new ItemStack(HFItems.resin), 0.1F);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(HFBlocks.oily_burlap), new ItemStack(HFBlocks.resin_burlap),
				0.1F);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(HFBlocks.oily_burlap_block),
				new ItemStack(HFBlocks.resin_burlap_block), 0.1F);
		FurnaceRecipes.instance().addSmelting(HFItems.lime_raw_hemp, new ItemStack(HFItems.lime_dry_hemp), 0.1F);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(HFBlocks.oily_dirt), new ItemStack(HFBlocks.resin_dirt),
				0.1F);
		FurnaceRecipes.instance().addSmelting(HFItems.seeds_hemp, new ItemStack(HFItems.seeds_hemp_toasted), 0.1F);
		FurnaceRecipes.instance().addSmelting(HFItems.seeds_indica, new ItemStack(HFItems.seeds_indica_toasted), 0.1F);
		FurnaceRecipes.instance().addSmelting(HFItems.seeds_sativa, new ItemStack(HFItems.seeds_sativa_toasted), 0.1F);
	}
}