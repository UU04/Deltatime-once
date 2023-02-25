package org.duray.duray.job;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.duray.duray.RecordVoids;

public class bank {
	public static HashMap<UUID, Long> Bank = new HashMap<UUID, Long>();

	static ConsoleCommandSender consol = Bukkit.getConsoleSender();
	static String w = ChatColor.GRAY + "[BANK] | " + ChatColor.RESET;
	
	public static void Inject(Player p, long l) { //1천억 리미트
		if(l>100000000000L || l<0) {
			consol.sendMessage(w+ p.getDisplayName() + " - Bank Account Value " + ChatColor.RED + "REJECTED " + ChatColor.WHITE + "[" + Bank.get(p.getUniqueId())+"] >>> " + "[" + l + "]");
			p.sendMessage(ChatColor.GRAY + "※ " + ChatColor.RED + "비정상적인 활동이 감지되어 거래가 거부되었습니다.");
			return;
		}
		if(!Bank.containsKey(p.getUniqueId())) Bank.put(p.getUniqueId(), 0L);
		
		consol.sendMessage(w+ p.getDisplayName() + " - Bank Account Value "+ ChatColor.GREEN + "ACCEPTED " + ChatColor.WHITE + "[" + Bank.get(p.getUniqueId())+"] >>> " + "[" + l + "]");
		Bank.put(p.getUniqueId(), l);
		RecordVoids.Resolve(p, "Bank-Account", Long.toString(l));
	}
	
	public static Long Get(Player p) {
		if(!Bank.containsKey(p.getUniqueId())) Reset(p);
		return Bank.get(p.getUniqueId());
	}
	
	public static void Reset(Player p) {
		if(!Bank.containsKey(p.getUniqueId())) Bank.put(p.getUniqueId(), 0L);
		consol.sendMessage(w+ p.getDisplayName() + " - Bank Account Value "+ ChatColor.GREEN + "ACCEPTED " + ChatColor.WHITE + "[" + Bank.get(p.getUniqueId())+"] >>> " + "[" + "0" + "]");
		Bank.put(p.getUniqueId(), 0L);
		RecordVoids.Resolve(p, "Bank-Account", "0");
	}
	
	public static String Short_Num(Player p) {
		Long ks = Get(p);
		
		DecimalFormat dc = new DecimalFormat("###,###,###,###,###,###,###,###,###,###");
		String k = dc.format(ks);

		if(ks>=10000000) return ChatColor.DARK_PURPLE + k;
		if(ks>=5000000) return ChatColor.LIGHT_PURPLE + k;
		if(ks>=1000000) return ChatColor.YELLOW + k;
		if(ks>=500000) return ChatColor.RED + k;
		if(ks>=150000) return ChatColor.BLUE + k;
		if(ks>=75000) return ChatColor.GREEN + k;
		if(ks>=10000) return ChatColor.DARK_GREEN + k;
		return ChatColor.WHITE + k;
	}
}
