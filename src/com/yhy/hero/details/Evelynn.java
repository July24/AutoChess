package com.yhy.hero.details;

import com.yhy.hero.Hero;
import com.yhy.job.Assassin;
import com.yhy.race.Demon;

public class Evelynn extends Hero implements Assassin, Demon {
	public Evelynn() {
		name  = "Evelynn";
		title = "痛苦之拥";
		price = 3;
		//TODO
		skillName = "ħ������";
		skillDesc = "��ͨ������Ϊ �����һ��";
	}
	
	protected void skill() {
		//TODO
	}
}
