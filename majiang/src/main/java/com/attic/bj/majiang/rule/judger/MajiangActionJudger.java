package com.attic.bj.majiang.rule.judger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.Actions;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.rule.ActionJudger;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.game.MajiangGame;

public abstract class MajiangActionJudger implements ActionJudger {

	private static final Logger logger = LoggerFactory
			.getLogger(MajiangActionJudger.class);

	public Actions judge(Game game, Action action) {
		// TODO Auto-generated method stub
		logger.debug("### enter into " + this.getClass());
		return this.judgeInner((MajiangGame) game, (MajiangAction) action);
	}

	abstract protected MajiangActions judgeInner(MajiangGame mjGame,
			MajiangAction mjAction);

}
