package com.attic.bj.majiang.rule.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.game.Game;
import com.attic.bj.majiang.card.MajiangBlackCards;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangInnerCards;
import com.attic.bj.majiang.card.MajiangMiddleCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangAllocateWithHuaActionExecutor extends
		MajiangAllocateActionExecutor {

	private static final Logger logger = LoggerFactory
			.getLogger(MajiangAllocateWithHuaActionExecutor.class);

	public void exec(Game game, Action action) {

		super.exec(game, action);
		MajiangGame mg = (MajiangGame) game;
		MajiangPlayer dealer = mg.getDealer();
		MajiangPlayer nextPlayer = dealer;
		do {
			this.changeHua(mg, nextPlayer);
			nextPlayer = (MajiangPlayer) mg.nextPlayer(nextPlayer);
		} while (nextPlayer != dealer);

	}

	private void changeHua(MajiangGame mg, MajiangPlayer player) {
		MajiangInnerCards mics = player.getMajiangInnerCards();
		MajiangMiddleCards mmcs = player.getMajiangMiddleCards();
		MajiangBlackCards mbcs = mg.getMajiangBlackCards();
		MajiangCard[] mcs = mics.getCardsByUnit(MajiangCard.HUA);
		if (mcs == null || mcs.length == 0) {
			return;
		}

		for (MajiangCard mc : mcs) {
			mmcs.addHuaCard(mc);
		}

		mics.removeCards(mcs);
		mics.addTailCards(mbcs.removeTailCards(mcs.length));

		this.changeHua(mg, player);

	}
}
