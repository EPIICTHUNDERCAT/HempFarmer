package com.shruglabs.hempfarmer.block.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class HFMaterial extends Material {

	public static final HFMaterial BURLAP = (new HFMaterial(MapColor.DIRT));
	public static final HFMaterial VIOLET_BURLAP = (new HFMaterial(MapColor.PURPLE));
	public static final HFMaterial LIME_BURLAP = (new HFMaterial(MapColor.LIME));
	public static final HFMaterial OILY_BURLAP = (new HFMaterial(MapColor.YELLOW));
	public static final HFMaterial RESIN_BURLAP = (new HFMaterial(MapColor.BLACK));

	public HFMaterial(MapColor color) {
		super(color);
		this.setAdventureModeExempt();
	}

	@Override
	public boolean blocksLight() {
		return false;
	}
}
