package com.attic.bj.core.rule;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.Actions;
import com.attic.bj.core.game.Game;

public interface ActionJudger {
	public Actions judge(Game game,Action action);
}
