package org.duray.duray;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.*;
import org.bukkit.event.*;

public class event implements Listener {
	@EventHandler
	public void PlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent e) {
		voids.OnPlayerJoin(e.getPlayer());
	}
	
	@EventHandler
	public void PlayerChatEvent(AsyncPlayerChatEvent e) {
		e.getPlayer().sendMessage(e.getMessage());
	}
}
