package org.duray.duray.graphic;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.duray.duray.main;

public class asc {
	public static HashMap<UUID, Integer> BoardDisplay = new HashMap<UUID, Integer>();
	
	public static void BoardRegister(Player p, int key) {
		switch (key) {
		case 1:
			LoopNormalPlayers(p);
			break;
		
		case 2:
			break;
		default:
			break;
		}
	}
	
	public static void LoopNormalPlayers(final Player p) {
		int c;
		c = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getPlugin(main.class), new Runnable() {
			@Override
			public void run() {
				org.duray.duray.graphic.bars.MainBoard.showScoreboard(p);
				org.duray.duray.graphic.bars.MainBoard.getdatetime();
			}
		}, 0L, 1L);
		BoardDisplay.put(p.getUniqueId(), c);
	}
}
