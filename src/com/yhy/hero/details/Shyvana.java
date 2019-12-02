package com.yhy.hero.details;

import com.yhy.hero.Hero;
import com.yhy.job.ShapeShifter;
import com.yhy.race.Dragon;

/**
  * ��Ѫ�伧
 */
public class Shyvana extends Hero implements ShapeShifter, Dragon{
	
	public Shyvana() {
		name  = "Shyvana";
		title = "龙血武姬";
		price = 2;
		skillName = "待开发";
		skillDesc = "待开发";
	}
	
	protected void skill() {
		attackType = 1;
	}
}
