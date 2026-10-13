package com.attic.bj.majiang.guangdong;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.game.Game;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.executor.MajiangAllocateActionExecutor;

public class GuangdongMajiangAllocateActionExecutor extends
		MajiangAllocateActionExecutor {

	public void exec(Game game, Action action) {
		super.exec(game, action);

		/**
		 * for auto dapai
		 */
		MajiangGame mjGame = (MajiangGame) game;
		for (int i = 0; i < game.getActivePlayers(); i++) {
			mjGame.putLastWaitUserActionTime(game.getPlayerByIndex(i)
					.getAccount(), System.currentTimeMillis() + 2 * 60 * 60
					* 1000);
		}

	}
}
