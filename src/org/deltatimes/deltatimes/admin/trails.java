package org.deltatimes.deltatimes.admin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.deltatimes.deltatimes.main;

public class trails {
	public static int taskID;
	
	public static void admintrails(Player p) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getPlugin(main.class), new Runnable() {
			
			double var = 0;
			Location loc, first, second, third, fourth;
			
			@Override
			public void run() {
				var += Math.PI / 16;
				
				loc = p.getLocation();
				first = loc.clone().add(Math.cos(var), Math.sin(var) + 1, Math.sin(var));
				second = loc.clone().add(Math.cos(var + Math.PI), Math.sin(var) + 1, Math.sin(var + Math.PI));
				third = loc.clone().add(Math.cos(var + Math.PI /2), Math.sin(var) + 1, Math.sin(var + Math.PI /2));
				fourth = loc.clone().add(Math.cos(var - Math.PI /2), Math.sin(var) + 1, Math.sin(var - Math.PI/2));
				
				Particle local = Particle.FLAME;
				p.getWorld().spawnParticle(local, first, 0);
				p.getWorld().spawnParticle(local, second, 0);
				p.getWorld().spawnParticle(local, third, 0);
				p.getWorld().spawnParticle(local, fourth, 0);
			}
			
			
			
			
			
		}, 0, 5);
	}
}
