package com.yhy.hero.details;

import com.yhy.hero.Hero;
import com.yhy.job.Assassin;
import com.yhy.race.Pirate;

public class Pyke extends Hero implements Assassin, Pirate{
	public Pyke() {
		name  = "Pyke";
		title = "血港鬼影";
		price = 1;
		//TODO
		skillName = "待开发";
		skillDesc = "待开发";
	}
	
	protected void skill() {
		//TODO
	}
}
