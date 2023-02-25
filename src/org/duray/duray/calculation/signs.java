package org.duray.duray.calculation;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class signs {
public static String signchk(Player p, PlayerInteractEvent e) {
		
		Location a = e.getClickedBlock().getLocation();
		Location dull = a.add(0, 1, 0);
		Location one = new Location(e.getPlayer().getWorld(), dull.getX(), dull.getY(), dull.getZ()+1);
		dull = a;
		Location two = new Location(e.getPlayer().getWorld(), dull.getX()-1, dull.getY(), dull.getZ());
		dull = a;
		Location three = new Location(e.getPlayer().getWorld(), dull.getX()+1, dull.getY(), dull.getZ());
		dull = a;
		Location four = new Location(e.getPlayer().getWorld(), dull.getX(), dull.getY(), dull.getZ()-1);
		
		Material ga = one.getBlock().getType();
		Material na = two.getBlock().getType();
		Material da = three.getBlock().getType();
		Material ra = four.getBlock().getType();
		
		if(ga.toString().contains("SIGN")) return getcontent(one.getBlock());
		if(na.toString().contains("SIGN")) return getcontent(two.getBlock());
		if(da.toString().contains("SIGN")) return getcontent(three.getBlock());
		if(ra.toString().contains("SIGN")) return getcontent(four.getBlock());
		else return null;
		
		
	}
	
	public static String signchkdown(Player p, PlayerInteractEvent e) {
		Location a = e.getClickedBlock().getLocation();
		
		Location dull = a.add(0, 2, 0);
		
		if(dull.clone().add(0, -1, 0).getBlock().getType() == Material.DARK_OAK_DOOR) return null;
		
		Location one = new Location(e.getPlayer().getWorld(), dull.getX(), dull.getY(), dull.getZ()+1);
		dull = a;
		Location two = new Location(e.getPlayer().getWorld(), dull.getX()-1, dull.getY(), dull.getZ());
		dull = a;
		Location three = new Location(e.getPlayer().getWorld(), dull.getX()+1, dull.getY(), dull.getZ());
		dull = a;
		Location four = new Location(e.getPlayer().getWorld(), dull.getX(), dull.getY(), dull.getZ()-1);
		
		Material ga = one.getBlock().getType();
		Material na = two.getBlock().getType();
		Material da = three.getBlock().getType();
		Material ra = four.getBlock().getType();
		
		if(ga.toString().contains("SIGN")) return getcontent(one.getBlock());
		if(na.toString().contains("SIGN")) return getcontent(two.getBlock());
		if(da.toString().contains("SIGN")) return getcontent(three.getBlock());
		if(ra.toString().contains("SIGN")) return getcontent(four.getBlock());
		
		return null; //four if does not match.
		
	}
	
	public static String getcontent(Block local) {
		Sign sign = (Sign) local.getState();
		int count = sign.getLines().length;
		
		String a = sign.getLine(0);
		String b = sign.getLine(1);
		String c = sign.getLine(2);
		String d = sign.getLine(3);
		
		if(!a.contains("[") | !a.contains("]")) return null; //simple just sign
		
		String r1 = null;
		String r2= null;
		String r3 = null;
		String r4 = null;
		
		if(!(a.length() == 0) || !a.isEmpty()) r1 = a.replace("[", "").replace("]", "");
		if(!(b.length() == 0) || !b.isEmpty()) r2 = b.replace("[", "").replace("]", "");
		if(!(c.length() == 0) || !c.isEmpty()) r3 = c.replace("[", "").replace("]", "");
		if(!(d.length() == 0) || !d.isEmpty()) r4 = d.replace("[", "").replace("]", "");
		
		String roles = "";
		
		if(!(r1 == null)) roles = roles + r1;
		if(!(r2 == null)) roles = roles +"/"+r2;
		if(!(r3 == null)) roles = roles +"/"+ r3;
		if(!(r4 == null)) roles = roles +"/"+ r4;
		
		return roles;
		
	}
}
