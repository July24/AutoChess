package com.yhy.hero;

import com.yhy.Player;
import com.yhy.hero.constant.HeroState;

public abstract class Hero {
	public String getSkillDesc() {
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	//Ӣ����
	protected String name;
	//Ӣ�۳ƺ�
	protected String title;
	// Ӣ�ۼ�����
	protected String skillName;
	//��������
	protected String skillDesc;
	//Ӣ���Ǽ�
	protected String star = "★";
	//Ӣ�ۼ۸�
	protected int price;
	//����ӵ����
	protected Player ownner;

	public Player getOwnner() {
		return ownner;
	}

	public void setOwnner(Player ownner) {
		this.ownner = ownner;
	}

	//Ӣ��״̬
	protected HeroState state = HeroState.NORMAL;
	
	public void resetState() {
		state = HeroState.NORMAL;
	}
	
	public HeroState getState() {
		return state;
	}

	public void setState(HeroState state) {
		this.state = state;
	}
	
	public static final int HERO_STATE_NORMAL	= 0;
	public static final int HERO_STATE_DEAD 	= -1;
	
	//���������������
	//Ѫ��
	protected int hp;
	//ʣ��Ѫ��
	protected int health;
	
	public void injured(int damage) {
		health -= damage;
		mp += 10;
		if(health  <= 0) {
			state = HeroState.DEAD;
		}
	}
	
	//ħ��
	protected int mp;
	//�����˺�
	protected int ad;
	//ħ���˺�
	protected int ap;
	//�￹��Ĭ��ֵΪ1.0��ս�������˺�����Ϊ ad * armor
	protected double armor = 1.0;
	//ħ����Ĭ��ֵΪ1.0��ս��ģ���˺�����Ϊ ap * spell_resistance
	protected double spell_resistance = 1.0;
	
	
	//ְҵ�����������ԣ����ҶԻ������������ӳ�
	//���ݣ�ÿһ�غϣ����ݿ���ȳ��֣�ͬ���������Ĭ��Ϊ10
	protected int dex = 10;
	//�����ʣ�Ĭ��10%
	protected int cri = 10;
	//�����ʣ�Ĭ��5%
	protected int evasion = 5;
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	/**
	  *  ��������
	 *	Ĭ��Ϊ0����ǰ������򣬶����ȴ��λ���ˣ��ٴ�ͬ�ŵ���
	 *  1	��ǰ�������һ���һ��
	 */
	protected int attackType = 0;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEvasion() {
		return evasion;
	}

	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getAd() {
		return ad;
	}

	public void setAd(int ad) {
		this.ad = ad;
	}

	public int getAp() {
		return ap;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getCri() {
		return cri;
	}

	public void setCri(int cri) {
		this.cri = cri;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public double getArmor() {
		return armor;
	}

	public void setArmor(double armor) {
		this.armor = armor;
	}

	public double getSpell_resistance() {
		return spell_resistance;
	}

	public void setSpell_resistance(double spell_resistance) {
		this.spell_resistance = spell_resistance;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAttackType() {
		return attackType;
	}

	public void setAttackType(int attackType) {
		this.attackType = attackType;
	}

	public void update(Hero hero1, Hero hero2) {
		Class clazz = this.getClass();
		String n1 = clazz.getName();
		String n2 = hero1.getClass().getName();
		String n3 = hero2.getClass().getName();
		if(n1 == n2 && n2 == n3) {
			levelUp();
		}
	}

	/**
	 * 
	 */
	private void levelUp() {
		// TODO Ӣ������
	}
	
	/**
	  * Ӣ�ۼ���
	 */
	protected abstract void skill();
}
