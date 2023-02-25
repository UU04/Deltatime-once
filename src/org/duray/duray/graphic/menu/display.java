package org.duray.duray.graphic.menu;


import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class display {
	public static Inventory transfer = Bukkit.createInventory(null, 54, "new transfer");
	
	public static void playerTransfer(Player s, Player a) {
		transfer.setItem(0, resource.AcceptTransfer());
		transfer.setItem(1, resource.RejectTransfer());
		transfer.setItem(2, resource.Money());
		s.openInventory(transfer);
		a.openInventory(transfer);
	}
	
	public static void glow(Player p, Inventory inv, ItemStack l) {
		ItemStack i = l;
		ItemMeta m = i.getItemMeta();
		m.addEnchant(Enchantment.DURABILITY, 1, false);
		i.setItemMeta(m);
		
		transfer.setItem(GetItemLoc(inv, l), i);
		
		p.updateInventory();
	}
	
	public static int GetItemLoc(Inventory inv, ItemStack st) {
		for (int i = 0; i < inv.getContents().length; i++) {
			if(inv.getItem(i) == null) continue;
			if(inv.getItem(i).equals(st)) {
				return i;
			}
		}
		return -1;
	}
}
