package com.attic.bj.majiang.tiantai;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.card.Card;
import com.attic.bj.core.game.Game;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.executor.MajiangAllocateWithHuaActionExecutor;

public class TiantaiMajiangAllocateActionExecutor extends
		MajiangAllocateWithHuaActionExecutor {

	public void exec(Game game, Action action) {

		super.exec(game, action);
		MajiangGame mg = (MajiangGame) game;
		TiantaiMajiangGameInfo gf = (TiantaiMajiangGameInfo) mg.getGameInfo();
		if (!gf.isHasBaida()) {
			return;
		}
		Card[] cards = mg.getAllCards().findCardsByType("白");
		for (int i = 0; i < cards.length; i++) {
			((MajiangCard) cards[i]).setBaida(true);
		}
	}

}
