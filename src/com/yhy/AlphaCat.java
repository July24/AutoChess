package com.yhy;

import com.yhy.hero.HeroFactory;
import com.yhy.hero.HeroShop;
import com.yhy.hero.Hero;

public class AlphaCat extends Player{

	public AlphaCat(HeroShop heroShop) {
		super(heroShop);
		setName("AlphaCat");
		Hero akali = HeroFactory.getAkali();
		akali.setOwnner(this);
		ChessBoard board = getBoard();
		Hero[][] chess = board.getChess();
		chess[0][0] = akali;
	}
}
