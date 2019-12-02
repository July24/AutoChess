package com.yhy.hero.details;

import com.yhy.hero.Hero;
import com.yhy.job.BladeMaster;
import com.yhy.race.Imperial;

public class Draven extends Hero implements BladeMaster, Imperial{
	public Draven() {
		name  = "Draven";
		title = "荣耀行刑官";
		price = 3;
		//TODO
		skillName = "ħ������";
		skillDesc = "��ͨ������Ϊ �����һ��";
	}
	
	protected void skill() {
		//TODO
	}
}
