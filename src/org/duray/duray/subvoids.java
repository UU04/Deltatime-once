package org.duray.duray;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class subvoids {

	public static HashMap<Player, Boolean> web = new HashMap<Player, Boolean>();
	
	public static void EventLoopChk(Player p) {
		int c;
		c = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getPlugin(main.class), new Runnable() {
			@Override
			public void run() {
				if(!web.containsKey(p)) return;
				if(web.get(p) == true) {
					try {
						TimeUnit.SECONDS.sleep(1);
						web.put(p, false);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, 0L, 1L);
	}
}
