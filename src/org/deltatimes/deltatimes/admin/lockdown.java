package org.deltatimes.deltatimes.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class lockdown {
	public static void lockdownSOS(Player p) {
//		if(!p.isOp()) return;
		
		Bukkit.broadcastMessage(ChatColor.YELLOW + "");
		Bukkit.broadcastMessage(ChatColor.YELLOW + "" + ChatColor.AQUA  + "               <서버가 현재 긴급 작동정지 상태입니다>");
		Bukkit.broadcastMessage(ChatColor.YELLOW + ""+ChatColor.RED+" 운영진이 현재 서버 시스템을 점검하고 있으며 관련 플레이어들을 조사하고 있습니다.");
		Bukkit.broadcastMessage(ChatColor.YELLOW + ""+ChatColor.RED+" 서버 이용에 불편을 드려 진심으로 죄송합니다. 5분 이내에 작동을 재개하도록 하겠습니다.");
		Bukkit.broadcastMessage(ChatColor.YELLOW + ""+ChatColor.GRAY+" (모든 경매, 시간 부스트, 이벤트가 정지되었고 피해 신고 시 보상을 받을 수 있습니다)");
		Bukkit.broadcastMessage(ChatColor.YELLOW + ""+ChatColor.GRAY+" (작동정지 사유 : Jav.errorcode - 7349[Player Hack Detect])");
		Bukkit.broadcastMessage(ChatColor.YELLOW + "");
		
		for(Player w : Bukkit.getOnlinePlayers()) {
			w.setAllowFlight(false);
			w.setWalkSpeed(0);
			w.setFlying(false);
			w.setSaturation(100000);
		}
	}
}
