package org.deltatimes.deltatimes.items;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.deltatimes.deltatimes.voids;

public class block implements Listener{
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(e.getBlock() == null) return;
		if(e.getBlock().getType() == null) return;
		
		Player p = e.getPlayer();
		Block b = e.getBlock();
		Material m = b.getType();
		
		if(e.getBlock().getType() == Material.REDSTONE_COMPARATOR_OFF) {
			
			if (e.getPlayer().getItemInHand() == null)
				return;
			if (e.getPlayer().getItemInHand().getItemMeta() == null)
				return;
			if (e.getPlayer().getItemInHand().getData() == null)
				return;
			if (e.getPlayer().getInventory() == null)
				return;
			if (e.getPlayer().getItemInHand().getType() == Material.AIR)
				;
			if (e.getPlayer().getItemInHand().getItemMeta() == null)
				return;
			if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName() == null)
				return;
			
			if(p.getItemInHand().getItemMeta().getDisplayName().contains("¼³Á¤")) {
				e.setCancelled(true);
				voids.settings(e.getPlayer());
				return;
			}
		}
	}
}
