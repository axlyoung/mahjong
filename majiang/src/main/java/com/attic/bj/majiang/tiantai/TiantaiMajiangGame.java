package com.attic.bj.majiang.tiantai;

import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.game.MajiangGame;

public class TiantaiMajiangGame extends MajiangGame {

	public TiantaiMajiangGame(TiantaiMajiangGameInfo gameInfo) {
		super(gameInfo);
		// TODO Auto-generated constructor stub
	}

	public MajiangCard getBaida() {
		return (MajiangCard) this.getAllCards().findCardByType("白");
	}
}
