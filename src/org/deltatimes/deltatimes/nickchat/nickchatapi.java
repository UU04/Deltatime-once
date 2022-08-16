package org.deltatimes.deltatimes.nickchat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.deltatimes.deltatimes.main;

public class nickchatapi implements Listener{
	public HashMap<UUID, String>nickname = main.nickname; //custom
	
	public static HashMap<UUID, String> nickservice = new HashMap<UUID, String>(); //job


	public static boolean ChatScan(String a) {
		File file = new File("C:/Users/UU_04/eclipse-workspace/DeltaTimes-main/fword_list.txt");
		
		String fileContent = "";
		try {
			Scanner scan = new Scanner(file);
			
			while(scan.hasNextLine()) {
				fileContent = fileContent.concat(scan.nextLine() + "\n");
			}
			
			if(fileContent.contains(a)) return false;
			if(!fileContent.contains(a)) return true;
			return false;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@EventHandler
	public void chats(PlayerChatEvent e) {

		e.setCancelled(true);
		
		Player p = e.getPlayer();
		String pl = e.getPlayer().getDisplayName();
		String msg = e.getMessage();

		if(ChatScan(msg) == false) {
			p.sendMessage(ChatColor.RED + " [!] ¿å¼³ ÀÚÁ¦ ºÎÅ¹µå¸³´Ï´Ù. ");
		}
		
		if (!nickname.containsKey(e.getPlayer().getUniqueId())) {
			nickname.put(e.getPlayer().getUniqueId(), "");
		}

		String nick = "[" + nickname.get(e.getPlayer().getUniqueId()) + "]";

		String a;

		if (nickservice.containsKey(e.getPlayer().getUniqueId())) {
			a = nickservice.get(e.getPlayer().getUniqueId());
		} else {
			a = ChatColor.RED + "NULL";
		}

		Bukkit.broadcastMessage(ChatColor.GRAY + "<" + nick + " " + pl + "> " + a + ChatColor.WHITE + " | " + msg);
	}
}
