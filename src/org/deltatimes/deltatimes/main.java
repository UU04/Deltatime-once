package org.deltatimes.deltatimes;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.deltatimes.deltatimes.GUI.graphic;
import org.deltatimes.deltatimes.admin.trails;
import org.deltatimes.deltatimes.items.block;
import org.deltatimes.deltatimes.nickchat.nickchatapi;
import org.deltatimes.deltatimes.nickchat.nicklist;
import org.deltatimes.deltatimes.skills.spir;
import org.deltatimes.deltatimes.support.invclick;
import org.deltatimes.deltatimes.nickchat.nickchatapi;

public class main extends JavaPlugin implements Listener {

	public static HashMap<UUID, Integer> autos = new HashMap<UUID, Integer>(); // personal settings 반복 ID값 원본

	public static HashMap<UUID, String> nickname = new HashMap<UUID, String>(); // personal prefered nickname

	public static HashMap<UUID, String> wnick = new HashMap<UUID, String>(); // 닉네임 변경 가능 유무 boolean(true, false) -
																				// /nick
	public static HashMap<UUID, Integer> chatdvl = new HashMap<UUID, Integer>(); // Chat Censor level Integer save
																					// server - settings(personal)
	public static HashMap<UUID, Integer> sfxlvl = new HashMap<UUID, Integer>();
	public HashMap nickservice = nickchatapi.nickservice;
	
//	public static HashMap<UUID, String>  = new HashMap<UUID, String>();

	public float walkSpeed = 0.2F;

	@Override
	public void onEnable() {

		ConsoleCommandSender consol = Bukkit.getConsoleSender();

		consol.sendMessage(ChatColor.AQUA
				+ "---------------------------------------------------------------------------------------------");
		consol.sendMessage(ChatColor.AQUA + "");
		consol.sendMessage(ChatColor.AQUA + "	*	*	DeltaTimes 플러그인이 정상작동 중입니다		*	*	");
		consol.sendMessage(ChatColor.AQUA + "");
		consol.sendMessage(ChatColor.AQUA
				+ "---------------------------------------------------------------------------------------------");

		getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getPluginManager().registerEvents(new invclick(), this);
		this.getServer().getPluginManager().registerEvents(new block(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerLogEvent(), this);
		this.getServer().getPluginManager().registerEvents(new nickchatapi(), this);
		// getCommand("w").setExecutor(new foradmins());

		nicklist.set();

		int count;

		count = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				Random rand = new Random();
				int a = -55 + rand.nextInt(66);
				int b = 101 + rand.nextInt(4);
				int c = 347;

				Location loc = new Location(Bukkit.getServer().getWorld("world"), a, b, c);
				voids.newfireworkrandom(loc, 0);
			}
		}, 0L, 7L);
	}

	@EventHandler
	public void useevent(PlayerInteractEvent e) {
		
		ItemStack it = e.getPlayer().getItemInHand();
		
		if (it == null)
			return;
		if (it.getItemMeta() == null)
			return;
		if (it.getData() == null)
			return;
		if (e.getPlayer().getInventory() == null)
			return;
		if (it.getType() == Material.AIR)
			return;
		if (it.getItemMeta() == null)
			return;
		if (it.getItemMeta().getDisplayName() == null)
			return;
		if (it.getItemMeta().getDisplayName().contains("신규 접속자용 닉네임 설정권")) {
			e.getPlayer().getInventory().getItemInMainHand().setAmount(0);
			voids.newnick(e.getPlayer());
			return;
		}
		if (it.getItemMeta().getDisplayName().contains("[DTZ] 델타타임즈 설정")) {
			
			voids.settings(e.getPlayer());
			return;
		}
		if(it.getItemMeta().getDisplayName().contains("수리검")) {
			spir.SpawnSpir(e.getPlayer());
			return;
		}
		else {
			return;
		}
	}

	// chats 호칭 연동해서 CODE 다시, Fat DP 접속량 분배 컴포넌트 use

	

	@EventHandler
	public void justcmd(PlayerCommandPreprocessEvent e) {
		Bukkit.broadcastMessage(ChatColor.YELLOW + e.getMessage());
		// e.getmessage() 메서드 호출 시 받는 값 : /가나다

		if (e.getMessage().contains("/plugin") || e.getMessage().contains("/pl") || e.getMessage().contains("/me")
				|| e.getMessage().contains("/teammsg")) {
			e.getPlayer().sendMessage(ChatColor.RED + "해당 명령어는 사용하실 수 없습니다, 죄송합니다.");
			e.setCancelled(true);
		}
		if (e.getMessage().contains("/채팅")) {
			String a = e.getMessage().replace("/채팅 ", "");
			main.chatdvl.put(e.getPlayer().getUniqueId(), Integer.parseInt(a));
		}
		if (e.getMessage().contains("/긴급")) {
			org.deltatimes.deltatimes.admin.lockdown.lockdownSOS(e.getPlayer());
		}
		if (e.getMessage().contains("/리")) {
			Player w = e.getPlayer();
			w.setAllowFlight(true);
			w.setWalkSpeed(walkSpeed);
			w.setFlying(true);
			w.setSaturation(0);
		}

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("nick")) {
			Player p = Bukkit.getPlayer(sender.getName());
			if (!wnick.containsKey(p.getUniqueId()) || wnick.get(p.getUniqueId()) == "false") {
				sender.sendMessage(ChatColor.RED + "명령어 고유 접속 TOKEN 이 플레이어에게 존재하지 않습니다.");
				return true;
			}
			if ((args.length == 1)) {
				if (args[0].toString().length() >= 7) {
					sender.sendMessage(ChatColor.RED + "7자 이상 입력할 수 없습니다.(ERROR)");
					return true;
				}

				nickname.put(p.getUniqueId(), args[0]);
				p.sendMessage(ChatColor.GREEN + "닉네임 변경에 성공하셨습니다!");
				p.sendMessage(ChatColor.WHITE + "이제 채팅에서는 다음과 같은 닉네임이 붙습니다 : " + args[0]);
				wnick.put(p.getUniqueId(), "false"); //used chance to change name
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "닉네임 설정을 실패했습니다!(ERROR)");
				sender.sendMessage(ChatColor.GRAY + "(시스템이 인정하지 못하는 단어가 포함되어 있을 수 있습니다<특수문자, 공백 등>)");
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("testw")) {
			Bukkit.getScheduler().cancelTask(org.deltatimes.deltatimes.admin.trails.taskID);
		}

		if (cmd.getName().equalsIgnoreCase("test")) {
			if (!sender.isOp())
				return true;

			nickservice.put(Bukkit.getPlayer(sender.getName()).getUniqueId(),
					org.deltatimes.deltatimes.nickchat.nicklist.NICKninja);
		}

		else {
		}

		return true;

	}
}
