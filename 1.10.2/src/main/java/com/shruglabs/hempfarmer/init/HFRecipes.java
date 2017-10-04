package com.shruglabs.hempfarmer.init;

import com.shruglabs.hempfarmer.item.HFOil;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class HFRecipes {

	public static void registerRecipes(FMLPreInitializationEvent preEvent) {
		//Repair Wand //- Crafting Recipe
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFItems.superior_leaf_wand), new Object[]{new ItemStack(HFItems.broken_superior_leaf_wand), new ItemStack(HFItems.resin
				)}));	
		
		//Cake //- Crafting Recipe
		GameRegistry.addRecipe(
				new ShapedOreRecipe(new ItemStack(Items.CAKE),
				new Object[] {"mmm", "ses", "www", 'm', "listAllmilk", 'w', new ItemStack(Items.WHEAT), 's', new ItemStack(Items.SUGAR), 'e', new ItemStack(Items.EGG)}));
		// Dried Hemp//- Smelting Recipe
		GameRegistry.addSmelting(new ItemStack(HFItems.raw_hemp), new ItemStack(HFItems.dry_hemp), 0.1F);
		// Lime Dried Hemp//- Smelting Recipe
		GameRegistry.addSmelting(new ItemStack(HFItems.lime_raw_hemp), new ItemStack(HFItems.lime_dry_hemp), 0.1F);
		// Violet Dried Hemp//- Smelting Recipe
		GameRegistry.addSmelting(new ItemStack(HFItems.violet_raw_hemp), new ItemStack(HFItems.violet_dry_hemp), 0.1F);
		// Hemp Resin//- Smelting Recipe
		GameRegistry.addSmelting(new ItemStack(HFItems.hemp_oil), new ItemStack(HFItems.resin), 0.1F);
		// Hemp Paper//- Shapeless recipe
		GameRegistry.addRecipe(
				new ShapelessOreRecipe(new ItemStack(HFItems.hemp_paper), new Object[] { "dryHemp", "dryHemp" }));
		// Resin Burlap//- Smelting Recipe
		GameRegistry.addSmelting(new ItemStack(HFBlocks.oily_burlap), new ItemStack(HFBlocks.resin_burlap), 0.1F);
		// Resin Burlap Block//- Smelting Recipe
		GameRegistry.addSmelting(new ItemStack(HFBlocks.oily_burlap_block), new ItemStack(HFBlocks.resin_burlap_block),
				0.1F);
		// Resin Burlap Block//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFBlocks.resin_burlap_block), "hh", "hh", 'h',
				new ItemStack(HFBlocks.resin_burlap));
		// Oily Burlap//- Shapeless Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(HFBlocks.oily_burlap), new ItemStack(HFBlocks.burlap),
				new ItemStack(HFItems.hemp_oil));
		// Oily Burlap Block//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFBlocks.oily_burlap_block), "hh", "hh", 'h',
				new ItemStack(HFBlocks.oily_burlap));
		// Burlap//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFBlocks.burlap), "hh", "hh", 'h', new ItemStack(HFItems.dry_hemp));
		// Burlap Block//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFBlocks.burlap_block), "hh", "hh", 'h', new ItemStack(HFBlocks.burlap));
		// LimeBurlap//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFBlocks.lime_burlap), "hh", "hh", 'h',
				new ItemStack(HFItems.lime_dry_hemp));
		// Lime Burlap Block//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFBlocks.lime_burlap_block), "hh", "hh", 'h',
				new ItemStack(HFBlocks.lime_burlap));

		// VioletBurlap//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFBlocks.violet_burlap), "hh", "hh", 'h',
				new ItemStack(HFItems.violet_dry_hemp));
		// Violet Burlap Block//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFBlocks.violet_burlap_block), "hh", "hh", 'h',
				new ItemStack(HFBlocks.violet_burlap));
		// Vanilla Lead//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(Items.LEAD), "ss ", "sr ", "  s", 'r', new ItemStack(HFItems.resin), 's',
				new ItemStack(Items.STRING));
		GameRegistry.addRecipe(new ItemStack(Items.LEAD), "hh ", "hr ", "  h", 'r', new ItemStack(HFItems.resin), 'h',
				new ItemStack(HFItems.dry_hemp));
		GameRegistry.addRecipe(new ItemStack(Items.LEAD), "hh ", "hs ", "  h", 's', new ItemStack(Items.SLIME_BALL),
				'h', new ItemStack(HFItems.dry_hemp));
		if(HFOil.glassNeeded){
			// Hemp Oil//- Shaped Recipe
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HFItems.hemp_oil),
					new Object[] { "sss", "gsg", " g ", 'g', "blockGlass", 's', new ItemStack(HFItems.seeds_hemp) }));
			// Lime Oil//- Shaped Recipe
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HFItems.lime_oil),
					new Object[] { "sss", "gsg", " g ", 'g', "blockGlass", 's', new ItemStack(HFItems.seeds_sativa) }));
			// Violet Oil//- Shaped Recipe
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HFItems.violet_oil),
					new Object[] { "sss", "gsg", " g ", 'g', "blockGlass", 's', new ItemStack(HFItems.seeds_indica) }));

		}else{
			// Hemp Oil//- Shaped Recipe
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HFItems.hemp_oil),
					new Object[] { "sss", " s ", "  ", 's', new ItemStack(HFItems.seeds_hemp) }));
			// Lime Oil//- Shaped Recipe
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HFItems.lime_oil),
					new Object[] { "sss", " s ", "   ", 's', new ItemStack(HFItems.seeds_sativa) }));
			// Violet Oil//- Shaped Recipe
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HFItems.violet_oil),
					new Object[] { "sss", " s ", "   ", 's', new ItemStack(HFItems.seeds_indica) }));

		}
		
		// Burlap Armor//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFItems.burlap_boots), "   ", "b b", "b b", 'b',
				new ItemStack(HFBlocks.burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.burlap_leggings), "bbb", "b b", "b b", 'b',
				new ItemStack(HFBlocks.burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.burlap_chestplate), "b b", "bbb", "bbb", 'b',
				new ItemStack(HFBlocks.burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.burlap_helmet), "bbb", "b b", "   ", 'b',
				new ItemStack(HFBlocks.burlap));
		// LimeBurlap Armor//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFItems.lime_burlap_boots), "   ", "b b", "b b", 'b',
				new ItemStack(HFBlocks.lime_burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.lime_burlap_leggings), "bbb", "b b", "b b", 'b',
				new ItemStack(HFBlocks.lime_burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.lime_burlap_chestplate), "b b", "bbb", "bbb", 'b',
				new ItemStack(HFBlocks.lime_burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.lime_burlap_helmet), "bbb", "b b", "   ", 'b',
				new ItemStack(HFBlocks.lime_burlap));
		// VioletBurlap Armor//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFItems.violet_burlap_boots), "   ", "b b", "b b", 'b',
				new ItemStack(HFBlocks.violet_burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.violet_burlap_leggings), "bbb", "b b", "b b", 'b',
				new ItemStack(HFBlocks.violet_burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.violet_burlap_chestplate), "b b", "bbb", "bbb", 'b',
				new ItemStack(HFBlocks.violet_burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.violet_burlap_helmet), "bbb", "b b", "   ", 'b',
				new ItemStack(HFBlocks.violet_burlap));
		// Resin Armor//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFItems.resin_boots), "   ", "r r", "r r", 'r',
				new ItemStack(HFItems.resin));
		GameRegistry.addRecipe(new ItemStack(HFItems.resin_leggings), "rrr", "r r", "r r", 'r',
				new ItemStack(HFItems.resin));
		GameRegistry.addRecipe(new ItemStack(HFItems.resin_chestplate), "r r", "rrr", "rrr", 'r',
				new ItemStack(HFItems.resin));
		GameRegistry.addRecipe(new ItemStack(HFItems.resin_helmet), "rrr", "r r", "   ", 'r',
				new ItemStack(HFItems.resin));
		// ResinBurlap Armor//- Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(HFItems.resin_burlap_boots), "   ", "b b", "b b", 'b',
				new ItemStack(HFBlocks.resin_burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.resin_burlap_leggings), "bbb", "b b", "b b", 'b',
				new ItemStack(HFBlocks.resin_burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.resin_burlap_chestplate), "b b", "bbb", "bbb", 'b',
				new ItemStack(HFBlocks.resin_burlap));
		GameRegistry.addRecipe(new ItemStack(HFItems.resin_burlap_helmet), "bbb", "b b", "   ", 'b',
				new ItemStack(HFBlocks.resin_burlap));
		// Resin Sword//- Shaped Recipe
		GameRegistry.addRecipe(new ItemStack(HFItems.resin_sword), " r ", " r ", " s ", 'r',
				new ItemStack(HFItems.resin), 's', new ItemStack(Items.STICK));
		// Resin Shield//- Shaped Recipe
		GameRegistry.addRecipe(new ItemStack(HFItems.resin_shield), "rrr", "rrr", " r ", 'r',
				new ItemStack(HFItems.resin));
		// Seedlings//- Shapeless Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(HFBlocks.hemp_crop), new ItemStack(HFItems.seeds_hemp));
		GameRegistry.addShapelessRecipe(new ItemStack(HFBlocks.indica_crop), new ItemStack(HFItems.seeds_indica));
		GameRegistry.addShapelessRecipe(new ItemStack(HFBlocks.sativa_crop), new ItemStack(HFItems.seeds_sativa));
		// Leaf Wand//- Shaped recipe
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HFItems.leaf_wand),
				new Object[] { " l", "s ", 'l', new ItemStack(HFItems.leaf), 's', "stickWood" }));
		// Superior Leaf Wand//- Shaped recipe
		GameRegistry.addRecipe(new ItemStack(HFItems.superior_leaf_wand), " l", "r ", 'l', new ItemStack(HFItems.leaf),
				'r', new ItemStack(HFItems.resin));
		// Oily Dirt//- Shapeless Recipe
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFBlocks.oily_dirt),
				new Object[] { "dirt", new ItemStack(HFItems.hemp_oil) }));
		// Violet Dirt//- Shapeless Recipe
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFBlocks.violet_dirt),
				new Object[] { "dirt", new ItemStack(HFItems.violet_oil) }));
		// Lime Dirt//- Shapeless Recipe
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFBlocks.lime_dirt),
				new Object[] { "dirt", new ItemStack(HFItems.lime_oil) }));
		// Resin Dirt//- Smelting Recipe
		GameRegistry.addSmelting(new ItemStack(HFBlocks.oily_dirt), new ItemStack(HFBlocks.resin_dirt), 0.1F);
		// Pot Brownies//- Shapeless Recipe
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFItems.pot_brownie),
				new Object[] { new ItemStack(Items.EGG), new ItemStack(Items.SUGAR), "milkBucket",
						new ItemStack(Items.DYE, 1, 3), new ItemStack(HFItems.bud), new ItemStack(HFItems.indica_bud),
						new ItemStack(HFItems.sativa_bud) }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFItems.pot_brownie),
				new Object[] { new ItemStack(Items.EGG), new ItemStack(Items.SUGAR), "listAllmilk",
						new ItemStack(Items.DYE, 1, 3), new ItemStack(HFItems.bud), new ItemStack(HFItems.indica_bud),
						new ItemStack(HFItems.sativa_bud) }));
		// Rolling Paper//- Shapeless Recipe
		GameRegistry
				.addRecipe(new ShapelessOreRecipe(new ItemStack(HFItems.rolling_paper, 3), new Object[] { "paper" }));
		// Vanilla Paper//- Shapeless Recipe
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.PAPER),
				new Object[] { new ItemStack(HFItems.rolling_paper), new ItemStack(HFItems.rolling_paper),
						new ItemStack(HFItems.rolling_paper) }));
		// Joints//- Shapeless Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(HFItems.regs_joint), new ItemStack(HFItems.rolling_paper),
				new ItemStack(HFItems.bud), new ItemStack(HFItems.bud), new ItemStack(HFItems.bud));
		GameRegistry.addShapelessRecipe(new ItemStack(HFItems.indica_joint), new ItemStack(HFItems.rolling_paper),
				new ItemStack(HFItems.indica_bud), new ItemStack(HFItems.indica_bud),
				new ItemStack(HFItems.indica_bud));
		GameRegistry.addShapelessRecipe(new ItemStack(HFItems.sativa_joint), new ItemStack(HFItems.rolling_paper),
				new ItemStack(HFItems.sativa_bud), new ItemStack(HFItems.sativa_bud),
				new ItemStack(HFItems.sativa_bud));
		// Toasted seeds
		GameRegistry.addSmelting(new ItemStack(HFItems.seeds_hemp), new ItemStack(HFItems.seeds_hemp_toasted), 0.1F);
		GameRegistry.addSmelting(new ItemStack(HFItems.seeds_indica), new ItemStack(HFItems.seeds_indica_toasted),
				0.1F);
		GameRegistry.addSmelting(new ItemStack(HFItems.seeds_sativa), new ItemStack(HFItems.seeds_sativa_toasted),
				0.1F);
		// Crushed seeds
		GameRegistry.addShapelessRecipe(new ItemStack(HFItems.seeds_hemp_crushed),
				new ItemStack(HFItems.seeds_hemp_toasted),
				new ItemStack(Items.SHEARS, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(HFItems.seeds_indica_crushed),
				new ItemStack(HFItems.seeds_indica_toasted),
				new ItemStack(Items.SHEARS, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(HFItems.seeds_sativa_crushed),
				new ItemStack(HFItems.seeds_sativa_toasted),
				new ItemStack(Items.SHEARS, 1, OreDictionary.WILDCARD_VALUE));
		// HempMilk
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HFItems.hemp_milk_bucket),
				new Object[] { "sss", "sws", "sbs", 'b', new ItemStack(Items.BUCKET), 'w',
						new ItemStack(Items.WATER_BUCKET), 's', "hempseedsCrushed" }));
		// HempHearts
		GameRegistry.addRecipe(new ItemStack(HFItems.hemp_hearts), "h h", "hhh", " h ", 'h',
				new ItemStack(HFItems.seeds_hemp_crushed));
		GameRegistry.addRecipe(new ItemStack(HFItems.lime_hemp_hearts), "h h", "hhh", " h ", 'h',
				new ItemStack(HFItems.seeds_sativa_crushed));
		GameRegistry.addRecipe(new ItemStack(HFItems.violet_hemp_hearts), "h h", "hhh", " h ", 'h',
				new ItemStack(HFItems.seeds_indica_crushed));
		// Bowl of HH
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFItems.bowl_hemp_hearts),
				new Object[] { new ItemStack(HFItems.hemp_hearts), new ItemStack(Items.BOWL), "bucketMilk" }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFItems.bowl_lime_hemp_hearts),
				new Object[] { new ItemStack(HFItems.lime_hemp_hearts), new ItemStack(Items.BOWL), "bucketMilk" }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFItems.bowl_violet_hemp_hearts),
				new Object[] { new ItemStack(HFItems.violet_hemp_hearts), new ItemStack(Items.BOWL), "bucketMilk" }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFItems.bowl_hemp_hearts),
				new Object[] { new ItemStack(HFItems.hemp_hearts), new ItemStack(Items.BOWL), "listAllmilk" }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFItems.bowl_lime_hemp_hearts),
				new Object[] { new ItemStack(HFItems.lime_hemp_hearts), new ItemStack(Items.BOWL), "listAllmilk" }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(HFItems.bowl_violet_hemp_hearts),
				new Object[] { new ItemStack(HFItems.violet_hemp_hearts), new ItemStack(Items.BOWL), "listAllmilk" }));
	}

	/*
	 * Register Fun Ores Recipes if (Loader.isModLoaded("FunOres")) {
	 * ExternalRecipes.registerFunOres(); }
	 */

}
