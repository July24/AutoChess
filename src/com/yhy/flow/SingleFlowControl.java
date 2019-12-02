package com.yhy.flow;

import java.util.List;
import java.util.Scanner;

import com.yhy.AlphaCat;
import com.yhy.Player;
import com.yhy.hero.Hero;
import com.yhy.hero.HeroPool;
import com.yhy.hero.HeroShop;
import com.yhy.util.CmdUtil;

public class SingleFlowControl {
	private HeroPool heroPool;
	private Player player;
	private int turn;
	private Scanner scan = new Scanner(System.in);
	
	public void gameInit() {
		heroPool = new HeroPool();
		player   = new Player(new HeroShop(heroPool));
		turn  = 1;
	}
	
	public void game() throws Exception {
		while(true) {
			showShop();
			prepare();
			combat();
			if(account()) {
				return;
			}
		}
	}

	private boolean account() {
		if(player.getLife() <= 0) {
			System.out.println("*********游戏结束！*********");
			return true;
		}
		turn++;
		return false;
	}

	private void combat() throws Exception {
		CombatProcessor processor = new CombatProcessor(player, new AlphaCat(null));
		processor.combat();
	}

	private void prepare() throws Exception {
		while(true) {
			System.out.println(FlowConst.LINE);
			showPrepareBegin();
			System.out.println("***lineup布阵 check查看阵容***");
			System.out.println("***shop打开商店 buyexp购买经验***");
			System.out.println("****area查看备战区go进入战斗*****");
			System.out.println(FlowConst.LINE);
			String cmd = scan.next();
			if(CmdUtil.parepareMenuInMatch(cmd)) {
				switch (cmd) {
				case CmdUtil.PREPARE_MENU_LINEUP:
					lineUpResolve();
					break;
				case CmdUtil.PREPARE_MENU_CHECK:
					checkResolve();
					break;
				case CmdUtil.PREPARE_MENU_SHOP:
					showShop();
					break;
				case CmdUtil.PREPARE_MENU_BUYEXP:
					buyExpResolve();
					break;
				case CmdUtil.PREPARE_MENU_AREA:
					areaResolve();
					break;
				case CmdUtil.PREPARE_MENU_GO:
					return;
				default:
					errorTip();
					continue;
				}
			}
		}
	}

	private void areaResolve() throws Exception {
		if(player.getArea().size() == 0) {
			System.out.println("*****你的备战区内无英雄*****");
			Thread.sleep(1000);
			return;
		}
		System.out.println(FlowConst.LINE);
		showPrepareBegin();
		System.out.println("*****你的备战区英雄列表*****");
		showArea();
		System.out.println("**输入任意内容返回准备阶段**");
		System.out.println(FlowConst.LINE);
		String cmd = scan.next();
	}

	private void lineUpResolve() throws Exception {
		while (true) {
			System.out.println(FlowConst.LINE);
			showPrepareBegin();
			showLineUp();
			System.out.println("*******输入阵型位置进行布阵*******");
			System.out.println("*********exit返回准备界面*********");
			System.out.println(FlowConst.LINE);
			String cmd = scan.next();
			if(CmdUtil.lineUpCmdInMatch(cmd)) {
				int pos = Integer.valueOf(cmd);
				heroReplaceResolve(pos);
			} else if(CmdUtil.lineUpMenuInMatch(cmd)) {
				Thread.sleep(1000);
				return;
			} else {
				errorTip();
				continue;
			}
		}
	}

	private void heroReplaceResolve(int pos) throws Exception {
		Hero hero = player.getBoardHero(pos);
		System.out.println(FlowConst.LINE);
		showPrepareBegin();
		System.out.print("英雄现在的位置是： ");
		System.out.println(getPosInfo(pos));
		System.out.println(getPosHeroDesc(hero));
		System.out.println("***area从备战区选择英雄换位***");
		System.out.println("****chess从场上选择英雄换位****");
		if(hero != null) {
			System.out.println("*****end英雄下场返回备战区*****");
		}
		System.out.println("*****exit返回阵型布置界面*****");
		System.out.println(FlowConst.LINE);
		String cmd = scan.next();
		if(CmdUtil.heroReplaceMenuInMatch(cmd)) {
			switch (cmd) {
			case CmdUtil.HEROREPLACE_MENU_AREA:
				lineUpAreaSel(pos);
				break;
			case CmdUtil.HEROREPLACE_MENU_CHESS:
				lineupChessSel(pos);
				break;
			case CmdUtil.HEROREPLACE_MENU_END:
				heroEndResolve(pos);
				break;
			default:
				throw new Exception("英雄上场出现未知错误");
			}
		}
	}

	private void showPrepareBegin() {
		System.out.println(FlowConst.playerInfo(player));
		System.out.println("**********预备阶段***********");
		System.out.println("**********第" + turn + "轮************");
	}
	
	private void lineupChessSel(int pos) throws Exception {
		System.out.println(FlowConst.LINE);
		showPrepareBegin();
		System.out.println("*******棋盘上的英雄*********");
		int cnt = showChessSel();
		System.out.println("******输入序号进行交换*****");
		System.out.println("*****exit返回阵型布置界面*****");
		System.out.println(FlowConst.LINE);

		String cmd = scan.next();
		if(CmdUtil.heroReplaceFromBoardMenuInMatch(cmd)) {
			Thread.sleep(1000);
			return;
		}
		if(CmdUtil.heroReplaceFromBoardCmdInMatch(cmd)) {
			int secPos = Integer.valueOf(cmd);
			player.chessHeroExchange(pos, secPos);
		}
	}

	private int showChessSel() {
		Hero[][] chess = player.getBoard().getChess();
		int index = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Hero hero = chess[i][j];
				int pos = i * 3 + (j + 1);
				if(hero != null) {
					System.out.println(index++ + "." + getPosInfo(pos) + " " + hero.getTitle() + hero.getName() + "(" + hero.getStar() + ")");
				} else {
					System.out.println(index++ + "." + getPosInfo(pos) + " 无英�? ");
				}
			}
		}
		return index;
	}
	
	private void heroEndResolve(int pos) throws Exception {
		boolean res = player.heroEnd(pos);
		if(res) {
			System.out.println("*********英雄替换成功*********");
		} else {
			System.out.println("***********备战区已满***********");
		}
		Thread.sleep(1000);
	}

	private String getPosInfo(int pos) {
		StringBuilder sb = new StringBuilder();
		int row = (pos-1) / 3;
		int col = (pos-1) % 3;
		switch (row) {
		case 0:
			sb.append("前排");
			break;
		case 1:
			sb.append("中排");
			break;
		case 2:
			sb.append("后排");
			break;
		}
		sb.append(",");
		switch (col) {
		case 0:
			sb.append("左侧");
			break;
		case 1:
			sb.append("中间");
			break;
		case 2:
			sb.append("右侧");
			break;
		}
		return sb.toString();
	}
	
	private String getPosHeroDesc(Hero hero) {
		StringBuilder sb = new StringBuilder();
		if(hero == null) {
			sb.append("********该位置无英雄********");
		} else {
			sb.append("该位置的英雄是 : ");
			sb.append(hero.getTitle());
			sb.append(hero.getName());
			sb.append("( ");
			sb.append(hero.getStar());
			sb.append(" )");
		}
		return sb.toString();
	}

	private void lineUpAreaSel(int pos) throws Exception {
		if(player.getArea().size() == 0) {
			System.out.println("*****你的备战区内无英雄*****");
			Thread.sleep(1000);
			return;
		}
		System.out.println(FlowConst.LINE);
		showPrepareBegin();
		System.out.println("*****你的备战区英雄列表*****");
		showArea();
		System.out.println("***输入需要上场英雄的序号***");
		System.out.println("**输入其他内容返回阵容布置界面**");
		System.out.println(FlowConst.LINE);
		String cmd = scan.next();
		String regex = getAreaCountRegex();
		if(CmdUtil.lineUpInfoCmdInMatch(regex, cmd)) {
			Integer areaPos = Integer.valueOf(cmd);
			boolean res = player.heroComeFromArea(pos, areaPos);
			if(!res) {
				System.out.println("****英雄上场出现未知错误****");
			}
		}
	}

	private String getAreaCountRegex() {
		List<Hero> area = player.getArea();
		return getCountRegex(area.size());
	}
	
	private String getCountRegex(int size) {
		StringBuilder sb = new StringBuilder();
		sb.append("^([1-");
		sb.append(size);
		sb.append("])$");
		return sb.toString();
	}

	private void showArea() {
		List<Hero> area = player.getArea();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < area.size(); i++) {
			Hero hero = area.get(i);
			if(i != 0) {
				sb.append(" | ");
			}
			sb.append((i + 1));
			sb.append(".");
			sb.append(hero.getTitle());
			sb.append(hero.getName());
			sb.append("(");
			sb.append(hero.getStar());
			sb.append(")");
		}
		System.out.println(sb.toString());
	}

	private void checkResolve() throws Exception {
		System.out.println(FlowConst.LINE);
		showPrepareBegin();
		showLineUp();
		System.out.println("*********exit返回准备界面*********");
		System.out.println(FlowConst.LINE);
		String cmd = scan.next();
		if(CmdUtil.CheckMenuInMatch(cmd)) {
			Thread.sleep(1000);
		}
	}
	
	public void showLineUp() {
		Hero[][] lineUp = player.getHeroLineUp();
		System.out.println("**********你的阵容***********");
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
			sb.append(hero.getStar());
			sb.append(")");
		}
		return sb.toString();
	}

	private void buyExpResolve() throws Exception {
		int res = player.buyExp();
		switch (res) {
		case Player.BUYEXP_SUCCESS:
			System.out.println("*******购买经验成功!***********");
			Thread.sleep(1000);
			break;
		case Player.BUYEXP_ERROR_LEVELMAX:
			System.out.println("*****已满级，不能购买经验*****");
			Thread.sleep(1000);
			break;
		case Player.BUYEXP_ERROR_NOMONEY:
			System.out.println("*****余额不足,不能购买经验*****");
			Thread.sleep(1000);
			break;
		default:
			throw new Exception("购买英雄出现未知错误");
		}
	}

	private void showShop() throws Exception {
		HeroShop shop = player.getHeroShop();
		while(true) {
			System.out.println(FlowConst.LINE);
			showPrepareBegin();
			System.out.println("***********英雄商店************");
			Hero[] heros = shop.getHeros();
			for(int i = 0; i < heros.length; i++) {
				Hero hero = heros[i];
				if(hero == null) {
					continue;
				}
				System.out.println((i + 1) + "." + hero.getTitle() + hero.getName());
				System.out.println("价格: " + hero.getPrice());
			}
			System.out.println("*******请输入序号进行购买*******");
			System.out.println("**exit退出商店 refresh刷新商店**");
			System.out.println(FlowConst.LINE);
			String cmd = scan.next();
			if(CmdUtil.heroShopMenuInMatch(cmd)) {
				switch (cmd) {
				case CmdUtil.COMMON_MENU_EXIT:
					return;
				case CmdUtil.HEROSHOP_MENU_REFRESH:
					boolean suc = player.refreshShop();
					refreshShopResolve(suc);
					continue;
				default:
					errorTip();
					continue;
				}
			} else if(CmdUtil.heroShopCmdInMatch(cmd)) {
				int input = Integer.valueOf(cmd);
				if(input == 0) {
					break;
				} else {
					Hero hero = heros[input - 1];
					if(hero == null) {
						errorTip();
						continue;
					}
					int ret = player.buyHero(hero);
					buyHeroResolve(ret);
					if(ret == Player.BUYHERO_SUCCESS) {
						heros[input - 1] = null;
					}
				}
			} else {
				errorTip();
				continue;
			}
		}
	}
	
	private void refreshShopResolve(boolean suc) throws Exception {
		if(suc) {
			System.out.println("***********刷新成功**********");
			Thread.sleep(1000);
		} else {
			System.out.println("******余额不足，刷新失败******");
			Thread.sleep(1000);
		}
	}

	private void errorTip() throws Exception {
		System.out.println("*******请输入正确的命令*******");
		Thread.sleep(1000);
	}

	private void buyHeroResolve(int ret) throws Exception {
		switch (ret) {
		case Player.BUYHERO_SUCCESS:
			System.out.println("**********购买成功**********");
			Thread.sleep(1000);
			break;
		case Player.BUYHERO_NO_MONEY:
			System.out.println("******余额不足，购买失败！*****");
			Thread.sleep(1000);
			break;
		case Player.BUYHERO_AREA_FULL:
			System.out.println("*****准备区已满，购买失败*****");
			Thread.sleep(1000);
			break;
		default:
			throw new Exception("购买英雄出现未知错误");
		}
	}
}
