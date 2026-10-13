package com.attic.bj.poker.threewater;

import com.attic.bj.core.card.Cards;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.game.GameInfo;
import com.attic.bj.core.room.Room;
import com.attic.bj.core.room.RoomInfo;
import com.attic.bj.core.user.Player;
import com.attic.bj.poker.card.PokerAllCards;
import com.attic.bj.poker.channel.PokerChannel;

public class ThreeWaterPokerChannel extends PokerChannel {
	
	
	
	@Override
	public Player createPlayer(String account) {
		return new ThreeWaterPokerPlayer(account);
	}
	
	
	
	@Override
	public Game createGame(RoomInfo roomInfo, Game lastGame, Room room) {
		// TODO Auto-generated method stub
		GameInfo gameInfo = new GameInfo();
		gameInfo.setPlayerNum(roomInfo.getPlayerNum());
		gameInfo.setTimeOut(-1);
		return new ThreeWaterPokerGame(gameInfo);
	}


	@Override
	public Cards createAllCards(RoomInfo roomInfo) {
		PokerAllCards pokerAllCards = new PokerAllCards();
		pokerAllCards.start();
		pokerAllCards.removeTailCard();
		pokerAllCards.removeTailCard();
		return pokerAllCards;
	}
}
