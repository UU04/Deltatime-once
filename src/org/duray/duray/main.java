package org.duray.duray;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.duray.duray.voids;

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
