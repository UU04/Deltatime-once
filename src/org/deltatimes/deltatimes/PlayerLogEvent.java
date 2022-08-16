package org.deltatimes.deltatimes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.deltatimes.deltatimes.GUI.graphic;
import org.deltatimes.deltatimes.admin.trails;
import org.deltatimes.deltatimes.skills.spir;
import org.deltatimes.deltatimes.main.*;

public class PlayerLogEvent implements Listener{
	


	@EventHandler
	public void join(PlayerJoinEvent e) {
		if(!main.chatdvl.containsKey(e.getPlayer().getUniqueId()) | !main.sfxlvl.containsKey(e.getPlayer().getUniqueId()) || !e.getPlayer().isOp()) { //New User
			voids.New_User(e.getPlayer());
		}
		
		if (!main.chatdvl.containsKey(e.getPlayer().getUniqueId())) main.chatdvl.put(e.getPlayer().getUniqueId(), 0);
		if (!main.sfxlvl.containsKey(e.getPlayer().getUniqueId())) main.sfxlvl.put(e.getPlayer().getUniqueId(), 0);
		
		e.setJoinMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "] "
				+ e.getPlayer().getDisplayName());
		e.getPlayer().getInventory().addItem(org.deltatimes.deltatimes.items.item.newbie());
		if(e.getPlayer().isOp()) e.getPlayer().getInventory().addItem(spir.lev1()); //OP
		e.getPlayer().getInventory().setItem(8, org.deltatimes.deltatimes.items.item.settings());

		int count;
		int wcount;

		count = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getPlugin(main.class), new Runnable() { //Inventory Lobby Item Set
			@Override
			public void run() {

				if (e.getPlayer().getInventory().getItem(8) == null
						|| e.getPlayer().getInventory().getItem(8).getType() != Material.REDSTONE_COMPARATOR) {
					e.getPlayer().getInventory().setItem(8, org.deltatimes.deltatimes.items.item.settings());
				} else {
					return;
				}
			}
		}, 0L, 20L);

		main.autos.put(e.getPlayer().getUniqueId(), count);

		if (e.getPlayer().isOp()) {
			org.deltatimes.deltatimes.admin.trails.admintrails(e.getPlayer());
		}

		wcount = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getPlugin(main.class), new Runnable() { //datetime GUI
			@Override
			public void run() {
				org.deltatimes.deltatimes.GUI.graphic.getdatetime();
				org.deltatimes.deltatimes.GUI.graphic.groot(e.getPlayer().getUniqueId());

			}
		}, 0L, 20L);

		org.deltatimes.deltatimes.GUI.graphic.web.put(e.getPlayer().getUniqueId(), wcount);

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(
				ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "] " + e.getPlayer().getDisplayName());
		Bukkit.getScheduler().cancelTask(graphic.web.get(e.getPlayer().getUniqueId()));
		if(e.getPlayer().isOp()) Bukkit.getScheduler().cancelTask(trails.taskID); //only one OP Player
	}

}
