package com.attic.bj.majiang.rule.executor;

import com.attic.bj.core.card.Card;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangPengUnitCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangPengActionExecutor extends MajiangActionExecutor {

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub
		MajiangAction lastMjAction = (MajiangAction) mjGame.getLastAction();
		MajiangPlayer lastMjPlayer = (MajiangPlayer) lastMjAction.getPlayer();
		MajiangCard lastMjCard = (MajiangCard) lastMjAction.getCards().getTailCard();
		MajiangPlayer mp = (MajiangPlayer) mjAction.getPlayer();

		Card[] arrCards = mjAction.getCards().toArray();
		MajiangPengUnitCards majiangPengUnitCards = new MajiangPengUnitCards(lastMjPlayer, lastMjCard,(MajiangCard) arrCards[0],
				(MajiangCard)arrCards[1]);

		lastMjPlayer.getMajiangOutterCards().removeCard(lastMjCard);
		mp.getMajiangInnerCards().removeCards(arrCards);
		mp.getMajiangMiddleCards().addMajiangUnitCards(majiangPengUnitCards);
	}

}
