package com.sehwen.lostcraft.Skills;

import com.min.skillobject.Interface.SkillBase;
import com.min.skillobject.Object.SkillObject;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class SpikeSkill extends SkillObject implements SkillBase {
	public SpikeSkill(Location location) {
		super(location);
	}

	@Override
	public float getDistance() {
		return 2;
	}

	@Override
	public void skillAttack(LivingEntity livingEntity) {
		livingEntity.setHealth(0);

	}

	@Override
	public void skillEffect() {
		teleport(getDirectionVector().multiply(1.5).add(new Vector(getLocation().getX(),getLocation().getY(),getLocation().getZ())));
		getLocation().getWorld().spawnEntity(getLocation(), EntityType.EVOKER_FANGS);

	}
}
