package com.attic.bj.core.action;

import com.attic.bj.core.game.Game;

public interface ActionNotify {
	
	public void notify(Game game, Action action);

	public void addActionlistener(ActionListener actionListener);
}
