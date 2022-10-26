package com.shruglabs.hempfarmer.init;

import java.util.ArrayList;
import java.util.List;

import com.shruglabs.hempfarmer.block.burlap.Burlap;
import com.shruglabs.hempfarmer.block.burlap.LimeBurlap;
import com.shruglabs.hempfarmer.block.burlap.OilyBurlap;
import com.shruglabs.hempfarmer.block.burlap.ResinBurlap;
import com.shruglabs.hempfarmer.block.burlap.VioletBurlap;
import com.shruglabs.hempfarmer.block.cannibis.Hemp;
import com.shruglabs.hempfarmer.block.cannibis.Indica;
import com.shruglabs.hempfarmer.block.cannibis.Sativa;
import com.shruglabs.hempfarmer.block.dirt.CoveredDirt;
import com.shruglabs.hempfarmer.block.dirt.LimeDirt;
import com.shruglabs.hempfarmer.block.dirt.OilyDirt;
import com.shruglabs.hempfarmer.block.dirt.ResinDirt;
import com.shruglabs.hempfarmer.block.dirt.VioletDirt;
import com.shruglabs.hempfarmer.block.material.HFMaterial;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class HFBlocks  {
	public static final List<Block> blocks = new ArrayList<Block>();
	public static final Block burlap = new Burlap(HFMaterial.BURLAP, "burlap");
	public static final Block violet_burlap = new VioletBurlap(HFMaterial.VIOLET_BURLAP, "violet_burlap");
	public static final Block lime_burlap = new LimeBurlap(HFMaterial.LIME_BURLAP, "lime_burlap");
	public static final Block oily_burlap = new OilyBurlap(HFMaterial.OILY_BURLAP, "oily_burlap");
	public static final Block resin_burlap = new ResinBurlap(HFMaterial.RESIN_BURLAP, "resin_burlap");
	public static final Block burlap_block = new Burlap(HFMaterial.BURLAP, "burlap_block");
	public static final Block violet_burlap_block = new VioletBurlap(HFMaterial.VIOLET_BURLAP, "violet_burlap_block");
	public static final Block lime_burlap_block = new LimeBurlap(HFMaterial.LIME_BURLAP, "lime_burlap_block");
	public static final Block oily_burlap_block = new OilyBurlap(HFMaterial.OILY_BURLAP, "oily_burlap_block");
	public static final Block resin_burlap_block = new ResinBurlap(HFMaterial.RESIN_BURLAP, "resin_burlap_block");
	public static final Block hemp_crop = new Hemp();
	public static final Block indica_crop = new Indica();
	public static final Block sativa_crop = new Sativa();
	public static final Block covered_dirt = new CoveredDirt("covered_dirt");
	public static final Block oily_dirt = new OilyDirt("oily_dirt");
	public static final Block resin_dirt = new ResinDirt("resin_dirt");
	public static final Block violet_dirt = new VioletDirt("violet_dirt");
	public static final Block lime_dirt = new LimeDirt("lime_dirt");

	public static List<Block> blockList() {
		return blocks;
	}

	

	public static void register(FMLPreInitializationEvent preEvent) {
		for (Block block : blockList()) {
			ItemBlock iBlock = new ItemBlock(block);
			if (block.getRegistryName().toString().endsWith("_crop")) {
				iBlock.setMaxStackSize(1);
			}
			ForgeRegistries.BLOCKS.register(block);
			ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}
	}

	public static void registerRender(FMLInitializationEvent event) {
		for (Block block : blockList()) {
			new Item();
			Item item = Item.getItemFromBlock(block);
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			renderItem.getItemModelMesher().register(item, 0,
					new ModelResourceLocation(block.getRegistryName().toString(), ("inventory")));
		}
	}

	public static int getIdFromBlock(Block block) {
		int id = Block.getIdFromBlock(block);
		return id;
	}
}
