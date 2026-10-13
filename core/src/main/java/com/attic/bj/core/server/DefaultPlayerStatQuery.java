package com.attic.bj.core.server;

import com.attic.bj.core.room.Room;
import com.attic.bj.core.user.Player;

public class DefaultPlayerStatQuery implements PlayerStatQuery {

	private Server server;

	public void setServer(Server server) {
		this.server = server;
	}

	@Override
	public PlayerStat queryPlayerStat(String account) {
		// TODO Auto-generated method stub
		Room room = server.getRoomByAccount(account);
		if (room == null) {
			return PlayerStat.DOOR;
		}
		Player player = room.getPlayerByAccount(account);
		if (room.isGaming()) {
			return PlayerStat.GAME;
		}
		return PlayerStat.ROOM;
	}

}
