package com.shruglabs.hempfarmer.item.joint;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class SativaJoint extends Joint {

	public SativaJoint(String name, int maxStack) {
		super(name, maxStack);
	
	}

	@Override
	@Nullable
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entity) {
		stack.shrink(1);
		entity.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 400, 1, true, false));
		entity.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 400, 2, true, false));
		entity.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 100, 3, true, false));
		entity.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 100, 2, true, false));
		entity.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 150, 1, true, false));
		entity.addPotionEffect(new PotionEffect(Potion.getPotionById(24), 400, 2, true, false));

		smoke(entity, world);
		return stack;
	}

}
