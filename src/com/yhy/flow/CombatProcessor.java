package com.yhy.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.yhy.Player;
import com.yhy.hero.Hero;
import com.yhy.hero.constant.HeroAttackType;
import com.yhy.hero.constant.HeroState;

public class CombatProcessor {
	private int round;
	private Player defender;
	private Player attacker;
	private Random ran;
	private Scanner scan;
	
	public CombatProcessor(Player defender, Player attacker) {
		round = 1;
		this.defender = defender;
		this.attacker = attacker;
		ran = new Random();
		scan = new Scanner(System.in);
	}
	
	public void combat() throws Exception {
		combatPrepare();
		while(true) {
			combatPhase();
			if(accountPhase()) {
				return;
			}
		}
	}
	
	private boolean accountPhase() {
		//TODO 待优化
		if(judgeDeath(defender)) {
			System.out.println("****你被" + attacker.getName() + " 打败了! ****");
			defenderDamage();
			System.out.println("****任意输入返回备战阶段****");
			scan.next();
			defender.setExp(defender.getExp() + 1);
			defender.setMoney(defender.getMoney() + 2);
			return true;
		}
		if(judgeDeath(attacker)) {
			System.out.println("****你战胜了 " + attacker.getName() + "! ****");
			System.out.println("****任意输入返回备战阶段****");
			scan.next();
			defender.setExp(defender.getExp() + 1);
			defender.setMoney(defender.getMoney() + 2);
			return true;
		}
		round++;
		return false;
	}
	
	private void defenderDamage() {
		int damage = 0;
		List<Hero> allHero = attacker.getBoardAllHero();
		for(Hero hero : allHero) {
			if(hero.getState() == HeroState.NORMAL) {
				damage += hero.getStar().length();
			}
		}
		System.out.println("****" + defender.getName() + "受到 " + damage + " 点伤害****");
		defender.setLife(damage);
	}

	private boolean judgeDeath(Player player) {
		List<Hero> allHero = player.getBoardAllHero();
		for(Hero hero : allHero) {
			if(hero.getState() == HeroState.NORMAL) {
				return false;
			}
		}
		return true;
	}

	private void combatPhase() throws Exception {
		System.out.println(FlowConst.LINE);
		showPrepareBegin();
		System.out.println("**********你的阵容***********");
		showUsLineUp();
		System.out.println("**********敌人阵容***********");
		showEnemyLineUp();
		System.out.println("*************************");
		combatFlow();
		System.out.println("*************************");
		System.out.println("**********你的阵容***********");
		showUsLineUp();
		System.out.println("**********敌人阵容***********");
		showEnemyLineUp();
		System.out.println("****任意输入进入下一回合****");
		System.out.println(FlowConst.LINE);
		scan.next();
	}
	
	private void combatFlow() throws Exception {
		// TODO Auto-generated method stub
		List<Hero> list = new ArrayList<Hero>();
		list.addAll(defender.getBoardAllHero());
		list.addAll(attacker.getBoardAllHero());
		Collections.sort(list, new Comparator<Hero>() {
			@Override
			public int compare(Hero o1, Hero o2) {
				if(o1.getDex() > o2.getDex()) {
					return 1;
				} else if(o1.getDex() < o2.getDex()) {
					return -1;
				} else {
					return ran.nextBoolean() ? 1 : -1;
				}
			}
		});
		heroAttack(list);
	}

	private void heroAttack(List<Hero> list) throws Exception {
		for(int i = list.size() - 1; i >= 0; i--) {
			Hero hero = list.get(i);
			int pos = defender.getBoardHeroPos(hero);
			Player passivePlayer = attacker;
			if(pos == 0) {
				pos = attacker.getBoardHeroPos(hero);
				passivePlayer = defender;
			}
			Integer[] attackTarget = CombatUtil.getAttackPos(pos, HeroAttackType.NORMAL);
			for(int j : attackTarget) {
				Hero passive = passivePlayer.getBoardHero(j);
				if(passive == null || passive.getState() == HeroState.DEAD) {
					continue;
				}
				attackResolve(hero, passive);
				break;
			}
		}
	}
	
	private void attackResolve(Hero active, Hero passive) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(playerHeroDesc(active));
		sb.append(" 发起攻击，目标是 ");
		sb.append(playerHeroDesc(passive));
		sb.append("\r\n");
		boolean eva = CombatUtil.evasionCalculate(passive.getEvasion());
		if(eva) {
			sb.append(playerHeroDesc(passive));
			sb.append(" 闪避成功！没有造成伤害！");
		} else {
			boolean cri = CombatUtil.criCalculate(active.getCri());
			int damage  = CombatUtil.adDamageCalculate(active.getAd(), passive.getArmor(), cri);
			if(cri) {
				sb.append(playerHeroDesc(active));
				sb.append(" 打出暴击！！！ ");
			}
			sb.append(playerHeroDesc(passive));
			sb.append("受到");
			sb.append(damage);
			sb.append("伤害");
			passive.injured(damage);
			//TODO
		}
		combatPrint(sb.toString());
	}

	private String playerHeroDesc(Hero passive) {
		StringBuilder sb = new StringBuilder();
		sb.append(passive.getOwnner().getName());
		sb.append(" 的 ");
		sb.append(passive.getTitle());
		sb.append(passive.getName());
		return sb.toString();
	}
	
	private void showEnemyLineUp() {
		showLineUp(attacker);
	}
	
	private void showUsLineUp() {
		showLineUp(defender);
	}
	
	private void showLineUp(Player player) {
		Hero[][] lineUp = player.getHeroLineUp();
		System.out.println("| " + getLineUpPosHeroInfo(0, 0, lineUp) + " | " + getLineUpPosHeroInfo(0, 1, lineUp) + " | " + getLineUpPosHeroInfo(0, 2, lineUp) + " |");
		System.out.println("| " + getLineUpPosHeroInfo(1, 0, lineUp) + " | " + getLineUpPosHeroInfo(1, 1, lineUp) + " | " + getLineUpPosHeroInfo(1, 2, lineUp) + " |");
		System.out.println("| " + getLineUpPosHeroInfo(2, 0, lineUp) + " | " + getLineUpPosHeroInfo(2, 1, lineUp) + " | " + getLineUpPosHeroInfo(2, 2, lineUp) + " |");
	}

	private String getLineUpPosHeroInfo(int row, int col, Hero[][] lineUp) {
		StringBuilder sb = new StringBuilder();
		Hero hero = lineUp[row][col];
		if(hero == null) {
			sb.append("无");
		} else {
			sb.append(hero.getTitle());
			sb.append(hero.getName());
			sb.append("(");
			if(hero.getState() == HeroState.DEAD) {
				sb.append("阵亡");
			} else {
				sb.append(hero.getHealth());
				sb.append(",");
				sb.append(hero.getMp());
			}
			sb.append(")");
		}
		return sb.toString();
	}
	
	private void combatPrint(String str) throws Exception {
		Thread.sleep(500);
		System.out.println(str);
	}

	private void combatPrepare() {
		resetHeroCombatProperty(defender);
		resetHeroCombatProperty(attacker);
		// TODO 加羁�?
	}
	
	public void resetHeroCombatProperty(Player player) {
		List<Hero> heros = player.getBoardAllHero();
		for(Hero hero : heros) {
			hero.setHealth(hero.getHp());
			hero.setMp(0);
			hero.resetState();
		}
	}

	private void showPrepareBegin() {
		System.out.println("**********战斗阶段***********");
		System.out.println("**********第" + round + "回合************");
	}
}
