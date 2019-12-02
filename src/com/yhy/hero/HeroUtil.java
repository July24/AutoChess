package com.yhy.hero;

import com.yhy.job.*;
import com.yhy.race.*;

public class HeroUtil {
    public static String getHeroRace(Hero hero) {
        StringBuilder sb = new StringBuilder();
        if(hero instanceof DarkVoid) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("虚空");
        }
        if(hero instanceof Demon) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("恶魔");
        }
        if(hero instanceof Dragon) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("龙");
        }
        if(hero instanceof Exiler) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("浪人");
        }
        if(hero instanceof Glacial) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("冰川");
        }
        if(hero instanceof Imperial) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("皇帝");
        }
        if(hero instanceof Ninja) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("忍者");
        }
        if(hero instanceof Noble) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("贵族");
        }
        if(hero instanceof Phantom) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("幻影");
        }
        if(hero instanceof Pirate) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("海盗");
        }
        if(hero instanceof Robot) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("机器人");
        }
        if(hero instanceof Wild) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("野兽");
        }
        if(hero instanceof Yordle) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("约德尔人");
        }
        return sb.toString();
    }

    public static String getHeroJob(Hero hero) {
        StringBuilder sb = new StringBuilder();
        if(hero instanceof Assassin) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("刺客");
        }
        if(hero instanceof BladeMaster) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("剑士");
        }
        if(hero instanceof Brawler) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("斗士");
        }
        if(hero instanceof ElementalList) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("元素");
        }
        if(hero instanceof Guardian) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("守卫");
        }
        if(hero instanceof Gunslinger) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("枪手");
        }
        if(hero instanceof Knight) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("骑士");
        }
        if(hero instanceof Ranger) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("游侠");
        }
        if(hero instanceof ShapeShifter) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("变形师");
        }
        if(hero instanceof Sorcerer) {
            if(!"".equals(sb.toString())) {
                sb.append(",");
            }
            sb.append("幻术师");
        }
        return sb.toString();
    }
}
