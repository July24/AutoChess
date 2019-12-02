package com.yhy.flow;

import com.yhy.Player;

public class FlowConst {
	public static String SEPERATE	= "******************************";
	public static String LINE 		= "==============================";
	
	public static String playerInfo(Player player) {
		StringBuilder sb = new StringBuilder();
		sb.append(" 等级:  " + player.getLevel() + " 经验:  " + player.getExp());
		sb.append(" 金钱:  " + player.getMoney());
		return sb.toString();
	}
}
