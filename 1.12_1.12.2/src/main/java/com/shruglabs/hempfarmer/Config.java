package com.shruglabs.hempfarmer;

import com.shruglabs.hempfarmer.block.cannibis.Hemp;
import com.shruglabs.hempfarmer.block.cannibis.Indica;
import com.shruglabs.hempfarmer.block.cannibis.Sativa;
import com.shruglabs.hempfarmer.entity.EntityShotLeaf;
import com.shruglabs.hempfarmer.item.HFArmor;
import com.shruglabs.hempfarmer.item.HFOil;
import com.shruglabs.hempfarmer.item.HFWand;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {

	public static void config(FMLPreInitializationEvent preEvent) {
		HempFarmer.config = new Configuration(preEvent.getSuggestedConfigurationFile());
		EntityShotLeaf.entity = HempFarmer.config.getBoolean("Wand- Effective on Entities:", "Wand", true,
				"Wand Effective on non-player entities.");
		EntityShotLeaf.player = HempFarmer.config.getBoolean("Wand- Effective on Players:", "Wand", true,
				"Wand Effective on player entities.");
		EntityShotLeaf.block = HempFarmer.config.getBoolean("Wand- Effective on Blocks:", "Wand", true,
				"Wand Effective on blocks.");
		HFWand.leafDamage = HempFarmer.config.getInt("Wand- Leaf Wand Shots:", "Wand", 75, 1, 1000,
				"Amount of magical shots.");
		HFWand.superiorDamage = HempFarmer.config.getInt("Wand- Superior Leaf Wand Shots:", "Wand", 300, 1, 1000,
				"Amount of magical shots.");
		Hemp.seedsCropAmount = HempFarmer.config.getInt("Hemp- Seeds drop amount:", "Drops-Seeds", 1, 1, 5,
				"Amount of seeds to drop from Hemp Crop.");
		Hemp.hempAmount = HempFarmer.config.getInt("Hemp- Hemp drop amount:", "Drops-Hemp", 1, 1, 5,
				"Amount of hemp to drop from Hemp Crop.");
		Hemp.budAmount = HempFarmer.config.getInt("Hemp- Bud drop amount:", "Drops-Buds", 1, 0, 5,
				"Amount of buds to drop from Hemp Crop.");
		Indica.seedsCropAmount = HempFarmer.config.getInt("Indica- Seeds drop amount:", "Drops-Seeds", 1, 1, 5,
				"Amount of seeds to drop from Indica Crop.");
		Indica.hempAmount = HempFarmer.config.getInt("Indica- Hemp drop amount:", "Drops-Hemp", 1, 1, 5,
				"Amount of hemp to drop from Indica Crop.");
		Indica.budAmount = HempFarmer.config.getInt("Indica- Bud drop amount:", "Drops-Buds", 1, 0, 5,
				"Amount of buds to drop from Indica Crop.");
		Sativa.seedsCropAmount = HempFarmer.config.getInt("Sativa- Seeds drop amount:", "Drops-Seeds", 1, 1, 5,
				"Amount of seeds to drop from Sativa Crop.");
		Sativa.hempAmount = HempFarmer.config.getInt("Sativa- Hemp drop amount:", "Drops-Hemp", 1, 1, 5,
				"Amount of hemp to drop from Sativa Crop.");
		Sativa.budAmount = HempFarmer.config.getInt("Sativa- Bud drop amount:", "Drops-Buds", 1, 0, 5,
				"Amount of buds to drop from Sativa Crop.");
		HFOil.oilMaxStack = HempFarmer.config.getInt("Oil Bottle Max Stack:", "Oils", 1, 1, 64,
				"Maximum stack size for oil bottles.");
		HFOil.glassNeeded = HempFarmer.config.getBoolean("Glass in recipe:", "Oils", true,
				"Whether glass is needed for crafting.");
		HFArmor.particles = HempFarmer.config.getBoolean("Armor Particle effects:", "Armor", true,
				"Create particle effects for HempFarmer armors.");
		HFArmor.buffs = HempFarmer.config.getBoolean("Armor Potion effects:", "Armor", true,
				"Apply potion effects for HempFarmer armors.");
		HempFarmer.config.save();
		Config.save();

	}

	private static void save() {
		if (HempFarmer.config.hasChanged()) {
			HempFarmer.config.save();
		}

	}

}
