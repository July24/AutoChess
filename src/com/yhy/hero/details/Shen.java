package com.yhy.hero.details;

import com.yhy.hero.Hero;
import com.yhy.job.BladeMaster;
import com.yhy.race.Ninja;

public class Shen extends Hero implements BladeMaster, Ninja {
	public Shen() {
		name  = "Shen";
		title = "暮光之眼";
		price = 2;
		//TODO
		skillName = "待开发";
		skillDesc = "待开发";
	}
	
	protected void skill() {
		//TODO
	}
}
