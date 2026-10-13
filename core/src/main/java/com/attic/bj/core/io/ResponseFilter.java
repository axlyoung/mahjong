package com.attic.bj.core.io;

import java.util.Map;

import com.attic.bj.core.room.Room;
import com.attic.bj.core.user.Player;

public interface ResponseFilter {
	/**
	 * 
	 * @param player
	 *            待推送的用户
	 * @param map
	 * @param room
	 * @return
	 */
	public Map filter(Player player, Map map, Room room);
}
