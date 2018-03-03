package com.shruglabs.hempfarmer;

import net.minecraftforge.common.config.Config;

@Config(modid = Reference.ID, category = "options")
@Config.LangKey(Reference.ID + ".config.title")

public class ConfigHandler {
	

	@Config.Comment("Amount Leaf Does [Default: 75]")
	public static int leafDamage = 75;

	@Config.Comment("Amount Superior Leaf Does [Default: 300]")
	public static int leafSuperiorDamage = 300;
	
	
	@Config.Comment("Are Armor Paticles Enabled?")
	public static boolean particles = true;
	@Config.Comment("Are Armor Buffs Enabled?")
	public static boolean buffs = true;
	@Config.Comment("Are Wands Enabled?")
	public static boolean enableWand = true;
	@Config.Comment("is Armor, Tools, Shields and more Enabled?")
	public static boolean enableToolsandWeapons = true;

	@Config.Comment("Will Wand Affect Entities?")
	public static boolean entityMutate = true;
	@Config.Comment("Will Wand Affect Players")
	public static boolean playerMutate = true;
	@Config.Comment("Will Wand Affect Blocks")
	public static boolean blockMutate = true;
	@Config.Comment("Hemp- Hemp drop amount: [Default: 1]")
	public static int hempAmount = 1;

	@Config.Comment("Hemp- Bud drop amount [Default: 1]")
	public static int hempBudAmount = 1;
	@Config.Comment("Hemp- Seeds drop amount [Default: 1]")
	public static int hempSeedsCropAmount = 1;
	
	@Config.Comment("Sativa- Hemp drop amount: [Default: 1]")
	public static int sativaAmount = 1;

	@Config.Comment("Sativa- Bud drop amount [Default: 1]")
	public static int sativaBudAmount = 1;
	@Config.Comment("Sativa- Seeds drop amount [Default: 1]")
	public static int sativaSeedsCropAmount = 1;
	@Config.Comment("Sativa- Hemp drop amount: [Default: 1]")
	public static int indicaAmount = 1;

	@Config.Comment("Sativa- Bud drop amount [Default: 1]")
	public static int indicaBudAmount = 1;
	@Config.Comment("Sativa- Seeds drop amount [Default: 1]")
	public static int indicaSeedsCropAmount = 1;
	@Config.Comment("Maximum stack size for oil bottles. [Default: 1][Max:64][Min: 1] DO NOT pass min or max!")
	public static int oilMaxStack = 1;
	@Config.Comment("Plant Generation")
	public static boolean genPlants = true;
	@Config.Comment("hemp Generation")
	public static boolean hempCropSpawn = true;
	@Config.Comment("Sativa Generation")
	public static boolean sativaCropSpawn = true;
	@Config.Comment("Indica Generation")
	public static boolean indicaCropSpawn = true;
	@Config.Comment("hemp Generation Amount [Default: 5]")
	public static int hempCropSpawnAmount = 5000;
	@Config.Comment("Sativa Generation Amount [Default: 5]")
	public static int sativaCropSpawnAmount = 5000;
	@Config.Comment("Indica Generation Amount [Default: 5]")
	public static int indicaCropSpawnAmount = 5000;
	

/*
	
		HFArmor.particles = HempFarmer.config.getBoolean("Armor Particle effects:", "Armor", true,
				"Create particle effects for HempFarmer armors.");
		HFArmor.buffs = HempFarmer.config.getBoolean("Armor Potion effects:", "Armor", true,
				"Apply potion effects for HempFarmer armors.");
		

	
*/
}
