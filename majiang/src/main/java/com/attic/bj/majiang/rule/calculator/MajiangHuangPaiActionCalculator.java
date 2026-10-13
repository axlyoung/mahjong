package com.attic.bj.majiang.rule.calculator;

import com.attic.bj.core.action.Actions;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.game.MajiangGame;

public class MajiangHuangPaiActionCalculator extends MajiangActionCalculator {

	@Override
	protected Actions calculateActionInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub
		MajiangActions mas = new MajiangActions();
		mas.addAction(new MajiangAction(null, MajiangAction.COMPLETE, null, false));
		return mas;
	}

}
