package com.attic.bj.majiang.hongzhong;

import com.attic.bj.core.action.Actions;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.calculator.MajiangActionCalculator;

public class HongzhongMajiangHuActionCalculator extends MajiangActionCalculator {

	@Override
	protected Actions calculateActionInner(MajiangGame mjGame,
			MajiangAction mjAction) {
		MajiangActions mas = new MajiangActions();
		mas.addAction(new MajiangAction(null, MajiangAction.MAIMA, null, false));
		return mas;
	}

}
