package com.sehwen.lostcraft.Skills;

import com.min.skillobject.Interface.SkillBase;
import com.min.skillobject.Object.SkillObject;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class SharkSkill extends SkillObject implements SkillBase {
	private int tick = 0;

	public SharkSkill(Location location) {
		super(location);
	}

	@Override
	public float getDistance() {
		return 3;
	}

	@Override
	public void skillAttack(LivingEntity livingEntity) {
		if (tick >= 21) {
			livingEntity.setHealth(0);
		}
	}

	@Override
	public void skillEffect() {
		tick++;
		if (tick < 20) {
			teleport(getDirectionVector().multiply(1).add(new Vector(getLocation().getX(), getLocation().getY(), getLocation().getZ())));
			getLocation().getWorld().spawnParticle(Particle.CRIT_MAGIC, getLocation(), 20, 0.1, 0.1, 0.1, 0.1);
		} else if 
			for(int count = 0;count < 1) {
				for (int z = -3; z < 4; z++) {
					getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(), getLocation().getX() + 3, getLocation().getY(), getLocation().getZ() + z), EntityType.EVOKER_FANGS);
					getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(), getLocation().getX() - 3, getLocation().getY(), getLocation().getZ() + z), EntityType.EVOKER_FANGS);
				}
				for (int x = -3; x < 4; x++) {
					getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(), getLocation().getX() + x, getLocation().getY(), getLocation().getZ() + 3), EntityType.EVOKER_FANGS);
					getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(), getLocation().getX() + x, getLocation().getY(), getLocation().getZ() - 3), EntityType.EVOKER_FANGS);
				}
			}
		} else if (tick < 60){
			for (int z = -2; z < 3; z++) {
				getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(), getLocation().getX()+2, getLocation().getY(), getLocation().getZ() + z), EntityType.EVOKER_FANGS);
				getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(), getLocation().getX()-2, getLocation().getY(), getLocation().getZ() + z), EntityType.EVOKER_FANGS);
			}
			for (int x = -2; x < 3; x++) {
				getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(), getLocation().getX() + x, getLocation().getY(), getLocation().getZ()+2), EntityType.EVOKER_FANGS);
				getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(), getLocation().getX() + x, getLocation().getY(), getLocation().getZ()-2), EntityType.EVOKER_FANGS);
			}
		}
	}
}
