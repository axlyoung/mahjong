package com.attic.bj.core.game;

import com.attic.bj.core.user.Player;

public class SinglePlayerScore {
	
	private Player player;

	private int score;

	public SinglePlayerScore(Player player, int score) {
		this.player = player;
		this.score = score;
	}

	public Player getPlayer() {
		return player;
	}

	public int getScore() {
		return score;
	}
	
}
