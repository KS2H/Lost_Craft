package com.sehwen.lostcraft.Skills;

import com.min.skillobject.Interface.SkillBase;
import com.min.skillobject.Object.SkillObject;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class WaterBoom extends SkillObject implements SkillBase {

	public WaterBoom(Location location) {
		super(location);
	}

	@Override
	public float getDistance() {
		if (getTick() < 40) {
			return 1;
		} else if (getTick()< 50) {
			return 2;
		} else if (getTick() < 60) {
			return 3;
		} else {
			return 4;
		}
	}

	@Override
	public void skillAttack(LivingEntity livingEntity) {
		if (getTick() >= 21) {
			livingEntity.setHealth(0);
		}
	}

	@Override
	public void skillEffect() {
		if (getTick() < 20) {
			teleport(getDirectionVector().multiply(1).add(new Vector(getLocation().getX(), getLocation().getY(), getLocation().getZ())));
			getLocation().getWorld().spawnParticle(Particle.CRIT_MAGIC, getLocation(), 20, 0.1, 0.1, 0.1, 0.1);
		} else if (getTick() <= 40) {
			for (int x = 0; x < 1; x++) {
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() + x, getLocation().getY() + 2, getLocation().getZ(), 50, 1, 1, 1, 1);
				getOwner().playSound(getOwner(), Sound.ENTITY_BOAT_PADDLE_WATER,0.2f,1);
			}
		} else if (getTick() <= 50) {
			for (int z = -1; z < 2; z++) {
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() + 1, getLocation().getY() + 2, getLocation().getZ() + z, 50, 1, 1, 1, 1);
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() - 1, getLocation().getY() + 2, getLocation().getZ() + z, 50, 1, 1, 1, 1);
			}
			for (int x = -1; x < 2; x++) {
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() + 2, getLocation().getY() + 2, getLocation().getZ() + x, 50, 1, 1, 1, 1);
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() - 2, getLocation().getY() + 2, getLocation().getZ() + x, 50, 1, 1, 1, 1);
			}
		} else if (getTick() <= 60) {
			for (int z = -2; z < 3; z++) {
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() + 2, getLocation().getY() + 2, getLocation().getZ() + z, 50, 1, 1, 1, 1);
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() - 2, getLocation().getY() + 2, getLocation().getZ() + z, 50, 1, 1, 1, 1);
			}
			for (int x = -2; x < 3; x++) {
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() + x, getLocation().getY() + 2, getLocation().getZ() + 2, 50, 1, 1, 1, 1);
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() + x, getLocation().getY() + 2, getLocation().getZ() - 2, 50, 1, 1, 1, 1);
			}
		} else if (getTick() <= 70) {
			for (int z = -3; z < 4; z++) {
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() + 3, getLocation().getY() + 3, getLocation().getZ() + z, 50, 1, 1, 1, 1);
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() - 3, getLocation().getY() + 3, getLocation().getZ() + z, 50, 1, 1, 1, 1);
			}
			for (int x = -3; x < 4; x++) {
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() + x, getLocation().getY() + 3, getLocation().getZ() + 3, 50, 1, 1, 1, 1);
				getLocation().getWorld().spawnParticle(Particle.WATER_BUBBLE, getLocation().getX() + x, getLocation().getY() + 3, getLocation().getZ() - 3, 50, 1, 1, 1, 1);
			}
		}
	}
}