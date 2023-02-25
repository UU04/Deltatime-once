package org.duray.duray.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.duray.duray.RecordVoids;
import org.duray.duray.job.economy;

public class command implements org.bukkit.command.CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("test")) {
//			org.duray.duray.job.bank.Inject(Bukkit.getPlayer(sender.getName()), 1000000000000000000L);
			//Long.parseLong(args[0])
			
//			economy.newTransfer(Bukkit.getPlayer(sender.getName()), Bukkit.getPlayer(sender.getName()), "test");

//			RecordVoids.Resolve(Bukkit.getPlayer(sender.getName()), args[0], args[1]);
		}
		
		return false;
	}
}
