/**
 *  HempFarmer - Adds hemp and marijuana to Minecraft.
    Copyright (C) <2016>  <SeqSEE>

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package com.shruglabs.hempfarmer;

import com.shruglabs.hempfarmer.init.HFItems;
import com.shruglabs.hempfarmer.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

@Mod(updateJSON = Reference.UPDATE, modid = Reference.ID, name = Reference.NAME, version = Reference.VER)
public class HempFarmer {
	public static Configuration config;
	@Instance(value = "hempfarmer")
	public static HempFarmer instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	private static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent) {
		proxy.preInit(preEvent);
	}

	@EventHandler
	private void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onItemCraft(ItemCraftedEvent event) {
		Item item = event.crafting.getItem();
		if (item == HFItems.seeds_hemp_crushed || item == HFItems.seeds_indica_crushed
				|| item == HFItems.seeds_sativa_crushed) {
			for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
				if (event.craftMatrix.getStackInSlot(i) != null) {
					ItemStack stack = event.craftMatrix.getStackInSlot(i);
					if (stack.getItem() instanceof ItemShears) {
						if (stack.getItemDamage() < stack.getMaxDamage()) {
							stack.shrink(1);
							stack.setItemDamage(stack.getItemDamage() + 1);
							event.craftMatrix.setInventorySlotContents(i, stack);
						}
					}
				}
			}
		}
		

	}
}
