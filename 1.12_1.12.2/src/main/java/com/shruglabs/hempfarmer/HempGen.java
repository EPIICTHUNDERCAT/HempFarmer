package com.shruglabs.hempfarmer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.shruglabs.hempfarmer.block.HFBlockCrops;
import com.shruglabs.hempfarmer.init.HFBlocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraftforge.fml.common.IWorldGenerator;

public class HempGen implements IWorldGenerator {

	private WorldGenBush hemp;
	private WorldGenBush indica;
	private WorldGenBush sativa;

	public HempGen() {
		this.hemp = new WorldGenBush((HFBlockCrops) HFBlocks.hemp_crop) {
			private List<Biome> biomes = new ArrayList<Biome>();
			private boolean initialized;

			public void addBiomes() {
				this.biomes.add(Biomes.JUNGLE);
				this.biomes.add(Biomes.JUNGLE_EDGE);
				this.biomes.add(Biomes.JUNGLE_HILLS);
				this.biomes.add(Biomes.MUTATED_JUNGLE);
				this.biomes.add(Biomes.MUTATED_JUNGLE_EDGE);
				this.biomes.add(Biomes.FOREST);
				this.biomes.add(Biomes.FOREST_HILLS);
				this.biomes.add(Biomes.MUTATED_FOREST);
				this.biomes.add(Biomes.BIRCH_FOREST);
				this.biomes.add(Biomes.BIRCH_FOREST_HILLS);
				this.biomes.add(Biomes.MUTATED_BIRCH_FOREST);
				this.biomes.add(Biomes.MUTATED_BIRCH_FOREST_HILLS);
				this.biomes.add(Biomes.ROOFED_FOREST);
				this.biomes.add(Biomes.MUTATED_ROOFED_FOREST);
				this.biomes.add(Biomes.MUTATED_PLAINS);
				this.biomes.add(Biomes.PLAINS);
				this.biomes.add(Biomes.REDWOOD_TAIGA);
				this.biomes.add(Biomes.REDWOOD_TAIGA_HILLS);
				this.biomes.add(Biomes.MUTATED_REDWOOD_TAIGA);
				this.biomes.add(Biomes.MUTATED_REDWOOD_TAIGA_HILLS);
				this.biomes.add(Biomes.SWAMPLAND);
				this.biomes.add(Biomes.MUTATED_SWAMPLAND);
				this.initialized = true;

			}

			@Override
			public boolean generate(World worldIn, Random rand, BlockPos position) {
				if (!this.initialized) {
					this.addBiomes();
				}
				for (int i = 0; i < 32; ++i) {

					BlockPos blockpos = position.add(rand.nextInt(4) - rand.nextInt(4),
							rand.nextInt(4) - rand.nextInt(4), rand.nextInt(4) - rand.nextInt(8));
					Biome biome = worldIn.getBiomeForCoordsBody(blockpos);
					if (biome.getTempCategory() == Biome.TempCategory.WARM || biome.getTempCategory() == Biome.TempCategory.MEDIUM
							 || this.biomes.contains(biome)) {
						if (worldIn.isAirBlock(blockpos)
								&& (!worldIn.provider.hasNoSky() || blockpos.getY() < worldIn.getHeight() - 1)
								&& ((BlockCrops) HFBlocks.hemp_crop).canBlockStay(worldIn, blockpos,
										HFBlocks.hemp_crop.getDefaultState())) {
							worldIn.setBlockState(blockpos, HFBlocks.hemp_crop.getDefaultState()
									.withProperty(HFBlockCrops.AGE, rand.nextInt(7)), 2);
						}

					}

				}

				return true;
			}
		};
		this.indica = new WorldGenBush((HFBlockCrops) HFBlocks.indica_crop) {
			private List<Biome> biomes = new ArrayList<Biome>();
			private boolean initialized;

			public void addBiomes() {
				this.biomes.add(Biomes.JUNGLE);
				this.biomes.add(Biomes.JUNGLE_EDGE);
				this.biomes.add(Biomes.JUNGLE_HILLS);
				this.biomes.add(Biomes.MUTATED_JUNGLE);
				this.biomes.add(Biomes.MUTATED_JUNGLE_EDGE);
				this.biomes.add(Biomes.FOREST);
				this.biomes.add(Biomes.FOREST_HILLS);
				this.biomes.add(Biomes.MUTATED_FOREST);
				this.biomes.add(Biomes.BIRCH_FOREST);
				this.biomes.add(Biomes.BIRCH_FOREST_HILLS);
				this.biomes.add(Biomes.MUTATED_BIRCH_FOREST);
				this.biomes.add(Biomes.MUTATED_BIRCH_FOREST_HILLS);
				this.biomes.add(Biomes.ROOFED_FOREST);
				this.biomes.add(Biomes.MUTATED_ROOFED_FOREST);
				this.biomes.add(Biomes.SWAMPLAND);
				this.biomes.add(Biomes.MUTATED_SWAMPLAND);
				this.initialized = true;

			}

			@Override
			public boolean generate(World worldIn, Random rand, BlockPos position) {
				if (!this.initialized) {
					this.addBiomes();
				}
				for (int i = 0; i < 64; ++i) {
					BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8),
							rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
					Biome biome = worldIn.getBiomeForCoordsBody(blockpos);
					if (biome.getTempCategory() == Biome.TempCategory.WARM || this.biomes.contains(biome)) {
						if (worldIn.isAirBlock(blockpos)
								&& (!worldIn.provider.hasNoSky() || blockpos.getY() < worldIn.getHeight() - 1)
								&& ((BlockCrops) HFBlocks.indica_crop).canBlockStay(worldIn, blockpos,
										HFBlocks.indica_crop.getDefaultState())) {
							worldIn.setBlockState(blockpos, HFBlocks.indica_crop.getDefaultState()
									.withProperty(HFBlockCrops.AGE, rand.nextInt(7)), 2);
						}

					}

				}

				return true;
			}
		};
		this.sativa = new WorldGenBush((HFBlockCrops) HFBlocks.sativa_crop) {
			private List<Biome> biomes = new ArrayList<Biome>();
			private boolean initialized;

			public void addBiomes() {
				this.biomes.add(Biomes.JUNGLE);
				this.biomes.add(Biomes.JUNGLE_EDGE);
				this.biomes.add(Biomes.JUNGLE_HILLS);
				this.biomes.add(Biomes.MUTATED_JUNGLE);
				this.biomes.add(Biomes.MUTATED_JUNGLE_EDGE);
				this.biomes.add(Biomes.FOREST);
				this.biomes.add(Biomes.FOREST_HILLS);
				this.biomes.add(Biomes.MUTATED_FOREST);
				this.biomes.add(Biomes.BIRCH_FOREST);
				this.biomes.add(Biomes.BIRCH_FOREST_HILLS);
				this.biomes.add(Biomes.MUTATED_BIRCH_FOREST);
				this.biomes.add(Biomes.MUTATED_BIRCH_FOREST_HILLS);
				this.biomes.add(Biomes.ROOFED_FOREST);
				this.biomes.add(Biomes.MUTATED_ROOFED_FOREST);
				this.biomes.add(Biomes.SWAMPLAND);
				this.biomes.add(Biomes.MUTATED_SWAMPLAND);
				this.initialized = true;

			}

			@Override
			public boolean generate(World worldIn, Random rand, BlockPos position) {
				if (!this.initialized) {
					this.addBiomes();
				}
				for (int i = 0; i < 64; ++i) {
					BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8),
							rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
					Biome biome = worldIn.getBiomeForCoordsBody(blockpos);
					if (biome.getTempCategory() == Biome.TempCategory.WARM || this.biomes.contains(biome)) {
						if (worldIn.isAirBlock(blockpos)
								&& (!worldIn.provider.hasNoSky() || blockpos.getY() < worldIn.getHeight() - 1)
								&& ((BlockCrops) HFBlocks.sativa_crop).canBlockStay(worldIn, blockpos,
										HFBlocks.sativa_crop.getDefaultState())) {
							worldIn.setBlockState(blockpos, HFBlocks.sativa_crop.getDefaultState()
									.withProperty(HFBlockCrops.AGE, rand.nextInt(7)), 2);
						}
					}

				}

				return true;
			}
		};

	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		switch (world.provider.getDimension()) {
		case 0:
			this.runGenerator(this.hemp, world, random, chunkX, chunkZ, 3);
			this.runGenerator(this.indica, world, random, chunkX, chunkZ, 1);
			this.runGenerator(this.sativa, world, random, chunkX, chunkZ, 1);
			break;
		case -1: // Nether
			break;
		case 1: // End
			break;
		default:
			break;
		}
	}

	private void runGenerator(WorldGenBush gen, World world, Random rand, int chunkX, int chunkZ, int chance) {

		int maxHeight = world.getHeight() + 1;
		int chancesToSpawn = chance;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunkX + rand.nextInt(6);
			int y = rand.nextInt(maxHeight) + world.getSeaLevel();
			int d = maxHeight - y;
			y = (y <= maxHeight) ? y : y + d;
			int z = chunkZ + rand.nextInt(6);
			gen.generate(world, rand, new BlockPos(x, y, z));

		}

	}

}
