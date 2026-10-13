package com.attic.bj.majiang.rule.judger;

import com.attic.bj.core.card.Card;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.card.MajiangInnerCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangPengActionJudger extends MajiangActionJudger {

	private boolean canBaida = false;
	
	public void setCanBaida(boolean canBaida) {
		this.canBaida = canBaida;
	}
	
	
	private MajiangActions penJuger(MajiangPlayer mp, MajiangInnerCards mics,
			MajiangCard mjCard) {
		MajiangActions mas = new MajiangActions();
		Card[] arrCards = mics.findCardsByType(mjCard.getType());
		if (arrCards == null) {
			return null;
		}
		if (arrCards.length == 2) {
			MajiangCards mcs = new MajiangCards();
			mcs.addTailCards(arrCards);
			mas.addAction(new MajiangAction(mp, MajiangAction.PENG, mcs, true));
			return mas;
		}
		if (arrCards.length == 3) {
			MajiangCards mcs = new MajiangCards();
			mcs.addTailCard(arrCards[0]);
			mcs.addTailCard(arrCards[1]);
			mas.addAction(new MajiangAction(mp, MajiangAction.PENG, mcs, true));

			mcs = new MajiangCards();
			mcs.addTailCard(arrCards[0]);
			mcs.addTailCard(arrCards[2]);
			mas.addAction(new MajiangAction(mp, MajiangAction.PENG, mcs, true));

			mcs = new MajiangCards();
			mcs.addTailCard(arrCards[1]);
			mcs.addTailCard(arrCards[2]);
			mas.addAction(new MajiangAction(mp, MajiangAction.PENG, mcs, true));

			return mas;
		}
		return null;
	}

	@Override
	protected MajiangActions judgeInner(MajiangGame mjGame,
			MajiangAction mjAction) {
		// TODO Auto-generated method stub
		// logger.debug("### enter into the pengActionJudgeInner");
		MajiangActions mas = new MajiangActions();
		MajiangCard mjCard = (MajiangCard) mjAction.getCards().getTailCard();
		if(!this.canBaida){
			if (mjCard.isBaida()) {
				return null;
			}
		}
		MajiangPlayer mp = (MajiangPlayer) mjAction.getPlayer();
		MajiangPlayer nextMp = (MajiangPlayer) mjGame.nextPlayer(mp);
		MajiangActions tmpMas = null;
		while (nextMp != mp) {
			tmpMas = this.penJuger(nextMp, nextMp.getMajiangInnerCards(),
					mjCard);
			if (tmpMas != null) {
				mas.addActions(tmpMas);
				break;
			}
			nextMp = (MajiangPlayer) mjGame.nextPlayer(nextMp);
		}
		return mas.size() == 0 ? null : mas;
	}
}
