package com.yhy.hero;

import java.util.ArrayList;
import java.util.List;

/**
 * Ó¢ÐÛ³Ø
 */
public class HeroPool {
	List<Hero> heroList;
	
	public HeroPool() {
		heroList = new ArrayList<Hero>();
		//TODO
		for(int i = 0; i < 2; i++) {
			heroList.add(HeroFactory.getShyvana());
			heroList.add(HeroFactory.getPyke());
			heroList.add(HeroFactory.getKhaZix());
			heroList.add(HeroFactory.getZed());
			heroList.add(HeroFactory.getAkali());
			heroList.add(HeroFactory.getKatarina());
			heroList.add(HeroFactory.getEvelynn());
			heroList.add(HeroFactory.getDarius());
			heroList.add(HeroFactory.getShen());
			heroList.add(HeroFactory.getDraven());
			heroList.add(HeroFactory.getYasuo());
			heroList.add(HeroFactory.getFiora());
		}
	}
	
	public int size() {
		return heroList.size();
	}
	
	public Hero borrowHero(int index) {
		return heroList.remove(index);
	}
	
	public void returnHero(Hero hero) {
		heroList.add(hero);
	}
}
