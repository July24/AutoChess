package com.yhy.hero.details;

import com.yhy.hero.Hero;
import com.yhy.job.BladeMaster;
import com.yhy.race.Imperial;

public class Darius extends Hero implements BladeMaster, Imperial{
	public Darius() {
		name  = "Darius";
		title = "诺克萨斯之手";
		price = 2;
		//TODO
		skillName = "ħ������";
		skillDesc = "��ͨ������Ϊ �����һ��";
	}
	
	protected void skill() {
		//TODO
	}
}
