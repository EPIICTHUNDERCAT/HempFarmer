package com.shruglabs.hempfarmer.proxy;

import com.shruglabs.hempfarmer.HempFarmer;
import com.shruglabs.hempfarmer.HempGenDecor;
import com.shruglabs.hempfarmer.entity.EntityShotLeaf;
import com.shruglabs.hempfarmer.init.HFBlocks;
import com.shruglabs.hempfarmer.init.HFItems;
import com.shruglabs.hempfarmer.init.HFOreDictionary;
import com.shruglabs.hempfarmer.init.HFRecipes;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preEvent) {
		MinecraftForge.EVENT_BUS.register(HempFarmer.instance);

	//		ConfigHandler.config(preEvent);
		
		  HFRecipes.FurnaceRegister(preEvent);
		HFBlocks.register(preEvent);
		HFItems.register(preEvent);
		registerEntities(preEvent);

	}

	public void init(FMLInitializationEvent event) {
		HFOreDictionary.init(event);
		registerRender(event);
		MinecraftForge.EVENT_BUS.register(new HempGenDecor());
	//	GameRegistry.registerWorldGenerator(new HempGen(), 2);
	}

	public void registerRender(FMLInitializationEvent event) {
	}

	public void registerEntities(FMLPreInitializationEvent preEvent) {
		int id = 0;
		EntityRegistry.registerModEntity(new ResourceLocation(
				"hempfarmer:textures/entity/shot_leaf.png"), EntityShotLeaf.class, "shotLeaf", id++, HempFarmer.instance, 64, 2, true, id, id);
	}

}
