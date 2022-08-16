package org.deltatimes.deltatimes.items;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class item {
	public static ItemStack newbie() {
		ItemStack item = new ItemStack(Material.NAME_TAG); //이름 태그 아이템으로 만들거임 ㅇㅇ
        ItemMeta meta = item.getItemMeta();
        
        meta.setDisplayName(ChatColor.YELLOW + "신규 접속자용 닉네임 설정권");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.setLore(Arrays.asList( ChatColor.GRAY +  "" + ChatColor.BOLD + "SERVER_COLLECTION", ChatColor.BLUE + "/<신규 접속자 전용 아이템>/", "", ChatColor.WHITE + "해당 아이템을 클릭해서 자신의 닉네임을 설정할 수 있습니다!"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        
        
        return item;
	}
	public static ItemStack nickchange() {
		ItemStack item = new ItemStack(Material.NAME_TAG); //이름 태그 아이템으로 만들거임 ㅇㅇ
        ItemMeta meta = item.getItemMeta();
        
        meta.setDisplayName(ChatColor.AQUA + "닉네임 변경권");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.setLore(Arrays.asList( ChatColor.GRAY +  "" + ChatColor.BOLD + "SERVER_COLLECTION", "", ChatColor.WHITE + "해당 아이템을 클릭해서 자신의 닉네임을 변경할 수 있습니다!"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        
        
        return item;
	}
	public static ItemStack settings() {
		ItemStack item = new ItemStack(Material.REDSTONE_COMPARATOR);
        ItemMeta meta = item.getItemMeta();
        
        meta.setDisplayName(ChatColor.GOLD + "[DTZ] 델타타임즈 설정");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.setLore(Arrays.asList( ChatColor.GRAY +  "" + ChatColor.BOLD + "SERVER_COLLECTION", ChatColor.BLUE + "/<서버 전체 플레이어 지급용>/", "", ChatColor.WHITE + "해당 아이템을 클릭해서 설정을 변경할 수 있습니다!"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        
        
        return item;
	}
	
	public static ItemStack nickgui() {
		ItemStack item = new ItemStack(Material.NAME_TAG);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "*닉네임 변경하기*");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
	}
	List<String> TestList = new ArrayList<String>();
	
	public static ItemStack noPick() {
		ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.setLore(Arrays.asList(ChatColor.WHITE + "닉네임 변경권 회수하기(사용하지 않기)"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
	}
}
