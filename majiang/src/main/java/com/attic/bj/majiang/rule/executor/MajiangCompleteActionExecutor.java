package com.attic.bj.majiang.rule.executor;

import com.attic.bj.core.game.DefaultPlayerScores;
import com.attic.bj.core.game.PlayerScores;
import com.attic.bj.core.game.ScoreComputer;
import com.attic.bj.majiang.action.MajiangAction;
import com.attic.bj.majiang.game.MajiangGame;
import com.attic.bj.majiang.rule.judger.hu.MajiangHuResults;

public class MajiangCompleteActionExecutor extends MajiangActionExecutor {

	private ScoreComputer scoreComputer;

	public void setScoreComputer(ScoreComputer scoreComputer) {
		this.scoreComputer = scoreComputer;
	}

	@Override
	public void execInner(MajiangGame mjGame, MajiangAction mjAction) {
		// TODO Auto-generated method stub
		MajiangHuResults mjHuResults = mjGame.getMajiangHuResults();
		PlayerScores playerScores = scoreComputer.computerScore(mjGame,
				mjHuResults);
		if (playerScores == null) {
			mjGame.setPlayerScores(new DefaultPlayerScores());
		} else {
			mjGame.setPlayerScores(playerScores);
		}
	}

}
