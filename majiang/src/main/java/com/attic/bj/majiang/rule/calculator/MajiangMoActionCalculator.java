package com.attic.bj.majiang.rule.calculator;

import com.attic.bj.core.action.Actions;
import com.attic.bj.core.card.Cards;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.card.MajiangCard;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.MajiangActionJudger;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangMoActionCalculator extends MajiangActionCalculator {

	protected MajiangActionJudger huActionJudger = null;

	protected MajiangActionJudger anGangActionJudger = null;

	protected MajiangActionJudger xianGangActionJudger = null;

	public void setHuActionJudger(MajiangActionJudger huActionJudger) {
		this.huActionJudger = huActionJudger;
	}

	public void setAnGangActionJudger(MajiangActionJudger anGangActionJudger) {
		this.anGangActionJudger = anGangActionJudger;
	}

	public void setXianGangActionJudger(MajiangActionJudger xianGangActionJudger) {
		this.xianGangActionJudger = xianGangActionJudger;
	}

	@Override
	protected Actions calculateActionInner(MajiangGame mjGame,
			MajiangAction mjAction) {
		// TODO Auto-generated method stub
		Actions actions = new MajiangActions();
		MajiangPlayer mjPlayer = (MajiangPlayer) mjAction.getPlayer();
		MajiangCard mjCard = (MajiangCard) mjAction.getCards().getHeadCard();

		if (mjCard.isUnit(MajiangCard.HUA) && !mjCard.isBaida()) {
			Cards cards = new MajiangCards();
			cards.addHeadCard(mjCard);
			actions.addAction(new MajiangAction(mjAction.getPlayer(),
					MajiangAction.DAHUA, cards, false));
			return actions;
		}
		actions.addAction(new MajiangAction(mjPlayer, MajiangAction.DANONHUA,
				null, true));

		if (huActionJudger != null) {
			actions.addActions(huActionJudger.judge(mjGame, mjAction));
		}

		if (anGangActionJudger != null) {
			actions.addActions(anGangActionJudger.judge(mjGame, mjAction));
		}

		if (xianGangActionJudger != null) {
			actions.addActions(xianGangActionJudger.judge(mjGame, mjAction));
		}
		return actions;
	}

}
