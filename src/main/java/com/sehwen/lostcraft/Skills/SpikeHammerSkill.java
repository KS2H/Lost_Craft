package com.sehwen.lostcraft.Skills;

import com.min.skillobject.Interface.SkillBase;
import com.min.skillobject.Object.SkillObject;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class SpikeHammerSkill extends SkillObject implements SkillBase {
	public SpikeHammerSkill(Location location) {
		super(location);
	}

	@Override
	public float getDistance() {
		return 3;
	}

	@Override
	public void skillAttack(LivingEntity livingEntity) {
		livingEntity.setHealth(0);

	}

	@Override
	public void skillEffect() {
		teleport(getDirectionVector().multiply(6).add(new Vector(getLocation().getX(),getLocation().getY(),getLocation().getZ())));
		for (int z = -3; z < 4; z++){
			getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(),getLocation().getX(),getLocation().getY(),getLocation().getZ()+z), EntityType.EVOKER_FANGS);
		}
		for (int x = -3; x < 4; x++){
			getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(), getLocation().getX()+x,getLocation().getY(),getLocation().getZ()), EntityType.EVOKER_FANGS);
		}

	}
}

