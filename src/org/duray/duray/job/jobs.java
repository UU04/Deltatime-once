package org.duray.duray.job;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class jobs {
	public static HashMap<UUID, String> Job = new HashMap<UUID, String>();
	
	public static void Inject(Player p, String job) { 
		if(!Job.containsKey(p.getUniqueId())) Job.put(p.getUniqueId(), "null");
		
		System.out.println(p.getDisplayName() + " - Job Value " + "[" + Job.get(p.getUniqueId())+"] >>> " + "[" + job + "]");
		Job.put(p.getUniqueId(), job);
	}
	
	public static String Get(Player p) {
		if(!Job.containsKey(p.getUniqueId())) Reset(p);
		return Job.get(p.getUniqueId());
	}
	
	public static void Reset(Player p) {
		if(!Job.containsKey(p.getUniqueId())) Job.put(p.getUniqueId(), "null");
		System.out.println(p.getDisplayName() + " - Job Value " + "[" + Job.get(p.getUniqueId())+"] >>> " + "[" + "null" + "]");
		Job.put(p.getUniqueId(), "null");
	}
	
	public static String Colorized_JobSel(Player p) {
		String k = Get(p);
		if(k.contains("")) {
			
		}
		return k;
	}
}
