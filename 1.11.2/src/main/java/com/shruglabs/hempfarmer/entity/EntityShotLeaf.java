package com.shruglabs.hempfarmer.entity;

import com.shruglabs.hempfarmer.block.HFBlockCrops;
import com.shruglabs.hempfarmer.init.HFBlocks;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;

public class EntityShotLeaf extends EntityThrowable {

	public static boolean entity;
	public static boolean player;
	public static boolean block;
	private EntityLivingBase shooter;

	public EntityShotLeaf(World worldIn) {
		super(worldIn);
	}

	public EntityShotLeaf(World worldIn, EntityLivingBase shooter) {
		this(worldIn, shooter.posX, shooter.posY + (double) shooter.getEyeHeight() - 0.10000000149011612D,
				shooter.posZ);
		this.setShooter(shooter);

	}

	private void setShooter(EntityLivingBase shooter) {
		this.shooter = shooter;

	}

	public EntityShotLeaf(World worldIn, double x, double y, double z) {
		this(worldIn);
		this.setPosition(x, y, z);

	}

	protected float getGravityVelocity() {
		return -0.01F;

	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		World world = this.world;
		if ((this.ticksExisted % 2) == 0) {
			world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY, this.posZ, 0.1, 1.0, 0.3);
		}

	}

	@Override
	protected void onImpact(RayTraceResult result) {
		World world = this.world;
		if (result.typeOfHit.equals(Type.ENTITY) && !result.entityHit.equals(this.getShooter())) {
			if (result.entityHit instanceof EntityPlayer && player) {
				EntityLivingBase entity = (EntityLivingBase) result.entityHit;
				if (!world.isRemote) {
					entity.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 100, 1, false, false));
					entity.addPotionEffect(new PotionEffect(Potion.getPotionById(25), 200, 1, false, false));
					entity.addPotionEffect(new PotionEffect(Potion.getPotionById(24), 300, 1, false, false));
					entity.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 500, 5, false, false));
				}
			}
			if (result.entityHit instanceof EntityLiving && entity) {
				EntityLivingBase entity = (EntityLivingBase) result.entityHit;
				if (!world.isRemote) {
					if (entity instanceof EntityZombie) {
						EntityVillager vill = new EntityVillager(world);
						vill.setPosition(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ);
						entity.setDead();
						world.spawnEntity(vill);

					} else {
						entity.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 100, 1, false, false));
						entity.addPotionEffect(new PotionEffect(Potion.getPotionById(25), 200, 1, false, false));
						entity.addPotionEffect(new PotionEffect(Potion.getPotionById(24), 300, 1, false, false));
						entity.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 500, 5, false, false));

					}
				}
			}
		}

		if (result.typeOfHit.equals(Type.BLOCK) && block) {
			if (!world.isRemote) {
				Block block = world.getBlockState(result.getBlockPos()).getBlock();
				if (!block.equals(Blocks.TALLGRASS) && !block.equals(Blocks.GRASS)) {
					int blockID = Block.getIdFromBlock(block);
					IBlockState newState = null;
					boolean changeable = false;
					switch (blockID) {
					case 4:
						changeable = true;
						newState = Blocks.GRAVEL.getDefaultState();
						break;
					case 12:
						changeable = true;
						newState = Blocks.CLAY.getDefaultState();
						break;
					case 13:
						changeable = true;
						newState = Blocks.SAND.getDefaultState();
						break;
					case 30:
						changeable = true;
						newState = Blocks.COAL_ORE.getDefaultState();
						break;
					case 18:
						changeable = true;
						newState = Blocks.WEB.getDefaultState();
						break;
					case 37:
						changeable = true;
						Block hemp = rand.nextBoolean() ? HFBlocks.sativa_crop : HFBlocks.indica_crop;
						newState = hemp.getDefaultState().withProperty(HFBlockCrops.AGE, rand.nextInt(7));
						break;
					case 38:
						changeable = true;
						newState = HFBlocks.hemp_crop.getDefaultState().withProperty(HFBlockCrops.AGE, rand.nextInt(7));
						break;
					case 161:
						changeable = true;
						newState = Blocks.WEB.getDefaultState();
						break;
					default:
						changeable = false;
						break;
					}
					if (blockID == HFBlocks.getIdFromBlock(HFBlocks.oily_dirt)) {
						changeable = true;
						newState = Blocks.GLOWSTONE.getDefaultState();
					}
					if (blockID == HFBlocks.getIdFromBlock(HFBlocks.violet_dirt)) {
						changeable = true;
						newState = Blocks.IRON_ORE.getDefaultState();
					}
					if (blockID == HFBlocks.getIdFromBlock(HFBlocks.lime_dirt)) {
						changeable = true;
						newState = Blocks.EMERALD_ORE.getDefaultState();
					}
					if (blockID == HFBlocks.getIdFromBlock(HFBlocks.resin_dirt)) {
						changeable = true;
						newState = Blocks.REDSTONE_ORE.getDefaultState();
					}

					if (changeable && newState != null) {
						world.destroyBlock(result.getBlockPos(), false);
						world.setBlockState(result.getBlockPos(), newState);
					}
					this.setDead();

				}
			}
		}
	}

	private EntityLivingBase getShooter() {
		return this.shooter;
	}
}
