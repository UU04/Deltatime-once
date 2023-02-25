package org.duray.duray.job;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.duray.duray.RecordVoids;
import org.duray.duray.graphic.menu.display;

public class economy {
	
	static String w = ChatColor.GRAY + "[TRANSFER] | " + ChatColor.RESET;
	static public ConsoleCommandSender consol = Bukkit.getConsoleSender();
	
	public static void newTransfer(Player s, Player a, String type) {
		
		RecordVoids.Resolve(a, "transfer-target", s.getUniqueId().toString());
		RecordVoids.Resolve(s, "transfer-target", a.getUniqueId().toString());
		consol.sendMessage(w+s.getDisplayName() + "(T), " + a.getDisplayName() + "(V) - New Transfer Type | " + type + ChatColor.AQUA + " TRANSFER IN PROGRESS...");
		RecordVoids.Resolve(s, "transfer-accept", "false");
		RecordVoids.Resolve(a, "transfer-accept", "false");
		display.playerTransfer(s, a);
	}
	
	public static void TransferAcceptedLocal(Player whoclicked, ItemStack i) {
//		if(!Bukkit.getPlayer(RecordVoids.Get(whoclicked, "transfer-target")).isValid() || RecordVoids.Get(whoclicked, "transfer-target") == null) return;
		Player other = Bukkit.getPlayer(UUID.fromString(RecordVoids.Get(whoclicked, "transfer-target")));
//		Player other = whoclicked;
		display.glow(whoclicked, display.transfer, i);
		RecordVoids.Resolve(whoclicked, "transfer-accept", "true");
		
		if(RecordVoids.Get(other, "transfer-accept") == "true") {
			TransferGOGO(whoclicked, other, display.transfer);
		}
	}
	
	public static void TransferRejectedLocal(Player whoclicked, ItemStack i) {
		Player other = Bukkit.getPlayer(UUID.fromString(RecordVoids.Get(whoclicked, "transfer-target")));
		whoclicked.closeInventory();
		other.closeInventory();
		
		consol.sendMessage(w+whoclicked.getDisplayName() + "(T), " + other.getDisplayName() + "(V) - Transfer" + ChatColor.RED + " REJECTED");
	}
	 
	public static void TransferGOGO(Player a, Player b, Inventory c) {
		a.closeInventory();
		b.closeInventory();
		
		a.sendMessage(ChatColor.GREEN + a.getDisplayName() + "와(과) " + b.getDisplayName() + " 간의 거래가 성공적으로 성립되었습니다!");
		b.sendMessage(ChatColor.GREEN + a.getDisplayName() + "와(과) " + b.getDisplayName() + " 간의 거래가 성공적으로 성립되었습니다!");
		RecordVoids.Resolve(a, "transfer-accept", "false");
		RecordVoids.Resolve(b, "transfer-accept", "false");
	}
}
