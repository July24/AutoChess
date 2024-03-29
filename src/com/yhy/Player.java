package com.yhy;

import java.util.ArrayList;
import java.util.List;

import com.yhy.hero.Hero;
import com.yhy.hero.HeroShop;

public class Player {
	private String name = "player1";
	private ChessBoard board;
	private PrepareArea area;
	private HeroShop heroShop;
	private int life;
	private int money;
	private int level;
	private int exp;
	
	public Player(HeroShop heroShop) {
		this.heroShop = heroShop;
		board = new ChessBoard(this);
		area  = new PrepareArea(this);
		life  = 100;
		money = 100;
		level = 1;
		exp = 0;
	}

	public boolean sellHero(Hero hero) {
		boolean b1 = removeBoardHero(hero);
		boolean b2 = removeAreaHero(hero);
		if(b1 || b2) {
			money += hero.getSellingPrice();
			heroShop.sellHero(hero);
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ChessBoard getBoard() {
		return board;
	}

	public List<Hero> getBoardAllHero() {
		List<Hero> list = new ArrayList<Hero>();
		Hero[][] chess = board.getChess();
		for(Hero[] row : chess) {
			for(Hero hero : row) {
				if(hero != null) {
					list.add(hero);
				}
			}
		}
		return list;
	}
	
	public void setBoard(ChessBoard board) {
		this.board = board;
	}

	public List<Hero> getArea() {
		return area.getPrepareHero();
	}

	public boolean areaEmpty() {
		return getArea().size() == 0;
	}

	public int getAreaHeroCount() {
		return getArea().size();
	}

	public void setArea(PrepareArea area) {
		this.area = area;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void damageLife(int life) {
		this.life -= life;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
		autoLevelUp();
	}

	public void setHeroShop(HeroShop heroShop) {
		this.heroShop = heroShop;
	}

	public HeroShop getHeroShop() {
		heroShop.refreshShop();
		return heroShop;
	}
	
	public Hero[][] getHeroLineUp() {
		return board.getChess();
	}

	public static final int BUYHERO_SUCCESS   = 0;
	public static final int BUYHERO_NO_MONEY  = -1;
	public static final int BUYHERO_AREA_FULL = -2;

	public Hero heroAutoUpdate(Hero hero) {
	    if(hero.getStar().length() > 2) {
	        return null;
        }
	    ArrayList<Hero> list = new ArrayList<>();
	    Hero wait = null;
	    getBoardSameHero(list, hero);
        getAreaSameHero(list, hero);
        if(list.size() >= 3) {
            int i = 0;
            while (i < 2) {
                if(removeAreaSameHero(hero)) {
                    i++;
                } else if(removeBoardSameHero(hero)) {
                    i++;
                }
            }
            wait = getBoardSameHero(hero);
            if(wait == null) {
                wait = getAreaSameHero(hero);
            }
            wait.update();
            Hero ret = heroAutoUpdate(wait);
            wait = ret != null ? ret : wait;
        }
        return wait;
    }

    private void getBoardSameHero(ArrayList<Hero> list, Hero hero) {
        Hero[][] chess = board.getChess();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Hero board = chess[i][j];
                if(board == null) {
                    continue;
                }
                if(board.equals(hero)) {
                    list.add(board);
                }
            }
        }
    }

    private void getAreaSameHero(ArrayList<Hero> list, Hero hero) {
        List<Hero> prepareHero = area.getPrepareHero();
        for(int i = 0; i < prepareHero.size(); i++) {
            Hero prepare = prepareHero.get(i);
            if(prepare.equals(hero)) {
                list.add(prepare);
            }
        }
    }

	public int buyHero(Hero hero) {
		if(money < hero.getPrice()) {
			return BUYHERO_NO_MONEY;
		}
		if(area.addHero(hero)) {
			money -= hero.getPrice();
			return BUYHERO_SUCCESS;
		} else {
			return BUYHERO_AREA_FULL;
		}
	}

	public static final int BUYEXP_SUCCESS		  = 0;
	public static final int BUYEXP_ERROR_LEVELMAX = -1;
	public static final int BUYEXP_ERROR_NOMONEY  = -2;
	
	public int buyExp() {
		if(money > 4) {
			if(level == 9) {
				return BUYEXP_ERROR_LEVELMAX;
			}
			money -= 4; 	
			exp += 4;
			setExp(getExp() + 4);
			return BUYEXP_SUCCESS;
		} else {
			return BUYEXP_ERROR_NOMONEY;
		}
	}

	
	/**
	 *	���������
	 *	1	2	3	4	5	6	7	8	9
	 *	1	1	2	4	8	16	24	32	 
	 */
	public void autoLevelUp() {
		if(exp >= 1 && level == 1) {
			level++;
			exp -= 1;
		}
		if(exp >= 1 && level == 2) {
			level++;
			exp -= 1;
		}
		if(exp >= 2 && level == 3) {
			level++;
			exp -= 2;
		}
		if(exp >= 4 && level == 4) {
			level++;
			exp -= 4;
		}
		if(exp >= 8 && level == 5) {
			level++;
			exp -= 8;
		}
		if(exp >= 16 && level == 6) {
			level++;
			exp = exp - 4;
		}
		if(exp >= 24 && level == 7) {
			level++;
			exp -= 24;
		}
		if(exp >= 32 && level == 8) {
			level++;
			exp -= 32;
		}
	}

	public boolean refreshShop() {
		if(money < 5) {
			return false;
		}
		money -= 5;
		heroShop.refreshShop();
		return true;
	}
	
	public boolean heroComeFromArea(int pos, int areaPos) {
		Hero hero = getBoardHero(pos);
		Hero preHero = area.takeHero(areaPos - 1);
		if(hero == null) {
			putBoardHero(pos, preHero);
			return true;
		} else {
			if(area.addHero(hero)) {
				putBoardHero(pos, preHero);
				return true;
			}
			return false;
		}
	}
	
	public int getBoardHeroPos(Hero hero) {
		Hero[][] chess = board.getChess();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(hero == chess[i][j]) {
					return i*3 + (j + 1);
				}
			}
		}
		return 0;
	}
	
	public Hero getBoardHero(int pos) {
		int row = (pos-1) / 3;
		int col = (pos-1) % 3;
		Hero[][] chess = board.getChess();
		return chess[row][col];
	}
	
	public void putBoardHero(int pos, Hero hero) {
		int row = (pos-1) / 3;
		int col = (pos-1) % 3;
		Hero[][] chess = board.getChess();
		chess[row][col] = hero;
	}
    public Hero getAreaSameHero(Hero hero) {
        List<Hero> list = area.getPrepareHero();
        for(int i = 0; i < list.size(); i++) {
            Hero area = list.get(i);
            if(hero.equals(area)) {
                return area;
            }
        }
        return null;
    }

    public boolean removeAreaSameHero(Hero hero) {
        List<Hero> list = area.getPrepareHero();
        for(int i = 0; i < list.size(); i++) {
            if(hero.equals(list.get(i))) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

	public boolean removeAreaHero(Hero hero) {
		List<Hero> list = area.getPrepareHero();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == hero) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean removeBoardHero(Hero hero) {
		Hero[][] chess = board.getChess();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(chess[i][j] == hero) {
					chess[i][j] = null;
					return true;
				}
			}
		}
 		return false;
	}
    public boolean removeBoardSameHero(Hero hero) {
        Hero[][] chess = board.getChess();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(hero.equals(chess[i][j])) {
                    chess[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public Hero getBoardSameHero(Hero hero) {
        Hero[][] chess = board.getChess();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Hero board = chess[i][j];
                if(hero.equals(board)) {
                    return board;
                }
            }
        }
        return null;
    }

	public Hero removeBoardHero(int pos) {
		int row = (pos-1) / 3;
		int col = (pos-1) % 3;
		Hero[][] chess = board.getChess();
		Hero hero = chess[row][col];
		chess[row][col] = null;
		return hero;
	}

	public boolean heroEnd(int pos) {
		if(area.full()) {
			return false;
		} else {
			Hero hero = removeBoardHero(pos);
			area.addHero(hero);
			return true;
		}
	}
	
	public void chessHeroExchange(int pos, int secPos ) {
		Hero[][] chess = board.getChess();
		int row    = (pos-1) / 3;
		int col    = (pos-1) % 3;
		int secrow = (secPos-1) / 3;
		int seccol = (secPos-1) % 3;
		Hero hero = chess[row][col];
		chess[row][col] = chess[secrow][seccol];
		chess[secrow][seccol] = hero;
	}
}
