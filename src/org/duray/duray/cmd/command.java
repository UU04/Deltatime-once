package org.duray.duray.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class command implements org.bukkit.command.CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("test")) {
			org.duray.duray.job.bank.Inject(Bukkit.getPlayer(sender.getName()), Long.parseLong(args[0]));
		}
		
		return false;
	}
}
