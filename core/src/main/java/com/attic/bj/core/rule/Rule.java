package com.attic.bj.core.rule;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.game.Game;

public interface Rule {

	public void next(Game game, Action action);

//	public boolean canNext(Game game, Action action);
//
//	public Action  [] calNext(Game game, Action action);

}
