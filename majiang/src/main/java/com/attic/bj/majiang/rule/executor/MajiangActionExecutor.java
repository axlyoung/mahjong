package com.attic.bj.majiang.rule.executor;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.rule.ActionExecutor;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.game.MajiangGame;

public abstract class MajiangActionExecutor implements ActionExecutor {

	public void exec(Game game, Action action) {
		// TODO Auto-generated method stub
		MajiangGame mjGame = (MajiangGame) game;
		MajiangAction mjAction = (MajiangAction) action;
		this.execInner(mjGame, mjAction);
	}

	abstract public void execInner(MajiangGame mjGame, MajiangAction mjAction);

}
