package com.yhy.hero.details;

import com.yhy.hero.Hero;
import com.yhy.job.Assassin;
import com.yhy.race.Ninja;

public class Zed extends Hero implements Assassin, Ninja{
	public Zed() {
		name  = "Zed";
		title = "影流之主";
		price = 2;
		//TODO
		skillName = "待开发";
		skillDesc = "待开发";
	}
	
	protected void skill() {
		//TODO
	}
}
