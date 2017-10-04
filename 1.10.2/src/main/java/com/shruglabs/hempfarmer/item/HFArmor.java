package com.shruglabs.hempfarmer.item;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class HFArmor extends ItemArmor {

	public static boolean particles;
	public static boolean buffs;

	public static ArmorMaterial BURLAP = EnumHelper.addArmorMaterial("BURLAP", "hempfarmer:burlap", 7,
			new int[] { 1, 2, 3, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static ArmorMaterial LIME_BURLAP = EnumHelper.addArmorMaterial("LIME_BURLAP", "hempfarmer:lime_burlap", 7,
			new int[] { 1, 2, 3, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static ArmorMaterial VIOLET_BURLAP = EnumHelper.addArmorMaterial("VIOLET_BURLAP", "hempfarmer:violet_burlap",
			7, new int[] { 1, 2, 3, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static ArmorMaterial RESIN_BURLAP = EnumHelper.addArmorMaterial("RESIN_BURLAP", "hempfarmer:resin_burlap", 7,
			new int[] { 3, 4, 5, 3 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static ArmorMaterial RESIN = EnumHelper.addArmorMaterial("RESIN", "hempfarmer:resin", 7,
			new int[] { 2, 3, 4, 2 }, 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

	public HFArmor(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType) {
		super(material, renderIndex, armorType);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(HFCreativeTabs.HFCombat);
		addToItems(this);
	}

	private void addToItems(Item item) {
		HFItems.items.add(item);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (world.getWorldTime() % 5 == 0) {
			if (HFArmor.particles)
				updateParticles(world, player, this.getArmorMaterial());
		}
		if (world.getWorldTime() % 3 == 0) {
			if (HFArmor.buffs)
				updateBuffs(world, player, this.getArmorMaterial());
		}

	}

	private void updateBuffs(World world, EntityPlayer player, ArmorMaterial material) {
		if (!world.isRemote) {
			if (material.equals(BURLAP)) {
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 1));
			}
			if (material.equals(LIME_BURLAP)) {
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 1));
			}
			if (material.equals(VIOLET_BURLAP)) {
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 1));
			}
			if (material.equals(RESIN_BURLAP)) {
				if (!player.isPotionActive(Potion.getPotionById(8)))
					player.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 3, 1, false, false));
				if (!player.isPotionActive(Potion.getPotionById(11)))
					player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 3, 3, false, false));
			}
			if (material.equals(RESIN)) {

			}

		}

	}

	private void updateParticles(World world, EntityPlayer player, ArmorMaterial material) {
		if (material.equals(BURLAP)) {

		}
		if (material.equals(LIME_BURLAP)) {
			world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + world.rand.nextDouble(),
					player.posY + (world.rand.nextDouble() * 2), player.posZ + world.rand.nextDouble(), 0.30, 0.59,
					0.0);
		}
		if (material.equals(VIOLET_BURLAP)) {
			world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + world.rand.nextDouble(),
					player.posY + (world.rand.nextDouble() * 2), player.posZ + world.rand.nextDouble(), 0.0, 0.59,
					0.79);
		}
		if (material.equals(RESIN_BURLAP)) {
			world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + world.rand.nextDouble(),
					player.posY + (world.rand.nextDouble() * 2), player.posZ + world.rand.nextDouble(), 0.1, 0.1, 0.1);
		}
		if (material.equals(RESIN)) {
			world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + world.rand.nextDouble(),
					player.posY + (world.rand.nextDouble() * 2), player.posZ + world.rand.nextDouble(), 0.19, 0.29,
					0.0);

		}

	}
}
