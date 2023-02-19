package org.duray.duray;

import java.lang.reflect.Array;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class voids {
	
	public static void OnStartUp() {
		ConsoleCommandSender consol = Bukkit.getConsoleSender();

		consol.sendMessage(ChatColor.AQUA + "---------------------------------------------------------------------------------------------");
		consol.sendMessage(ChatColor.AQUA + "");
		consol.sendMessage(ChatColor.AQUA + "	*	*	Duray_Project 플러그인이 정상작동 중입니다		*	*	");
		consol.sendMessage(ChatColor.AQUA + "");
		consol.sendMessage(ChatColor.AQUA + "---------------------------------------------------------------------------------------------");
		
		main.getPlugin(main.class).getServer().getPluginManager().registerEvents(new org.duray.duray.event(), org.duray.duray.main.getPlugin(org.duray.duray.main.class));
		main.getPlugin(main.class).getCommand("test").setExecutor(new org.duray.duray.cmd.command());
	}
	
	public static void OnShutDown() {
		for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
			Player p = (Player) Bukkit.getOnlinePlayers().toArray()[i];
			
			String line1 = ChatColor.WHITE + "Duray_Project server has been shut-down.";
			String line2 = ChatColor.GRAY + "Duray_project 서버가 종료되었습니다.";
			String line3 = "";
			String line4 = ChatColor.AQUA + "Player Name : " + p.getDisplayName() + "  |  Action Details : shutdown";
			String line5 = ChatColor.AQUA + "Player ID : " + p.getUniqueId() + "  |  IP Adress : "+ p.getAddress();
			
			String msg = line1+"\n"+line2+"\n"+line3+"\n"+line4+"\n"+line5;
			
			p.kickPlayer(msg);
		}
	}
	
	public static void OnPlayerJoin(final Player p) {
		org.duray.duray.graphic.asc.BoardRegister(p, 1);
	}
}
