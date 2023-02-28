package org.duray.duray.sound;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class jukebox {
	public static void UI_Button(Player p) {
		p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 0.6F, 1);
	}
	
	public static void Not_Allowed(Player p) {
		p.playSound(p.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 2F, 1);
	}
	
	public static void Money_Sale(Player p) {
		p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BELL, 0.6F, 0.7F);
	}
	
	public static void Money_Work(Player p) {
		p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_FLOP, 0.6F, 1F);
		p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_FLOP, 0.6F, 1F);
	}
	
	public static void Bell(Player p) {
		p.playSound(p.getLocation(), Sound.BLOCK_NOTE_HARP, 1.6F, 1.75F);
	}
}
