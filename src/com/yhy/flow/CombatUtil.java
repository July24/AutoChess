package com.yhy.flow;

import java.util.HashMap;
import java.util.Random;

import com.yhy.hero.constant.HeroAttackType;

public class CombatUtil {
	private static HashMap<HeroAttackType, HashMap<Integer,Integer[]>> attackTypeMap;
	private static final Random ran = new Random();
	
	public static Integer[] getAttackPos(int pos, HeroAttackType attackType) {
		if(attackTypeMap == null) {
			initAttackTypeMap();
		}
		switch (attackType) {
		case NORMAL:
			return attackTypeMap.get(HeroAttackType.NORMAL).get(pos);
		}
		return null;
	}

	private static void initAttackTypeMap() {
		attackTypeMap = new HashMap<HeroAttackType, HashMap<Integer,Integer[]>>();
		initNormalAttackType();
	}
	
	private static void initNormalAttackType() {
		HashMap<Integer,Integer[]> map = new HashMap<Integer, Integer[]>();
		map.put(1, new Integer[] {1,2,3,4,5,6,7,8,9});
		map.put(2, new Integer[] {2,1,3,5,4,6,8,7,9});
		map.put(3, new Integer[] {3,1,2,6,4,5,9,7,8});
		map.put(4, new Integer[] {1,2,3,4,5,6,7,8,9});
		map.put(5, new Integer[] {2,1,3,5,4,6,8,7,9});
		map.put(6, new Integer[] {3,1,2,6,4,5,9,7,8});
		map.put(7, new Integer[] {1,2,3,4,5,6,7,8,9});
		map.put(8, new Integer[] {2,1,3,5,4,6,8,7,9});
		map.put(9, new Integer[] {3,1,2,6,4,5,9,7,8});
		attackTypeMap.put(HeroAttackType.NORMAL, map);
	}
	
	private static final double CRITICAL_DAMAGE = 2.5;
	
	public static boolean criCalculate(int cri) {
		return (ran.nextInt(100) < cri ? true : false);
	}
	
	public static int adDamageCalculate(int ad, double enemyArmor, boolean cri) {
		double damage = ad * enemyArmor;
		return (int) (cri ? damage * CRITICAL_DAMAGE : damage);
	}
	
	public static boolean evasionCalculate(int enemyEva) {
		return (ran.nextInt(100) < enemyEva ? true : false);
	}
}
