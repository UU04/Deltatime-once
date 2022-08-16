package org.deltatimes.deltatimes.support;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.deltatimes.deltatimes.method;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;


public class npcvoides {
	public static void npcruncodes(String code, String player) {
		
		Player p = Bukkit.getPlayer(player);
		
		switch(code) {
			case("0828"): // 1. 직업소개소 실장님
				org.deltatimes.deltatimes.voids.jobpick(Bukkit.getPlayer(player));
				break;
			case("a924"): // 2. 석릉고 입학처 선생
				break;
			case("0815"): // 3. 학생용 도서관 봇
				break;
			case("0816"): // 4. 교사용 도서관 봇
				break;
			case("5555"): // 5. 만화 덕후
				p.sendMessage(ChatColor.RED + "");
			
				method.NPCselect(p, ChatColor.WHITE + "  *선택*  " + ChatColor.YELLOW + "[1]" + ChatColor.WHITE + " 너..여기서 뭐하는거야?", "/miyeonshi 1111 " + p.getDisplayName());
				method.NPCselect(p, ChatColor.WHITE + "  *선택*  " + ChatColor.YELLOW + "[2]" + ChatColor.WHITE + " 안녕!", "/miyeonshi 1112 " + p.getDisplayName());
				method.NPCselect(p, ChatColor.WHITE + "  *선택*  " + ChatColor.YELLOW + "[3]" + ChatColor.WHITE + " 이거 너 가져", "/miyeonshi 1113 " + p.getDisplayName());
				
				p.sendMessage(ChatColor.BLACK + "");
				break;
			case("6666"): // 6. 태릉관 경비원(알리미)
				break;
		}
	}
	
	//TextComponent message = new TextComponent("[선택] 25% 통장저금하기");
	//message.setColor(net.md_5.bungee.api.ChatColor.GREEN);
	//message.setBold(true);
	//message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/des 25"));
	//message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
	//new ComponentBuilder("[MUJU_CHOICE.API - 25bankinto]").color(net.md_5.bungee.api.ChatColor.GRAY).italic(true).create()));
	//p.spigot().sendMessage(message);
}
