package com.attic.bj.majiang.rule.executor;

import com.attic.bj.core.card.Card;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangMingGangUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangMingGangActionExecutor extends MajiangActionExecutor {

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub
		MajiangAction lastMjAction = (MajiangAction) mjGame.getLastAction();
		MajiangPlayer lastMjPlayer = (MajiangPlayer) lastMjAction.getPlayer();
		MajiangCard lastMjCard = (MajiangCard) lastMjAction.getCards().getTailCard();
		MajiangPlayer mp = (MajiangPlayer) mjAction.getPlayer();

		Card arrCards[] = mjAction.getCards().toArray();
		lastMjPlayer.getMajiangOutterCards().removeCard(lastMjCard);

		MajiangMingGangUnitCards majiangMingGangUnitCards = new MajiangMingGangUnitCards(lastMjPlayer, lastMjCard,
				(MajiangCard) arrCards[0], (MajiangCard) arrCards[1], (MajiangCard) arrCards[2]);
		mp.getMajiangMiddleCards().addMajiangUnitCards(majiangMingGangUnitCards);

		mp.getMajiangInnerCards().removeCards(arrCards);
	}

}
