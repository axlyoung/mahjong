package com.attic.bj.majiang.rule.calculator;

import com.attic.bj.core.action.Actions;
import com.attic.bj.core.card.Cards;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.card.MajiangCards;
import com.attic.bj.majiang.game.MajiangGame;

public class MajiangMingGangActionCalculator extends MajiangActionCalculator {

	@Override
	protected Actions calculateActionInner(MajiangGame mjGame,
			MajiangAction mjAction) {
		// TODO Auto-generated method stub
		Actions actions = new MajiangActions();
		Cards cards = new MajiangCards();
		cards.addTailCard(mjGame.getMajiangBlackCards().getTailCard());
		actions.addAction(new MajiangAction(mjAction.getPlayer(),
				MajiangAction.MOBACK, cards, false));
		return actions;
	}

}
