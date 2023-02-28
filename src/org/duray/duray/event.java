package org.duray.duray;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.duray.duray.calculation.signs;
import org.duray.duray.job.economy;
import org.duray.duray.job.jobs;
import org.duray.duray.sound.jukebox;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class event implements Listener {
	@EventHandler
	public void PlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent e) {
		voids.OnPlayerJoin(e.getPlayer());
	}
	
	@EventHandler
	public void PlayerChatEvent(AsyncPlayerChatEvent e) {
		e.getPlayer().sendMessage(e.getMessage());
	}
	
	@EventHandler
	public void InventoryClickEvent(org.bukkit.event.inventory.InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		String ItemName;
		ItemName = null;
		if(e.getClickedInventory() == null) return;
		if(e.getCurrentItem() == null) return;
		if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
		if(e.getCurrentItem().getItemMeta() == null) return;
		ItemName = e.getCurrentItem().getItemMeta().getDisplayName();
		if(e.getCurrentItem().getItemMeta().getDisplayName() == null) ItemName = e.getCurrentItem().getType().toString().toLowerCase();
		
		if(e.getInventory().getTitle().contains("transfer")) {
			if(ItemName.contains("수락")) {
				e.setCancelled(true);
				economy.TransferAcceptedLocal(p, e.getCurrentItem());
			}
			if(ItemName.contains("거절")) {
				e.setCancelled(true);
				economy.TransferRejectedLocal(p, e.getCurrentItem());
			}
			if(ItemName.contains("G")) {
				e.setCancelled(true);
				economy.TransferAcceptedLocal(p, e.getCurrentItem());
			}
		}
		
	}
	
	@EventHandler
	public void PlayerInteractonEntityEvent(PlayerInteractAtEntityEvent e) {
		Player p = e.getPlayer();
		Entity target = e.getRightClicked();
		
		if(!target.getType().equals(EntityType.PLAYER)) return;
		if(!subvoids.web.containsKey(e.getPlayer())) {
			subvoids.web.put(p, false);
		}
		if(subvoids.web.get(e.getPlayer()) == true) return;
		subvoids.web.put(p, true);
		
		RecordVoids.Resolve(p, "RecentInteraction-Player", Bukkit.getPlayer(target.getName()).getDisplayName() + "/" + e.getPlayer().getUniqueId());

		economy.newTransfer(p, (Player) target, "player-player");
	}
	
	@EventHandler
	public void BlockInteraction(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(e.getClickedBlock() == null || e.getAction() == null || e.getClickedBlock().getType() == null) return;
		
		//bank
		if(e.getClickedBlock().getType().toString().contains("CHEST") & e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block b = e.getClickedBlock();
			Chest chest = (Chest) b.getLocation().getBlock().getState();
			Inventory inv = chest.getBlockInventory();
			
			for (int i = 0; i < inv.getContents().length; i++) {
				if(inv.getItem(i) == null) continue;
				if(inv.getItem(i).getType() == null) continue;
				if(inv.getItem(i).getType() == Material.AIR) continue;
				if(inv.getItem(i).getItemMeta().getDisplayName()== null) continue;
				if(inv.getItem(i).getItemMeta().getDisplayName().contains("bank")) {
					e.setCancelled(true);
					p.sendMessage("Bank");
					jukebox.Money_Work(p);
					return;
				}
			}
		}
		
		//door roles
		if(!e.getClickedBlock().getType().toString().contains("DOOR")) return;

		if(e.getClickedBlock().getType().toString().contains("DOOR") & e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(signs.signchk(p, e) != null) {
				if(!signs.signchk(p, e).contains(jobs.Get(p))) {
					NoPermHey(p, e);
				}
			}
			if(signs.signchkdown(p, e) != null) {
				if(!signs.signchkdown(p, e).contains(jobs.Get(p))) {
					NoPermHey(p, e);
				}
			}
		}
	}
	
	public static void NoPermHey(Player p, PlayerInteractEvent e) {
		jukebox.Not_Allowed(p);
		e.setCancelled(true);
		String msg = ChatColor.RED + "*" + ChatColor.GRAY + " 권한이 없어 해당 동작이 불가능합니다.";
		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(msg));
	}
}
