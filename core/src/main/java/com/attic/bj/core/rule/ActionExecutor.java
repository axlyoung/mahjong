package com.attic.bj.core.rule;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.game.Game;

public interface ActionExecutor {
	public void exec(Game game, Action action);
}
