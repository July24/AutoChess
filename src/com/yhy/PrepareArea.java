package com.yhy;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;

import com.yhy.hero.Hero;

public class PrepareArea {
	private List<Hero> prepareHero;
	private Player ownner;
	
	public PrepareArea(Player player) {
		prepareHero = new ArrayList<Hero>();
		ownner = player;
	}
	
	public Player getOwnner() {
		return ownner;
	}

	public void setOwnner(Player ownner) {
		this.ownner = ownner;
	}

	public boolean full() {
		return prepareHero.size() > 7;
	}
	
	public boolean addHero(Hero hero) {
		if(full()) {
			return false;
		}
		hero.setOwnner(ownner);
		prepareHero.add(hero);
		return true;
	}

	public List<Hero> getPrepareHero() {
		return prepareHero;
	}

	public void setPrepareHero(List<Hero> prepareHero) {
		this.prepareHero = prepareHero;
	}
	
	public Hero takeHero(int pos) {
		return prepareHero.remove(pos);
	}
}
