package org.deltatimes.deltatimes.GUI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class graphic {
	
	private static Scoreboard board;
	private static Objective obj;
	private static Score score;
	public static ScoreboardManager sm = Bukkit.getScoreboardManager();
	
	public static HashMap<UUID, Integer> web = new HashMap<UUID, Integer>(); 
	
	public Player target;
	
	public static String TotalDate;
	public static String TotalTime;
	
	public int wart;
	//hex tir % 2
	
	public static String year;
	public static String month;
	public static String day;
	
	public int count;
	
	//hex tir % 3
	
	public static String hour;
	public static String minute;
	public static String second;
	
	//hex tir % 4
	
	public static boolean ampm;
	
	
	//hex tir % 5(dtox a-6)
	
	//안씀
	
	public static void showScoreboard(Player p) {
	    if(p.getScoreboard().equals(Bukkit.getServer().getScoreboardManager().getMainScoreboard())) p.setScoreboard(Bukkit.getServer().getScoreboardManager().getNewScoreboard()); //Per-player scoreboard, not necessary if all the same data, but we're personalizing the displayname and all
	    Scoreboard score = p.getScoreboard(); //Personalized scoreboard
	    Objective objective = score.getObjective(p.getName()) == null ? score.registerNewObjective(p.getName(), "dummy") : score.getObjective(p.getName()); //Per-player objectives, even though it doesn't matter what it's called since we're using per-player scoreboards.
	    String displayName = ChatColor.YELLOW + "Admin Panel : " + p.getName();
	    objective.setDisplayName(displayName);
	    
	    Player target = p;
	    
	    replaceScore(objective, 14, ChatColor.DARK_PURPLE + "");
	    replaceScore(objective, 13, ChatColor.GOLD + "닉네임 " + ChatColor.WHITE + ": "+ target.getDisplayName());
	    replaceScore(objective, 12, ChatColor.YELLOW + "직업 " + ChatColor.WHITE + ": " + ChatColor.RED  + "NULL");
	    replaceScore(objective, 11, ChatColor.DARK_GRAY + "");
	    replaceScore(objective, 10, ChatColor.WHITE + "날짜 |  " + ChatColor.WHITE + TotalDate);
	    replaceScore(objective, 9, ChatColor.WHITE + "시간 |  " + ChatColor.WHITE + TotalTime);
	    replaceScore(objective, 8, ChatColor.DARK_RED+ "");
	    replaceScore(objective, 7, ChatColor.GREEN  +"온라인 유저" + ChatColor.WHITE + ": " + Bukkit.getOnlinePlayers().toArray().length);
	    replaceScore(objective, 6, ChatColor.RED + "누적 신고 수 " + ChatColor.WHITE + ": 0");
	    replaceScore(objective, 5, ChatColor.AQUA + "서버 상태 " + ChatColor.WHITE + ": " + ChatColor.RED  +" - ");
	    replaceScore(objective, 4, ChatColor.DARK_BLUE + "");
	    replaceScore(objective, 3, ChatColor.GRAY + "- - 1.12.2 현실경제 델타타임즈 - -");
	    replaceScore(objective, 2, ChatColor.GRAY + "[스탯창 켜기/끄기] - "  + "/스탯" + ChatColor.GRAY + " <ON/OFF>");
	    replaceScore(objective, 1, ChatColor.DARK_AQUA + "");
	    replaceScore(objective, 0, ChatColor.RED + "* 운영자 모드가 활성화되어 있습니다! *");
	    
	    if(objective.getDisplaySlot() != DisplaySlot.SIDEBAR) objective.setDisplaySlot(DisplaySlot.SIDEBAR); //Vital functionality
	    p.setScoreboard(score); //Vital functionality
	}
	
	public static String getEntryFromScore(Objective o, int score) {
	    if(o == null) return null;
	    if(!hasScoreTaken(o, score)) return null;
	    for (String s : o.getScoreboard().getEntries()) {
	        if(o.getScore(s).getScore() == score) return o.getScore(s).getEntry();
	    }
	    return null;
	}

	public static boolean hasScoreTaken(Objective o, int score) {
	    for (String s : o.getScoreboard().getEntries()) {
	        if(o.getScore(s).getScore() == score) return true;
	    }
	    return false;
	}

	public static void replaceScore(Objective o, int score, String name) {
	    if(hasScoreTaken(o, score)) {
	        if(getEntryFromScore(o, score).equalsIgnoreCase(name)) return;
	        if(!(getEntryFromScore(o, score).equalsIgnoreCase(name))) o.getScoreboard().resetScores(getEntryFromScore(o, score));
	    }
	    o.getScore(name).setScore(score);
	}
	
	public static void getdatetime() {
		ampm = false;
		String thisTail;
	    LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH");
	    DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("mm");
	    DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("ss");
	    DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("yyyy");
	    DateTimeFormatter myFormatObj4 = DateTimeFormatter.ofPattern("MM");
	    DateTimeFormatter myFormatObj5 = DateTimeFormatter.ofPattern("dd");
	    String formattedDate = myDateObj.format(myFormatObj);
	    String formattedDate1 = myDateObj.format(myFormatObj1);
	    String formattedDate2 = myDateObj.format(myFormatObj2);
	    String formattedDate3 = myDateObj.format(myFormatObj3); //년도
	    String formattedDate4 = myDateObj.format(myFormatObj4); //월
	    String formattedDate5 = myDateObj.format(myFormatObj5); //날
	   
	    int yay = Integer.parseInt(formattedDate);
	     
	    if(yay >= 13) {
	    	//13시 - 24시일 시 
	    	ampm = true;
	    	hour = Integer.toString(yay - 12);
	    	thisTail = "오후";
	    }else {
	    	hour = Integer.toString(yay);
	    	thisTail = "오전";
	    }
	    
	    
	    //TotalTime = thisTail + " " + hour + "시 " + formattedDate1 + "분 " + formattedDate2 + "초";
	    TotalTime = thisTail + " " + hour + "시 " + formattedDate1 + "분 " + formattedDate2 + "초";
	    TotalDate = formattedDate3 + "년 " + formattedDate4 + "월 " + formattedDate5 + "일";
	    
	}
	
	public static void groot(UUID its) {
		Player p = (Player) Bukkit.getPlayer(its);
		showScoreboard(p);
	}
}