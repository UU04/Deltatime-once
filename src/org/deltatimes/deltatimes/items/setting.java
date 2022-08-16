package org.deltatimes.deltatimes.items;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.deltatimes.deltatimes.main;

public class setting {
	public static ItemStack noitem() {
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getDyeData()); //이름 태그 아이템으로 만들거임 ㅇㅇ
        ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.YELLOW + "");
        item.setItemMeta(meta);
        return item;
	}
	public static ItemStack sec() {
		ItemStack item = new ItemStack(Material.BOAT_ACACIA);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA + "채팅 서버 설정");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        return item;
	}
	public static ItemStack dat() {
		ItemStack item = new ItemStack(Material.GRASS_PATH);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA + "GUI 및 컨텐츠 설정");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        return item;
	}
	public static ItemStack dlc() {
		ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList("", ChatColor.RED + "> 버그로 인해 현재 폐쇠된 기능입니다!", ChatColor.RED + "> 다음 업데이트에 개선된 성능으로 찾아뵙겠습니다."));
        meta.setDisplayName(ChatColor.AQUA + "DLC 컨텐츠 설정");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        return item;
	}
	public static ItemStack particle(int a) {
		ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();
        
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        String b;
        b = "9";
        switch(a) {
		case 0:
			meta.setLore(Arrays.asList("", ChatColor.WHITE + "> 모든 준비된 특수효과를 보여드립니다.",ChatColor.WHITE + "> GTX 1660 이상의 GPU를 위한 설정입니다.","", ChatColor.GRAY + " [TIP] 단, 너무 없으면 게임이 허전할 수 있습니다."));
			b = ChatColor.GRAY + "0";
		case 1:
			meta.setLore(Arrays.asList("", ChatColor.WHITE + "> 과도한 특수효과를 제한합니다.",ChatColor.WHITE + "> 사양이 낮은 PC의 경우 추천합니다.","", ChatColor.GRAY + " [TIP] 단, 너무 없으면 게임이 허전할 수 있습니다."));
			b = ChatColor.RED + "1";
		case 2:
			meta.setLore(Arrays.asList("", ChatColor.WHITE + "> 보조 효과들이 제한됩니다.",ChatColor.WHITE + "> 메인 로비에서의 특수효과도 일부 제한됩니다.","", ChatColor.GRAY + " [TIP] 단, 너무 없으면 게임이 허전할 수 있습니다."));
			b = ChatColor.GOLD + "2";
		case 3:
			meta.setLore(Arrays.asList("", ChatColor.WHITE + "> 모든 특수효과를 제한합니다.",ChatColor.WHITE + "> 스피드러너, 개발자를 위한 설정입니다.","", ChatColor.GRAY + " [TIP] 단, 너무 없으면 게임이 허전할 수 있습니다."));
			b = ChatColor.GREEN + "3";
		default:
			
			break;
		}
        meta.setDisplayName(ChatColor.YELLOW+ "특수 효과 : "+ b + ChatColor.AQUA+  " 레벨");
        item.setItemMeta(meta);
        return item;
	}
	
	
	public static ItemStack chat0() {
		ItemStack item = new ItemStack(Material.WOOD_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList("", ChatColor.WHITE + "> 어떤 검열도 진행되지 않습니다. ", ChatColor.WHITE + "> 다만 다수의 비속어와 욕설에 노출될 수 있습니다.", "","",  ChatColor.GRAY + "[L클릭] - 검열 레벨 변경"));
        meta.setDisplayName(ChatColor.YELLOW + "채팅 검열 : " + ChatColor.GRAY+  "0 " + ChatColor.AQUA  + "레벨");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        return item;
	}
	public static ItemStack chat1() {
		ItemStack item = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList("", ChatColor.WHITE + "> 매우 높은 수위의 욕설, 비속어가 검열됩니다. ", "","",  ChatColor.GRAY + "[L클릭] - 검열 레벨 변경"));
        meta.setDisplayName(ChatColor.YELLOW + "채팅 검열 : " + ChatColor.RED+  "1 " + ChatColor.AQUA  + "레벨");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        item.setItemMeta(meta);
        return item;
	}
	public static ItemStack chat2() {
		ItemStack item = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList("", ChatColor.WHITE + "> 욕설, 비속어, 악의적 표현의 은어들이 검열됩니다. ", "","",  ChatColor.GRAY + "[L클릭] - 검열 레벨 변경"));
        meta.setDisplayName(ChatColor.YELLOW + "채팅 검열 : " + ChatColor.GOLD+  "2 " + ChatColor.AQUA  + "레벨");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        item.setItemMeta(meta);
        return item;
	}
	public static ItemStack chat3() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList("", ChatColor.WHITE + "> 방송통신위원회의 7세 이상 이용가 가이드라인을 준수합니다. ",ChatColor.WHITE + "> 너무 깐깐하다는 일부 플레이어들의 의견도 참고해주세요!", "","",  ChatColor.GRAY + "[L클릭] - 검열 레벨 변경"));
        meta.setDisplayName(ChatColor.YELLOW + "채팅 검열 : " + ChatColor.GREEN+  "3 " + ChatColor.AQUA  + "레벨");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        item.setItemMeta(meta);
        return item;
	}
	public static ItemStack chatadmin() {
		ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList("", ChatColor.WHITE + "> 운영자 전용 CHAT 설정입니다. "));
        meta.setDisplayName(ChatColor.YELLOW + "채팅 검열 : " + ChatColor.LIGHT_PURPLE +  "OP+++ " + ChatColor.AQUA  + "레벨");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        return item;
	}
}
