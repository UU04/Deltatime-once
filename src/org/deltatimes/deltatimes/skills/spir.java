package org.deltatimes.deltatimes.skills;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;
import org.deltatimes.deltatimes.main;

public class spir {
	public static ItemStack lev1() {
		ItemStack item = new ItemStack(Material.FIREWORK_CHARGE);
        ItemMeta meta = item.getItemMeta();
        
        meta.setDisplayName(ChatColor.YELLOW + "[★] 수리검");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.setLore(Arrays.asList( ChatColor.AQUA +  "" + ChatColor.BOLD + "RARE","", "", ChatColor.WHITE + " : DAMAGE   " + ChatColor.RED + "" + ChatColor.BOLD + "3", "", "", ChatColor.GRAY + " > 수리검이 날아간다."));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        
        
        return item;
	}
	
	public static void SpawnSpir(Player p){
		ArmorStand tall = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
		tall.setGravity(false);
		
		Vector unitVector = new Vector(p.getLocation().getDirection().getX(),p.getLocation().getDirection().getY(),p.getLocation().getDirection().getZ());
		unitVector = unitVector.normalize();
		unitVector.multiply(2.2);
		
		tall.setVelocity(unitVector);
		
		Location loc = p.getLocation();
		
		tall.getWorld().playEffect( loc, Effect.MOBSPAWNER_FLAMES, 0);
		
		int a = 0;
		
		Location demo = p.getLocation().add(0, 200, 0);
		ArmorStand blade1 = (ArmorStand) tall.getWorld().spawnEntity(demo, EntityType.ARMOR_STAND);
		ArmorStand blade2 = (ArmorStand) tall.getWorld().spawnEntity(demo, EntityType.ARMOR_STAND);
		ArmorStand blade3 = (ArmorStand) tall.getWorld().spawnEntity(demo, EntityType.ARMOR_STAND);
		ArmorStand blade4 = (ArmorStand) tall.getWorld().spawnEntity(demo, EntityType.ARMOR_STAND);
		
		blade1.setGravity(false);
		blade2.setGravity(false);
		blade3.setGravity(false);
		blade4.setGravity(false);
		
		int w ,e , n;
		w = 270;
		e = 0;
		n = 80;
		
		blade1.setArms(true);
		blade1.setItemInHand(new ItemStack(Material.DIAMOND_AXE));
		blade1.setRightArmPose(new EulerAngle(w, e, n));
		blade2.setArms(true);
		blade2.setItemInHand(new ItemStack(Material.DIAMOND_AXE));
		blade2.setRightArmPose(new EulerAngle(w, e, n));
		blade3.setArms(true);
		blade3.setItemInHand(new ItemStack(Material.DIAMOND_AXE));
		blade3.setRightArmPose(new EulerAngle(w, e, n));
		blade4.setArms(true);
		blade4.setItemInHand(new ItemStack(Material.DIAMOND_AXE));
		blade4.setRightArmPose(new EulerAngle(w, e, n));
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getPlugin(main.class), new Runnable() {
			double var = 0;
			Location loc, first, second, third, fourth;
			@Override
			public void run() {
				
				
				var += Math.PI / 16;
				
				loc = tall.getLocation();
				first = loc.clone().add(Math.cos(var), -0.5, Math.sin(var));
				second = loc.clone().add(Math.cos(var + Math.PI), -0.5, Math.sin(var + Math.PI));
				third = loc.clone().add(Math.cos(var + Math.PI /2), -0.5, Math.sin(var + Math.PI /2));
				fourth = loc.clone().add(Math.cos(var - Math.PI /2), -0.5, Math.sin(var - Math.PI/2));
				
				blade1.teleport(first);
				blade2.teleport(second);
				blade3.teleport(third);
				blade4.teleport(fourth);
				
			}
		}, 0L, 1L);
	}
}
