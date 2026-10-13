package com.attic.bj.core.room;

import com.attic.bj.core.user.Player;

public class PrintRoomListener implements RoomListener {

	@Override
	public void listen(Player player, Room room, RoomAction roomAction) {
		// TODO Auto-generated method stub
		System.out.println(room);
	}

	

}
