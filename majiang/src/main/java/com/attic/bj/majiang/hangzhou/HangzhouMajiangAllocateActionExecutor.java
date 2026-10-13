package com.attic.bj.majiang.hangzhou;

import com.attic.bj.common.util.RandomUtil;
import com.attic.bj.core.action.Action;
import com.attic.bj.core.card.Card;
import com.attic.bj.core.game.Game;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.rule.executor.MajiangAllocateActionExecutor;

public class HangzhouMajiangAllocateActionExecutor extends
		MajiangAllocateActionExecutor {

	public void exec(Game game, Action action) {
		super.exec(game, action);
		HangzhouMajiangGame mg = (HangzhouMajiangGame) game;
		HangzhouMajiangGameInfo hzMjGameInfo = (HangzhouMajiangGameInfo) game
				.getGameInfo();
		if (hzMjGameInfo.isBaiBanBaida()) {
			Card[] cards = mg.getAllCards().findCardsByType("白");
			for (int i = 0; i < cards.length; i++) {
				((MajiangCard) cards[i]).setBaida(true);
			}
		} else {
			MajiangCard mjTailCard = (MajiangCard) mg.getMajiangBlackCards()
					.removeTailCard();
			String nextType = mjTailCard.nextType();
			Card nextCards[] = mg.getAllCards().findCardsByType(nextType);
			for (Card c : nextCards) {
				((MajiangCard) c).setBaida(true);
			}
			mg.setBaida(mjTailCard);
		}

		mg.setLaoShu(3);
		if (!hzMjGameInfo.isSanLao()) {
			int laoshu = RandomUtil.getRandomNumber(2, 3);
			mg.setLaoShu(laoshu);
		}

	}

}
