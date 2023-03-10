package com.sehwen.lostcraft.Skills;

import com.min.skillobject.Interface.SkillBase;
import com.min.skillobject.Object.SkillObject;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class BoomSkill extends SkillObject implements SkillBase {
	public BoomSkill(Location location) {
		super(location);
	}

	@Override
	public float getDistance() {
		return 10;
	}

	@Override
	public void skillAttack(LivingEntity livingEntity) {
		if (getTick() >= 25) {
			livingEntity.setHealth(0);
		}
	}

	@Override
	public void skillEffect() {
		if (getTick() < 24) {
			teleport(getDirectionVector().multiply(1).add(new Vector(getLocation().getX(), getLocation().getY(), getLocation().getZ())));
			getLocation().getWorld().spawnParticle(Particle.CRIT_MAGIC, getLocation(), 20, 0.1, 0.1, 0.1, 0.1);
		} else {
			getLocation().getWorld().spawnParticle(Particle.SONIC_BOOM, getLocation(), 15, 3, 3, 3, 5);
			getLocation().getWorld().playSound(getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
			getOwner().playSound(getOwner(), Sound.ENTITY_GENERIC_EXPLODE, 0.2f, 1);
		}
	}
}