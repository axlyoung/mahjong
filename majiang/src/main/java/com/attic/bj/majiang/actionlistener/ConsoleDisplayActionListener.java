package com.attic.bj.majiang.actionlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.ActionListener;
import com.attic.bj.core.game.Game;

public class ConsoleDisplayActionListener implements ActionListener {
	private static final Logger logger = LoggerFactory
			.getLogger(ConsoleDisplayActionListener.class);
	@Override
	public void listen(Game game, Action action) {
		// TODO Auto-generated method stub
		logger.info(game.toString());
	}

}
