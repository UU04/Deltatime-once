package org.duray.duray;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class RecordVoids {
	static org.bukkit.plugin.Plugin plugin = main.getPlugin(main.class);
	
	public static void Resolve(Player p, String a, String b) {
		plugin.getConfig().set("storage.RAM." + p.getUniqueId()+"." + a, b);
		plugin.saveConfig();
	}
	
	public static String Get(Player p,  String a) {
		return (String) plugin.getConfig().get("storage.RAM." + p.getUniqueId()+"." + a);
	}
}
