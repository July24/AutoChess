package com.yhy.hero.details;

import com.yhy.hero.Hero;
import com.yhy.job.Assassin;
import com.yhy.race.Imperial;

public class Katarina extends Hero implements Assassin, Imperial{
	public Katarina() {
		name  = "Katarina";
		title = "不祥之刃";
		price = 2;
		//TODO
		skillName = "待开发";
		skillDesc = "待开发";
	}
	
	protected void skill() {
		//TODO
	}
}
