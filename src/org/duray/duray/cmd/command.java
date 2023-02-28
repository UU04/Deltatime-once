package org.duray.duray.cmd;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command implements org.bukkit.command.CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("test")) {
			Player p = Bukkit.getPlayer(sender.getName());
//			org.duray.duray.job.bank.Inject(Bukkit.getPlayer(sender.getName()), 1000000000000000000L);
			// Long.parseLong(args[0])

//			economy.newTransfer(Bukkit.getPlayer(sender.getName()), Bukkit.getPlayer(sender.getName()), "test");

//			RecordVoids.Resolve(Bukkit.getPlayer(sender.getName()), args[0], args[1]);
//
//			PlayerUI.SendTitle("", p);
//			PlayerUI.SendSubTitle("æ»≥Á«œººø‰", p);
			

			p.playSound(p.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1.6F, 1.75F);
		}

		return false;
	}
}
