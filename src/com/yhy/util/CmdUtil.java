package com.yhy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CmdUtil {
	private static Pattern pattern;

	public static final String COMMON_MENU_EXIT      = "exit";
	
	private static final String REGEX_HEROSHOP_COMMAND = "^([0-5])$";
	private static final String REGEX_HEROSHOP_MENU    = "^(exit|refresh)$";
	public static final String HEROSHOP_MENU_REFRESH   = "refresh";
	
	private static final String REGEX_PREPARE_MENU	= "^(lineup|check|shop|buyexp|area|go)$";
	public static final String PREPARE_MENU_LINEUP	= "lineup";
	public static final String PREPARE_MENU_CHECK 	= "check";
	public static final String PREPARE_MENU_SHOP    = "shop";
	public static final String PREPARE_MENU_BUYEXP	= "buyexp";
	public static final String PREPARE_MENU_AREA	= "area";
	public static final String PREPARE_MENU_GO  	= "go";
	
	private static final String REGEX_LINEUP_COMMAND	= "^([1-9])$";
	private static final String REGEX_LINEUP_MENU    = "^(exit)$";
	
	private static final String REGEX_LINEUPINFO_COMMAND	= "^([1-9])$";
	private static final String REGEX_LINEUPINFO_MENU    = "^(exit)$";

	private static final String REGEX_CHECK_MENU    = "^(exit)$";

	private static final String REGEX_HEROREPLACE_MENU	= "^(exit|area|chess|end)$";
	public static final String HEROREPLACE_MENU_AREA	= "area";
	public static final String HEROREPLACE_MENU_CHESS	= "chess";
	public static final String HEROREPLACE_MENU_END	= "end";

	private static final String REGEX_HEROREPLACEFROMCHESS_COMMAND	= "^([1-9])$";
	private static final String REGEX_HEROREPLACEFROMCHESS_MENU    = "^(exit)$";
	
	public static boolean heroReplaceMenuInMatch(String content) {
		return inMatch(REGEX_HEROREPLACE_MENU, content);
	}
	
	public static boolean lineUpInfoCmdInMatch(String regex, String content) {
		return inMatch(regex, content);
	}
	
	public static boolean heroReplaceFromBoardCmdInMatch(String content) {
		return inMatch(REGEX_HEROREPLACEFROMCHESS_COMMAND, content);
	}
	
	public static boolean heroReplaceFromBoardMenuInMatch(String content) {
		return inMatch(REGEX_HEROREPLACEFROMCHESS_MENU, content);
	}
	
	public static boolean lineUpCmdInMatch(String content) {
		return inMatch(REGEX_LINEUP_COMMAND, content);
	}
	
	public static boolean lineUpMenuInMatch(String content) {
		return inMatch(REGEX_LINEUP_MENU, content);
	}
	
	public static boolean CheckMenuInMatch(String content) {
		return inMatch(REGEX_CHECK_MENU, content);
	}
	
	public static boolean parepareMenuInMatch(String content) {
		return inMatch(REGEX_PREPARE_MENU, content);
	}
	
	public static boolean heroShopCmdInMatch(String content) {
		return inMatch(REGEX_HEROSHOP_COMMAND, content);
	}
	
	public static boolean heroShopMenuInMatch(String content) {
		return inMatch(REGEX_HEROSHOP_MENU, content);
	}
	
	public static boolean inMatch(String regex, String content) {
		pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(content);
		return m.matches();
	}
	
	public static void main(String[] args) {
//		System.out.println(CmdUtil.inMatch("^(exit|refresh)$", "Exit"));
//		System.out.println(inMatch("^([1-0])$", "1"));
		System.out.println((3) / 3);
	}
}
