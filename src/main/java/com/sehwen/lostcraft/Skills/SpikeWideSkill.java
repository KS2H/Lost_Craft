package com.sehwen.lostcraft.Skills;

import com.min.skillobject.Interface.SkillBase;
import com.min.skillobject.Object.SkillObject;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class SpikeWideSkill extends SkillObject implements SkillBase {

	public SpikeWideSkill(Location location) {
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
		getOwner().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1, 100, false, false));
		if (getTick() < 15) {
			teleport(getDirectionVector().multiply(1).add(new Vector(getLocation().getX(), getLocation().getY(), getLocation().getZ())));
			getLocation().getWorld().spawnEntity(getLocation(), EntityType.EVOKER_FANGS);
		} else {
			for (int z = -3; z < 4; z++) {
				getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(), getLocation().getX(), getLocation().getY(), getLocation().getZ() + z), EntityType.EVOKER_FANGS);
			}
			for (int x = -3; x < 4; x++) {
				getLocation().getWorld().spawnEntity(new Location(getLocation().getWorld(), getLocation().getX() + x, getLocation().getY(), getLocation().getZ()), EntityType.EVOKER_FANGS);
			}
		}
	}
}