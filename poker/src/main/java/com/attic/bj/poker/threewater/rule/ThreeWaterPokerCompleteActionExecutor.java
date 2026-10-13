package com.attic.bj.poker.threewater.rule;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.game.DefaultPlayerScores;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.game.PlayerScores;
import com.attic.bj.core.rule.ActionExecutor;
import com.attic.bj.poker.threewater.ThreeWaterPokerGame;

public class ThreeWaterPokerCompleteActionExecutor implements ActionExecutor {

	private ThreeWaterPokerScoreComputer threeWaterPokerScoreComputer;

	public void setThreeWaterPokerScoreComputer(
			ThreeWaterPokerScoreComputer threeWaterPokerScoreComputer) {
		this.threeWaterPokerScoreComputer = threeWaterPokerScoreComputer;
	}

	@Override
	public void exec(Game game, Action action) {
		ThreeWaterPokerGame twpg = (ThreeWaterPokerGame) game;
		PlayerScores playerScores = threeWaterPokerScoreComputer.computerScore(
				game, twpg.getThreeWaterPokerResults());
		if (playerScores == null) {
			game.setPlayerScores(new DefaultPlayerScores());
			return;
		}
		game.setPlayerScores(playerScores);
	}

}
