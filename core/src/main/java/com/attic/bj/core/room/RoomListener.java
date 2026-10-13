package com.attic.bj.core.room;

import com.attic.bj.core.user.Player;

public interface RoomListener {
	public void listen(Player player,Room room,RoomAction roomAction);
}
