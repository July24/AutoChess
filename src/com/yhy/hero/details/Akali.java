package com.yhy.hero.details;

import com.yhy.hero.Hero;
import com.yhy.job.Assassin;
import com.yhy.race.Ninja;

public class Akali extends Hero implements Assassin, Ninja{
	public Akali() {
		name  = "Akali";
		title = "离群之刺";
		price = 2;
		//TODO
		skillName = "ħ������";
		skillDesc = "��ͨ������Ϊ �����һ��";
	}
	
	protected void skill() {
		//TODO
	}
}
