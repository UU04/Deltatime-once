package org.deltatimes.deltatimes;

import java.lang.reflect.Array;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.deltatimes.deltatimes.items.item;

import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.PacketPlayOutChat;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;

public class voids {
	public static Inventory settings = Bukkit.createInventory(null, 27,
			ChatColor.DARK_BLUE + "PERSONAL SETTINGS" + ChatColor.YELLOW + " #2284#");

	public static void newnick(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27,
				ChatColor.RED + "" + ChatColor.BOLD + "[닉네임 변경] " + ChatColor.BLUE + "#3159#");
		inv.setItem(12, item.noPick());
		inv.setItem(14, item.nickgui());

		p.openInventory(inv);
	}

	public static void jobpick(Player p) {

		Inventory job = Bukkit.createInventory(null, 27,
				ChatColor.WHITE + "JOB SELECTION" + ChatColor.YELLOW + " #0828#");
		job.setItem(0, org.deltatimes.deltatimes.items.job.waitforupdate());
		job.setItem(2, org.deltatimes.deltatimes.items.job.waitforupdate());
		job.setItem(4, org.deltatimes.deltatimes.items.job.waitforupdate());
		job.setItem(6, org.deltatimes.deltatimes.items.job.waitforupdate());
		job.setItem(8, org.deltatimes.deltatimes.items.job.waitforupdate());

		job.setItem(18, org.deltatimes.deltatimes.items.job.waitforupdate());
		job.setItem(20, org.deltatimes.deltatimes.items.job.waitforupdate());
		job.setItem(22, org.deltatimes.deltatimes.items.job.waitforupdate());
		job.setItem(24, org.deltatimes.deltatimes.items.job.waitforupdate());
		job.setItem(26, org.deltatimes.deltatimes.items.job.waitforupdate());
		p.openInventory(job);
	}

	public static void settings(Player p) {

		settings1();

		p.openInventory(settings);
	}

	public static void settings1() {
		settings.setItem(11, org.deltatimes.deltatimes.items.setting.sec());
		settings.setItem(13, org.deltatimes.deltatimes.items.setting.dat());
		settings.setItem(15, org.deltatimes.deltatimes.items.setting.dlc());
		settings.setItem(0, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(1, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(2, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(3, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(4, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(5, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(6, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(7, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(8, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(9, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(10, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(12, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(14, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(16, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(17, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(18, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(19, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(20, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(21, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(22, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(23, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(24, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(25, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(26, org.deltatimes.deltatimes.items.setting.noitem());
	}

	public static void contents(Player p) {
		for (int i = 0; i < 27; i++) {
			if (i == 13)
				continue;
			settings.setItem(i, org.deltatimes.deltatimes.items.setting.noitem());
			continue;
		}
		settings.setItem(13, org.deltatimes.deltatimes.items.setting.particle(3));
		p.openInventory(settings);
	}

	public static void chatsett(Player p) {
		chatsett1();

		switch (main.chatdvl.get(p.getUniqueId())) {
		case 0:
			settings.setItem(11, org.deltatimes.deltatimes.items.setting.chat0());
			break;
		case 1:
			settings.setItem(11, org.deltatimes.deltatimes.items.setting.chat1());
			break;
		case 2:
			settings.setItem(11, org.deltatimes.deltatimes.items.setting.chat2());
			break;
		case 3:
			settings.setItem(11, org.deltatimes.deltatimes.items.setting.chat3());
			break;
		}
		if (p.isOp()) {
			settings.setItem(11, org.deltatimes.deltatimes.items.setting.chatadmin());
		}

		p.openInventory(settings);
	}

	public static void chatsett1() {
		settings.setItem(11, org.deltatimes.deltatimes.items.setting.chat0());
		settings.setItem(13, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(15, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(0, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(1, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(2, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(3, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(4, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(5, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(6, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(7, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(8, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(9, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(10, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(12, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(14, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(16, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(17, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(18, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(19, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(20, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(21, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(22, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(23, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(24, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(25, org.deltatimes.deltatimes.items.setting.noitem());
		settings.setItem(26, org.deltatimes.deltatimes.items.setting.noitem());
	}

	public static void newfireworkrandom(Location loc, int a) {

		// Spawn the Firework, get the FireworkMeta.
		Firework fw = (Firework) Bukkit.getServer().getWorld("world").spawnEntity(loc, EntityType.FIREWORK);
		FireworkMeta fwm = fw.getFireworkMeta();

		// Our random generator
		Random r = new Random();

		// Get the type
		int rt = r.nextInt(4) + 1;
		Type type = Type.BALL;
		if (rt == 1)
			type = Type.BALL;
		if (rt == 2)
			type = Type.BALL_LARGE;
		if (rt == 3)
			type = Type.BURST;
		if (rt == 4)
			type = Type.CREEPER;
		if (rt == 5)
			type = Type.STAR;

		// Get our random colours
		int r1i = r.nextInt(17) + 1;
		int r2i = r.nextInt(17) + 1;
		Color c1 = getColor(r1i);
		Color c2 = getColor(r2i);

		// Create our effect with this
		FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type)
				.trail(r.nextBoolean()).build();

		// Then apply the effect to the meta
		fwm.addEffect(effect);

		// Generate some random power and set it
		int rp = r.nextInt(2) + 1;
		fwm.setPower(rp);

		// Then apply this to our rocket
		fw.setFireworkMeta(fwm);
	}

	private static Color getColor(int i) {
		Color c = null;
		if (i == 1) {
			c = Color.AQUA;
		}
		if (i == 2) {
			c = Color.BLACK;
		}
		if (i == 3) {
			c = Color.BLUE;
		}
		if (i == 4) {
			c = Color.FUCHSIA;
		}
		if (i == 5) {
			c = Color.GRAY;
		}
		if (i == 6) {
			c = Color.GREEN;
		}
		if (i == 7) {
			c = Color.LIME;
		}
		if (i == 8) {
			c = Color.MAROON;
		}
		if (i == 9) {
			c = Color.NAVY;
		}
		if (i == 10) {
			c = Color.OLIVE;
		}
		if (i == 11) {
			c = Color.ORANGE;
		}
		if (i == 12) {
			c = Color.PURPLE;
		}
		if (i == 13) {
			c = Color.RED;
		}
		if (i == 14) {
			c = Color.SILVER;
		}
		if (i == 15) {
			c = Color.TEAL;
		}
		if (i == 16) {
			c = Color.WHITE;
		}
		if (i == 17) {
			c = Color.YELLOW;
		}

		return c;
	}

	public static Location staredlocation(Player player) {
		return player.getTargetBlock(null, 200).getLocation();
	}

	public static void SendClickText(String Caption, String HoverText, String Action, Player p) {
		
		IChatBaseComponent comp = ChatSerializer.a("{\"text\":\"welCome to my server! \", \"extra\":[{\"text\":\"ClickHere\", \"hoverEvent\":{\"action\":\"show_text\", \"value\":\"COOL\"}}]}");
		PacketPlayOutChat packet = new PacketPlayOutChat(comp);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}

	public static String NoShowLogoTitle() {
		return "          _                                    \n" + "   |     | |              o                    \n"
				+ " __|  _  | | _|_  __  _|_     _  _  _   _      \n"
				+ "/  | |/  |/   |  /  |  |  |  / |/ |/ | |/  / \\ \n"
				+ "\\_/|_|__/|__/ |_/\\_/|_ |_/|_/  |  |  |_|__/ \\/ \n"
				+ "                                              \n" + "                                              ";
	}

	public static void New_User(Player p) { // Greet
		p.sendMessage(NoShowLogoTitle());
		p.sendMessage("");
		p.sendMessage(ChatColor.WHITE + "            * WELCOME TO DELTATIMES! * ");
		p.sendMessage(ChatColor.GRAY + " Please Select Your Language :");

	}

	public static void Tutorial(Player p) { // tutorial(May not be new user)

	}
}
