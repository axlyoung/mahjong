package com.attic.bj.majiang.rule.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.Actions;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.rule.ActionCalculator;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.game.MajiangGame;

public abstract class MajiangActionCalculator implements ActionCalculator {

	private static final Logger logger = LoggerFactory
			.getLogger(MajiangActionCalculator.class);
	
	public Actions calculateAction(Game game, Action action) {
		// TODO Auto-generated method stub
		return calculateActionInner((MajiangGame) game, (MajiangAction) action);
	}

	abstract protected Actions calculateActionInner(MajiangGame mjGame,
			MajiangAction mjAction);

}
