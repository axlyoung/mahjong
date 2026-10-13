package com.attic.bj.majiang.rule.calculator;

import com.attic.bj.core.action.Actions;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.game.MajiangGame;

public class MajiangPengActionCalculator extends MajiangActionCalculator {

	@Override
	protected Actions calculateActionInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub
		Actions actions = new MajiangActions();
		// Cards cards = new MajiangCards();
		// cards.addTailCard(mjGame.getMajiangBlackCards().getHeadCard());
		actions.addAction(new MajiangAction(mjAction.getPlayer(), MajiangAction.DANONHUA, null, true));
		return actions;
	}

}
