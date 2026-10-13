package com.attic.bj.poker.channel;

import com.attic.bj.core.card.Cards;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.game.GameInfo;
import com.attic.bj.core.room.Room;
import com.attic.bj.core.room.RoomInfo;
import com.attic.bj.core.rule.Rule;
import com.attic.bj.core.server.AbstractChannel;
import com.attic.bj.core.user.Player;
import com.attic.bj.poker.card.PokerAllCards;
import com.attic.bj.poker.game.PokerGame;
import com.attic.bj.poker.rule.PokerRule;
import com.attic.bj.poker.user.PokerPlayer;

public class PokerChannel extends AbstractChannel {

	private PokerRule pokerRule;

	public void setPokerRule(PokerRule pokerRule) {
		this.pokerRule = pokerRule;
	}

	@Override
	public Player createPlayer(String account) {
		return new PokerPlayer(account);
	}

	@Override
	public Game createGame(RoomInfo roomInfo, Game lastGame, Room room) {
		// TODO Auto-generated method stub
		GameInfo gameInfo = new GameInfo();
		gameInfo.setPlayerNum(roomInfo.getPlayerNum());
		gameInfo.setTimeOut(-1);
		return new PokerGame(gameInfo);
	}

	@Override
	public Rule getRule(RoomInfo roomInfo) {
		return this.pokerRule;
	}

	@Override
	public Cards createAllCards(RoomInfo roomInfo) {
		PokerAllCards pokerAllCards = new PokerAllCards();
		pokerAllCards.start();
		return pokerAllCards;
	}

}
