package org.duray.duray.graphic.bars;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class MainBoard {
	
	public static ScoreboardManager sm = Bukkit.getScoreboardManager();
	
	public static HashMap<UUID, Integer> web = new HashMap<UUID, Integer>(); 
	
	public Player target;
	
	public static String TotalDate;
	public static String TotalTime;
	
	public static String year;
	public static String month;
	public static String day;
	public static String hour;
	public static String minute;
	public static String second;
	
	public static boolean ampm;
	
	public static void showScoreboard(Player p) {
	    if(p.getScoreboard().equals(Bukkit.getServer().getScoreboardManager().getMainScoreboard())) p.setScoreboard(Bukkit.getServer().getScoreboardManager().getNewScoreboard());
	    Scoreboard score = p.getScoreboard();
	    Objective objective = score.getObjective(p.getName()) == null ? score.registerNewObjective(p.getName(), "dummy") : score.getObjective(p.getName());
	    String displayName = ChatColor.YELLOW + "DeltaTimes - " + p.getName();
	    objective.setDisplayName(displayName);
	    
	    Player target = p;
	    
	    replaceScore(objective, 14, ChatColor.DARK_PURPLE + "");
	    replaceScore(objective, 13, ChatColor.GOLD + "닉네임 " + ChatColor.WHITE + ": "+ target.getDisplayName());
	    replaceScore(objective, 12, ChatColor.YELLOW + "직업 " + ChatColor.WHITE + ": " + org.duray.duray.job.jobs.Colorized_JobSel(p));
	    replaceScore(objective, 11, ChatColor.DARK_GRAY + "");
	    replaceScore(objective, 10, ChatColor.WHITE + "날짜 |  " + ChatColor.WHITE + TotalDate);
	    replaceScore(objective, 9, ChatColor.WHITE + "시간 |  " + ChatColor.WHITE + TotalTime);
	    replaceScore(objective, 8, ChatColor.DARK_RED+ "");
	    replaceScore(objective, 7, ChatColor.RED + org.duray.duray.job.bank.Short_Num(p) + ChatColor.GOLD  +" [G] ");
	    replaceScore(objective, 6, ChatColor.DARK_BLUE + "");
	    
	    if(objective.getDisplaySlot() != DisplaySlot.SIDEBAR) objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	    p.setScoreboard(score);
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
	    String formattedDate5 = myDateObj.format(myFormatObj5); //일
	   
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
	    
	    TotalTime = thisTail + " " + hour + "시 " + formattedDate1 + "분 " + formattedDate2 + "초";
	    TotalDate = formattedDate3 + "년 " + formattedDate4 + "월 " + formattedDate5 + "일";
	    
	}
}
