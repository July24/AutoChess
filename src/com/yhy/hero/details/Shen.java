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
		skillName = "ħ������";
		skillDesc = "��ͨ������Ϊ �����һ��";
	}
	
	protected void skill() {
		//TODO
	}
}
