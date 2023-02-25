package org.duray.duray;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	@Override
	public void onEnable() {
		voids.OnStartUp();
	}
	
	@Override
	public void onDisable() {
		voids.OnShutDown();
	}
}
