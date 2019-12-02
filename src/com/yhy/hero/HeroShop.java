package com.yhy.hero;

public class HeroShop {
	private static int SHOP_HERO_COUNT = 5;
	private boolean lock;
	private Hero[] heros;
	private HeroPool heroPool;
	
	public HeroShop(HeroPool heroPool) {
		this.heroPool = heroPool;
		lock = false;
	}

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public Hero[] getHeros() {
		return heros;
	}

	public void setHeros(Hero[] heros) {
		this.heros = heros;
	}

	public HeroPool getHeroPool() {
		return heroPool;
	}

	public void setHeroPool(HeroPool heroPool) {
		this.heroPool = heroPool;
	}

	public void refreshShop() {
		if(heros != null) {
			returnRemainHero();
		}
		if(!lock) {
			heros = new Hero[SHOP_HERO_COUNT];
			for(int i = 0; i < SHOP_HERO_COUNT; i++) {
				heros[i] = heroPool.borrowHero((int)(heroPool.size() * Math.random()));
			}
		}
	}

	private void returnRemainHero() {
		for(int i = 0; i < SHOP_HERO_COUNT; i++) {
			Hero hero = heros[i];
			if(hero != null) {
				heroPool.returnHero(hero);
			}
		}
	}

	public void clearShop() {
		for(Hero hero : heros) {
			heroPool.returnHero(hero);
		}
		heros = null;
	}

	public void sellHero(Hero hero) {
		hero.resetStar();
		hero.resetOwnner();
		heroPool.returnHero(hero);
	}
}
