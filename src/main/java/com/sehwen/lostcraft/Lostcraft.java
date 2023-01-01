package com.sehwen.lostcraft;

import com.min.skillobject.SkillManager;
import com.sehwen.lostcraft.Listener.EventListener;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lostcraft extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getLogger().info("Lost Craft Started! (ver 1.0)");
		this.getServer().getPluginManager().registerEvents(new EventListener(),this);
		SkillManager skillManager = (SkillManager) this.getServer().getPluginManager().getPlugin("SkillObject");
		if (skillManager == null)return;
		skillManager.addPvpWorld("world");
		skillManager.registerMob(EntityType.ZOMBIE);
	}

	@Override
	public void onDisable() {
	}
}
