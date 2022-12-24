package com.sehwen.lostcraft;

import com.sehwen.lostcraft.Listener.EventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lostcraft extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getLogger().info("Lost Craft Started! (ver 1.0)");
		this.getServer().getPluginManager().registerEvents(new EventListener(),this);
	}

	@Override
	public void onDisable() {
	}
}
