package com.shruglabs.hempfarmer.init;

import java.util.ArrayList;
import java.util.List;

import com.shruglabs.hempfarmer.item.HFArmor;
import com.shruglabs.hempfarmer.item.HFDrug;
import com.shruglabs.hempfarmer.item.HFEntityItem;
import com.shruglabs.hempfarmer.item.HFItem;
import com.shruglabs.hempfarmer.item.HFOil;
import com.shruglabs.hempfarmer.item.HFResinShield;
import com.shruglabs.hempfarmer.item.HFSeeds;
import com.shruglabs.hempfarmer.item.HFSword;
import com.shruglabs.hempfarmer.item.HFWand;
import com.shruglabs.hempfarmer.item.edibles.HempFood;
import com.shruglabs.hempfarmer.item.edibles.HempMilkBucket;
import com.shruglabs.hempfarmer.item.edibles.PotBrownie;
import com.shruglabs.hempfarmer.item.joint.IndicaJoint;
import com.shruglabs.hempfarmer.item.joint.Joint;
import com.shruglabs.hempfarmer.item.joint.SativaJoint;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class HFItems  {
	public static List<Item> items = new ArrayList<Item>();
	public static Item shot_leaf = new HFEntityItem("shot_leaf");
	public static Item regs_joint = new Joint("regs_joint", 5);
	public static Item indica_joint = new IndicaJoint("indica_joint", 5);
	public static Item sativa_joint = new SativaJoint("sativa_joint", 5);
	public static Item pot_brownie = new PotBrownie("pot_brownie");
	public static Item leaf = new HFItem("leaf", 64);
	public static Item leaf_wand = new HFWand("leaf_wand");
	public static Item superior_leaf_wand = new HFWand("superior_leaf_wand");
	public static Item bud = new HFDrug("bud", 64);
	public static Item indica_bud = new HFDrug("indica_bud", 64);
	public static Item sativa_bud = new HFDrug("sativa_bud", 64);
	public static Item rolling_paper = new HFDrug("rolling_paper", 24);
	public static Item raw_hemp = new HFItem("raw_hemp", 64);
	public static Item lime_raw_hemp = new HFItem("lime_raw_hemp", 64);
	public static Item violet_raw_hemp = new HFItem("violet_raw_hemp", 64);
	public static Item dry_hemp = new HFItem("dry_hemp", 64);
	public static Item lime_dry_hemp = new HFItem("lime_dry_hemp", 64);
	public static Item violet_dry_hemp = new HFItem("violet_dry_hemp", 64);
	public static Item hemp_oil = new HFOil("hemp_oil");
	public static Item violet_oil = new HFOil("violet_oil");
	public static Item lime_oil = new HFOil("lime_oil");
	public static Item resin = new HFItem("resin", 64);
	public static Item seeds_hemp = new HFSeeds("seeds_hemp", HFBlocks.hemp_crop);
	public static Item seeds_indica = new HFSeeds("seeds_indica", HFBlocks.indica_crop);
	public static Item seeds_sativa = new HFSeeds("seeds_sativa", HFBlocks.sativa_crop);
	public static Item burlap_boots = new HFArmor("burlap_boots", HFArmor.BURLAP, 1, EntityEquipmentSlot.FEET);
	public static Item burlap_leggings = new HFArmor("burlap_leggings", HFArmor.BURLAP, 1, EntityEquipmentSlot.LEGS);
	public static Item burlap_chestplate = new HFArmor("burlap_chestplate", HFArmor.BURLAP, 1,
			EntityEquipmentSlot.CHEST);
	public static Item burlap_helmet = new HFArmor("burlap_helmet", HFArmor.BURLAP, 1, EntityEquipmentSlot.HEAD);
	public static Item lime_burlap_boots = new HFArmor("lime_burlap_boots", HFArmor.LIME_BURLAP, 1,
			EntityEquipmentSlot.FEET);
	public static Item lime_burlap_leggings = new HFArmor("lime_burlap_leggings", HFArmor.LIME_BURLAP, 1,
			EntityEquipmentSlot.LEGS);
	public static Item lime_burlap_chestplate = new HFArmor("lime_burlap_chestplate", HFArmor.LIME_BURLAP, 1,
			EntityEquipmentSlot.CHEST);
	public static Item lime_burlap_helmet = new HFArmor("lime_burlap_helmet", HFArmor.LIME_BURLAP, 1,
			EntityEquipmentSlot.HEAD);
	public static Item violet_burlap_boots = new HFArmor("violet_burlap_boots", HFArmor.VIOLET_BURLAP, 1,
			EntityEquipmentSlot.FEET);
	public static Item violet_burlap_leggings = new HFArmor("violet_burlap_leggings", HFArmor.VIOLET_BURLAP, 1,
			EntityEquipmentSlot.LEGS);
	public static Item violet_burlap_chestplate = new HFArmor("violet_burlap_chestplate", HFArmor.VIOLET_BURLAP, 1,
			EntityEquipmentSlot.CHEST);
	public static Item violet_burlap_helmet = new HFArmor("violet_burlap_helmet", HFArmor.VIOLET_BURLAP, 1,
			EntityEquipmentSlot.HEAD);
	public static Item resin_burlap_boots = new HFArmor("resin_burlap_boots", HFArmor.RESIN_BURLAP, 1,
			EntityEquipmentSlot.FEET);
	public static Item resin_burlap_leggings = new HFArmor("resin_burlap_leggings", HFArmor.RESIN_BURLAP, 1,
			EntityEquipmentSlot.LEGS);
	public static Item resin_burlap_chestplate = new HFArmor("resin_burlap_chestplate", HFArmor.RESIN_BURLAP, 1,
			EntityEquipmentSlot.CHEST);
	public static Item resin_burlap_helmet = new HFArmor("resin_burlap_helmet", HFArmor.RESIN_BURLAP, 1,
			EntityEquipmentSlot.HEAD);
	public static Item resin_boots = new HFArmor("resin_boots", HFArmor.RESIN, 1, EntityEquipmentSlot.FEET);
	public static Item resin_leggings = new HFArmor("resin_leggings", HFArmor.RESIN, 1, EntityEquipmentSlot.LEGS);
	public static Item resin_chestplate = new HFArmor("resin_chestplate", HFArmor.RESIN, 1, EntityEquipmentSlot.CHEST);
	public static Item resin_helmet = new HFArmor("resin_helmet", HFArmor.RESIN, 1, EntityEquipmentSlot.HEAD);
	public static Item resin_shield = new HFResinShield("resin_shield");
	public static Item resin_sword = new HFSword("resin_sword", HFSword.RESIN, resin);
	public static Item hemp_paper = new HFItem("hemp_paper", 64);
	public static Item hemp_milk_bucket = new HempMilkBucket("hemp_milk_bucket", 1);
	public static Item hemp_hearts = new HempFood("hemp_hearts", 2, 2.0F);
	public static Item lime_hemp_hearts = new HempFood("lime_hemp_hearts", 2, 2.5F);
	public static Item violet_hemp_hearts = new HempFood("violet_hemp_hearts", 2, 2.5F);
	public static Item bowl_hemp_hearts = new HempFood("bowl_hemp_hearts", 4, 4.0F);
	public static Item bowl_violet_hemp_hearts = new HempFood("bowl_violet_hemp_hearts", 5, 5.0F);
	public static Item bowl_lime_hemp_hearts = new HempFood("bowl_lime_hemp_hearts", 5, 5.0F);
	public static Item seeds_hemp_toasted = new HFItem("seeds_hemp_toasted", 64);
	public static Item seeds_hemp_crushed = new HempFood("seeds_hemp_crushed", 1, 0.5F);
	public static Item seeds_indica_toasted = new HFItem("seeds_indica_toasted", 64);
	public static Item seeds_indica_crushed = new HempFood("seeds_indica_crushed", 1, 0.5F);
	public static Item seeds_sativa_toasted = new HFItem("seeds_sativa_toasted", 64);
	public static Item seeds_sativa_crushed = new HempFood("seeds_sativa_crushed", 1, 0.5F);
	public static Item broken_superior_leaf_wand = new HFItem("broken_superior_leaf_wand", 1);
	

	public static List<Item> itemList() {
		return items;
	}

	public static void register(FMLPreInitializationEvent preEvent) {
		for (Item item : itemList()) {
			GameRegistry.register(item);
		}
	}

	public static void registerRender(FMLInitializationEvent event) {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		for (Item item : itemList()) {
			renderItem.getItemModelMesher().register(item, 0,
					new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
		}
	}
}
