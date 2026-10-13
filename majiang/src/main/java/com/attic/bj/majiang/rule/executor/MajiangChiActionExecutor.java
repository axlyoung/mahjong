package com.attic.bj.majiang.rule.executor;

import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangChiUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangChiActionExecutor extends MajiangActionExecutor {

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub
		MajiangAction lastMjAction = (MajiangAction) mjGame.getLastAction();
		MajiangPlayer lastMjPlayer = (MajiangPlayer) lastMjAction.getPlayer();
		MajiangCard lastMjCard = (MajiangCard) lastMjAction.getCards().getTailCard();
		MajiangPlayer mp = (MajiangPlayer) mjAction.getPlayer();

		lastMjPlayer.getMajiangOutterCards().removeCard(lastMjCard);
		mp.getMajiangInnerCards().removeCards(mjAction.getCards().toArray());
		mjAction.getCards().removeCard(lastMjCard);
		MajiangChiUnitCards mcucs = new MajiangChiUnitCards(lastMjPlayer, lastMjCard,
				(MajiangCard) mjAction.getCards().toArray()[0], (MajiangCard) mjAction.getCards().toArray()[1]);
		mp.getMajiangMiddleCards().addMajiangUnitCards(mcucs);

	}

}
