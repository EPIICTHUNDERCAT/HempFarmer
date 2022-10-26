package com.shruglabs.hempfarmer;

import java.util.Random;

import com.shruglabs.hempfarmer.block.cannibis.Hemp;
import com.shruglabs.hempfarmer.block.cannibis.Indica;
import com.shruglabs.hempfarmer.block.cannibis.Sativa;
import com.shruglabs.hempfarmer.init.HFBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class HempGenDecor implements IWorldGenerator {

	public HempGenDecor() {

		GameRegistry.registerWorldGenerator(this, 50);
		MinecraftForge.TERRAIN_GEN_BUS.register(this);
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void getGenEvent(DecorateBiomeEvent.Decorate event) {
		// if (!ConfigHandler.genPlants)
		// return;
		// System.out.println("is genning");
		if ((event.getResult() == Event.Result.ALLOW || event.getResult() == Event.Result.DEFAULT)) {
			if (event.getType() == EventType.FLOWERS) {
				this.genPlantNormally(HFBlocks.hemp_crop.getDefaultState().withProperty(Hemp.AGE, 7),
						ConfigHandler.hempCropSpawnAmount, ConfigHandler.hempCropSpawn, Material.GRASS, event);

				this.genPlantNormally(HFBlocks.sativa_crop.getDefaultState().withProperty(Sativa.AGE, 7),
						ConfigHandler.sativaCropSpawnAmount, ConfigHandler.sativaCropSpawn, Material.GRASS, event);
				this.genPlantNormally(HFBlocks.indica_crop.getDefaultState().withProperty(Indica.AGE, 7),
						ConfigHandler.indicaCropSpawnAmount, ConfigHandler.indicaCropSpawn, Material.GRASS, event);
			}
		}

	}

	private void genPlantNormally(IBlockState plant, int amount, boolean doIt, Material blockBelow,
			DecorateBiomeEvent event) {
		if (doIt) {
			for (int i = 0; i < amount; i++) {
				if (event.getRand().nextInt(20) == 0) {
					BlockPos randomPos = new BlockPos(event.getPos().getX() + event.getRand().nextInt(16) + 8, 0,
							event.getPos().getZ() + event.getRand().nextInt(16) + 8);
					randomPos = event.getWorld().getTopSolidOrLiquidBlock(randomPos);

					if (event.getWorld().getBlockState(randomPos.down()).getMaterial() == blockBelow) {
						if (plant.getBlock().canPlaceBlockAt(event.getWorld(), randomPos)
								&& event.getWorld().isAirBlock(randomPos)) {
							event.getWorld().setBlockState(randomPos, plant, 2);
							// System.out.println(randomPos);
							// System.out.println("is being reached");
						}
					}
				}
			}
		}

	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
	}
}