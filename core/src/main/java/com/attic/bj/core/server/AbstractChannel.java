package com.attic.bj.core.server;

import com.attic.bj.core.action.Actions;
import com.attic.bj.core.action.DefaultActions;
import com.attic.bj.core.room.DefaultRoom;
import com.attic.bj.core.room.Room;
import com.attic.bj.core.room.RoomInfo;
import com.attic.bj.core.user.DefaultPlayers;
import com.attic.bj.core.user.Players;

public abstract class AbstractChannel implements Channel {

	protected Server server;

	public void setServer(Server server) {
		this.server = server;
	}

	@Override
	public Server getServer() {
		return this.server;
	}
	
	@Override
	public Room createRoom(String account, RoomInfo roomInfo) {
		// TODO Auto-generated method stub
		String id = server.generateId();
		Room room = new DefaultRoom(roomInfo, id);
		room.setChannel(this);
		return room;
	}
	
	@Override
	public Players createPlayers(int size) {
		// TODO Auto-generated method stub
		return new DefaultPlayers(size);
	}
	
	
	@Override
	public Actions createActions() {
		// TODO Auto-generated method stub
		return new DefaultActions();
	}

}
