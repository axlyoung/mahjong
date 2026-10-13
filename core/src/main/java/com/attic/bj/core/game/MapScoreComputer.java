package com.attic.bj.core.game;

import java.util.Map;

import com.attic.bj.core.game.Game;
import com.attic.bj.core.game.PlayerScores;
import com.attic.bj.core.game.ScoreComputer;

public class MapScoreComputer implements ScoreComputer {

	private Map <String,ScoreComputer> mapScoreComputer;
	
	public void setMapScoreComputer(Map<String, ScoreComputer> mapScoreComputer) {
		this.mapScoreComputer = mapScoreComputer;
	}


	@Override
	public PlayerScores computerScore(Game game, Object object) {
		// TODO Auto-generated method stub
		String name = game.getRoom().getRoomInfo().getName();
		ScoreComputer scoreComputer = mapScoreComputer.get(name);
		return scoreComputer.computerScore(game, object);
	}

}
