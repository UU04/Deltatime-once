package org.duray.duray.graphic.menu;

import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class resource {
	public static ItemStack AcceptTransfer() {
		ItemStack item = new ItemStack(Material.CONCRETE_POWDER, 1, (short)13);
        ItemMeta meta = item.getItemMeta();
        
        meta.setDisplayName(ChatColor.GREEN + "거래 수락하기");
        meta.setLore(Arrays.asList(""));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        
        
        return item;
	}
	public static ItemStack RejectTransfer() {
		ItemStack item = new ItemStack(Material.CONCRETE_POWDER, 1, (short)14);
        ItemMeta meta = item.getItemMeta();
        
        meta.setDisplayName(ChatColor.RED + "거래 거절하기");
        meta.setLore(Arrays.asList(""));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        
        
        return item;
	}

	public static ItemStack Money() {
		ItemStack item = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta meta = item.getItemMeta();
        
        meta.setDisplayName(ChatColor.GOLD + "0 G");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.setLore(Arrays.asList(""));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        
        
        return item;
	}
}
