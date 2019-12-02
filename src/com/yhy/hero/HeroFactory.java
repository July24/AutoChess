package com.yhy.hero;

import com.yhy.hero.details.Akali;
import com.yhy.hero.details.Darius;
import com.yhy.hero.details.Draven;
import com.yhy.hero.details.Evelynn;
import com.yhy.hero.details.Fiora;
import com.yhy.hero.details.Katarina;
import com.yhy.hero.details.KhaZix;
import com.yhy.hero.details.Pyke;
import com.yhy.hero.details.Shen;
import com.yhy.hero.details.Shyvana;
import com.yhy.hero.details.Yasuo;
import com.yhy.hero.details.Zed;

public class HeroFactory {
	public static Hero getShyvana() {
		Hero shyvana = new Shyvana();
		HeroWorkshop.heroAssembly(shyvana);
		return shyvana;
	}
	
	public static Hero getPyke() {
		Hero pyke = new Pyke();
		HeroWorkshop.heroAssembly(pyke);
		return pyke;
	}
	
	public static Hero getKhaZix() {
		Hero khaZix = new KhaZix();
		HeroWorkshop.heroAssembly(khaZix);
		return khaZix;
	}
	
	public static Hero getZed() {
		Hero zed = new Zed();
		HeroWorkshop.heroAssembly(zed);
		return zed;
	}
	
	public static Hero getAkali() {
		Hero akali = new Akali();
		HeroWorkshop.heroAssembly(akali);
		return akali;
	}
	
	public static Hero getKatarina() {
		Hero katarina = new Katarina();
		HeroWorkshop.heroAssembly(katarina);
		return katarina;
	}
	
	public static Hero getEvelynn() {
		Hero evelynn = new Evelynn();
		HeroWorkshop.heroAssembly(evelynn);
		return evelynn;
	}
	
	public static Hero getDarius() {
		Hero darius = new Darius();
		HeroWorkshop.heroAssembly(darius);
		return darius;
	}
	
	public static Hero getShen() {
		Hero shen = new Shen();
		HeroWorkshop.heroAssembly(shen);
		return shen;
	}
	
	public static Hero getDraven() {
		Hero draven = new Draven();
		HeroWorkshop.heroAssembly(draven);
		return draven;
	}
	
	public static Hero getYasuo() {
		Hero yasuo = new Yasuo();
		HeroWorkshop.heroAssembly(yasuo);
		return yasuo;
	}
	
	public static Hero getFiora() {
		Hero fiora = new Fiora();
		HeroWorkshop.heroAssembly(fiora);
		return fiora;
	}
}
