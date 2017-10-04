package com.shruglabs.hempfarmer.proxy;

import com.shruglabs.hempfarmer.client.renderer.entity.RenderShotLeaf;
import com.shruglabs.hempfarmer.entity.EntityShotLeaf;
import com.shruglabs.hempfarmer.init.HFBlocks;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	public void preInit(FMLPreInitializationEvent preEvent) {
		super.preInit(preEvent);
	}
	
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	@Override
	public void register(FMLPreInitializationEvent preEvent){
		super.register(preEvent);
	}
	
	@Override
	public void registerRender(FMLInitializationEvent event) {
		HFItems.registerRender(event);
		HFBlocks.registerRender(event);
	}
	
	@Override
	public void registerEntities(FMLPreInitializationEvent preEvent) {
		super.registerEntities(preEvent);
		RenderingRegistry.registerEntityRenderingHandler(EntityShotLeaf.class, new IRenderFactory<EntityShotLeaf>() {
            @Override public RenderShotLeaf createRenderFor (RenderManager manager) {
                return new RenderShotLeaf(manager, HFItems.shot_leaf);
            }
        });
	}


	
}
