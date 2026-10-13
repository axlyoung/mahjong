package com.attic.bj.poker.game;

import com.attic.bj.core.game.DefaultGame;
import com.attic.bj.core.game.GameInfo;
import com.attic.bj.poker.card.PokerBlackCards;

public class PokerGame extends DefaultGame {

	protected PokerBlackCards pokerBlackCards;
	
	public PokerBlackCards getPokerBlackCards() {
		return pokerBlackCards;
	}

	public PokerGame(GameInfo gameInfo) {
		super(gameInfo);
		// TODO Auto-generated constructor stub
	}
	
	public void stop() {
		this.getRoom().gameStop(this);
	}

}
