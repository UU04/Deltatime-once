package org.deltatimes.deltatimes;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class method {
	public static void NPCselect(Player p, String msg, String run) {
		TextComponent message = new TextComponent(msg);
		message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, run));
		message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("[해당 메세지를 NPC에게 보냅니다]").color(net.md_5.bungee.api.ChatColor.GRAY).italic(true).create()));
		p.spigot().sendMessage(message);
	}
}