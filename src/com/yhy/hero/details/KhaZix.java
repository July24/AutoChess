package com.yhy.hero.details;

import com.yhy.hero.Hero;
import com.yhy.job.Assassin;
import com.yhy.race.DarkVoid;

public class KhaZix extends Hero implements Assassin, DarkVoid {
	public KhaZix() {
		name  = "Kha'Zix";
		title = "虚空掠夺者";
		price = 3;
		//TODO
		skillName = "ħ������";
		skillDesc = "��ͨ������Ϊ �����һ��";
	}
	
	protected void skill() {
		//TODO
	}
}
