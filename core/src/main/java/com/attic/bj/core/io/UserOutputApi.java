package com.attic.bj.core.io;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.room.Room;
import com.attic.bj.core.room.RoomAction;
import com.attic.bj.core.user.Player;

public interface UserOutputApi {

	
	/**
	 * 用户进入房间后的一些通知动作
	 * @param player
	 * @param room
	 * @param roomAction
	 */
	public void listen(Player player, Room room, RoomAction roomAction);

	/**
	 * 
	 * @param game
	 * @param action
	 */
	public void listen(Game game, Action action);

	public void connect(String account);

	public void disconnect(String account);
}
