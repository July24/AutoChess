package com.yhy.hero;

import com.yhy.job.Assassin;
import com.yhy.job.BladeMaster;
import com.yhy.job.Brawler;
import com.yhy.job.ElementalList;
import com.yhy.job.Guardian;
import com.yhy.job.Gunslinger;
import com.yhy.job.Knight;
import com.yhy.job.Ranger;
import com.yhy.job.ShapeShifter;
import com.yhy.job.Sorcerer;
import com.yhy.race.DarkVoid;
import com.yhy.race.Demon;
import com.yhy.race.Dragon;
import com.yhy.race.Exiler;
import com.yhy.race.Glacial;
import com.yhy.race.Imperial;
import com.yhy.race.Ninja;
import com.yhy.race.Noble;
import com.yhy.race.Phantom;
import com.yhy.race.Pirate;
import com.yhy.race.Robot;
import com.yhy.race.Wild;
import com.yhy.race.Yordle;

/**
 * 	根据种族、职业进行英雄属性赋值
 */
public class HeroWorkshop {
	
	public static void heroAssembly(Hero hero) {
		heroRaceAssembly(hero);
		heroJobAssembly(hero);
	}

	private static void heroRaceAssembly(Hero hero) {
		if(hero instanceof DarkVoid) {
			//TODO
			dragonRace(hero);
		}
		if(hero instanceof Demon) {
			//TODO
			dragonRace(hero);
		}
		if(hero instanceof Dragon) {
			dragonRace(hero);
		}
		if(hero instanceof Exiler) {
			exilerRace(hero);
		}
		if(hero instanceof Glacial) {
			//TODO
			dragonRace(hero);
		}
		if(hero instanceof Imperial) {
			//TODO
			dragonRace(hero);
		}
		if(hero instanceof Ninja) {
			//TODO
			dragonRace(hero);
		}
		if(hero instanceof Noble) {
			//TODO
			dragonRace(hero);
		}
		if(hero instanceof Phantom) {
			//TODO
			dragonRace(hero);
		}
		if(hero instanceof Pirate) {
			//TODO
			dragonRace(hero);
		}
		if(hero instanceof Robot) {
			//TODO
			dragonRace(hero);
		}
		if(hero instanceof Wild) {
			//TODO
			dragonRace(hero);
		}
		if(hero instanceof Yordle) {
			//TODO
			dragonRace(hero);
		}
	}
	
	private static void dragonRace(Hero hero) {
		if(hero.getHp() < HeroTemplate.DRAGON_BASE_HP) {
			hero.setHp(HeroTemplate.DRAGON_BASE_HP);
		}
		if(hero.getAd() < HeroTemplate.DRAGON_BASE_AD) {
			hero.setAd(HeroTemplate.DRAGON_BASE_AD);
		}
		if(hero.getAp() < HeroTemplate.DRAGON_BASE_AP) {
			hero.setAp(HeroTemplate.DRAGON_BASE_AP);
		}
		if(hero.getArmor() > HeroTemplate.DRAGON_BASE_ARMOR) {
			hero.setArmor(HeroTemplate.DRAGON_BASE_ARMOR);
		}
		if(hero.getSpell_resistance() > HeroTemplate.DRAGON_BASE_SEPLLRESISTANCE) {
			hero.setSpell_resistance(HeroTemplate.DRAGON_BASE_SEPLLRESISTANCE);
		}
	}

	private static void exilerRace(Hero hero) {
		if(hero.getHp() < HeroTemplate.EXILER_BASE_HP) {
			hero.setHp(HeroTemplate.EXILER_BASE_HP);
		}
		if(hero.getAd() < HeroTemplate.EXILER_BASE_AD) {
			hero.setAd(HeroTemplate.EXILER_BASE_AD);
		}
		if(hero.getAp() < HeroTemplate.EXILER_BASE_AP) {
			hero.setAp(HeroTemplate.EXILER_BASE_AP);
		}
		if(hero.getArmor() > HeroTemplate.EXILER_BASE_ARMOR) {
			hero.setArmor(HeroTemplate.EXILER_BASE_ARMOR);
		}
		if(hero.getSpell_resistance() > HeroTemplate.EXILER_BASE_SEPLLRESISTANCE) {
			hero.setSpell_resistance(HeroTemplate.EXILER_BASE_SEPLLRESISTANCE);
		}
	}
	
	private static void heroJobAssembly(Hero hero) {
		if(hero instanceof Assassin) {
			//TODO
			ShapeShifterJob(hero);
		}
		if(hero instanceof BladeMaster) {
			//TODO
			ShapeShifterJob(hero);
		}
		if(hero instanceof Brawler) {
			//TODO
			ShapeShifterJob(hero);
		}
		if(hero instanceof ElementalList) {
			//TODO
			ShapeShifterJob(hero);
		}
		if(hero instanceof Guardian) {
			//TODO
			ShapeShifterJob(hero);
		}
		if(hero instanceof Gunslinger) {
			//TODO
			ShapeShifterJob(hero);
		}
		if(hero instanceof Knight) {
			//TODO
			ShapeShifterJob(hero);
		}
		if(hero instanceof Ranger) {
			//TODO
			ShapeShifterJob(hero);
		}
		if(hero instanceof ShapeShifter) {
			ShapeShifterJob(hero);
		}
		if(hero instanceof Sorcerer) {
			//TODO
			ShapeShifterJob(hero);
		}
	}

	private static void ShapeShifterJob(Hero hero) {
		hero.setHp((int)(hero.getHp() * HeroTemplate.SHAPESHIFTER_HP_BUFF));
		hero.setAd((int)(hero.getAd() * HeroTemplate.SHAPESHIFTER_AD_BUFF));
		hero.setAp((int)(hero.getAp() * HeroTemplate.SHAPESHIFTER_AP_BUFF));
		hero.setArmor((hero.getArmor() * HeroTemplate.SHAPESHIFTER_ARMOR_BUFF));
		hero.setSpell_resistance(((hero.getSpell_resistance() * HeroTemplate.SHAPESHIFTER_SPELLRESISTANCE_BUFF)));
		hero.setDex((int)(hero.getDex() * HeroTemplate.SHAPESHIFTER_DEX_BUFF));
		hero.setCri((int)(hero.getCri() * HeroTemplate.SHAPESHIFTER_CRI_BUFF));
		hero.setEvasion((int)(hero.getEvasion() * HeroTemplate.SHAPESHIFTER_EVASION_BUFF));
	}
}
