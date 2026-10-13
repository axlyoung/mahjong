package com.attic.bj.majiang.rule.executor;

import com.attic.bj.core.card.Card;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.card.MajiangAnGangUnitCards;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangAnGangActionExecutor extends MajiangActionExecutor {

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub

		MajiangPlayer mp = (MajiangPlayer) mjAction.getPlayer();
		Card[] arrCards = mjAction.getCards().toArray();
		mp.getMajiangInnerCards().removeCards(arrCards);
		MajiangAnGangUnitCards magucs = new MajiangAnGangUnitCards((MajiangCard) arrCards[0], (MajiangCard) arrCards[1],
				(MajiangCard) arrCards[2], (MajiangCard) arrCards[3]);
		mp.getMajiangMiddleCards().addMajiangUnitCards(magucs);

	}

}
