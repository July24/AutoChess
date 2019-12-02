package com.yhy;

import com.yhy.hero.Hero;

public class ChessBoard {
	private Hero[][] chess;
	private Player ownner;

	public ChessBoard(Player player) {
		chess = new Hero[3][3];
		ownner = player;
	}
	
	public Player getOwnner() {
		return ownner;
	}

	public void setOwnner(Player ownner) {
		this.ownner = ownner;
	}

	public Hero[][] getChess() {
		return chess;
	}

	public void setChess(Hero[][] chess) {
		this.chess = chess;
	}
}
