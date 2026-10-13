package com.attic.bj.core.server;

import com.attic.bj.core.action.Actions;
import com.attic.bj.core.card.Cards;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.room.Room;
import com.attic.bj.core.room.RoomInfo;
import com.attic.bj.core.rule.Rule;
import com.attic.bj.core.user.Player;
import com.attic.bj.core.user.Players;

public interface Channel {

	// create room
	public Room createRoom(String account, RoomInfo roomInfo);

	public Player createPlayer(String account);

	public Actions createActions();

	public Game createGame(RoomInfo roomInfo,Game lastGame,Room room);

	public Players createPlayers(int size);

	public Rule getRule(RoomInfo roomInfo);

	public Cards createAllCards(RoomInfo roomInfo);

	public Server getServer();


}
