package com.attic.bj.web.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.attic.bj.core.io.UserOutputApi;
import com.attic.bj.core.room.Room;
import com.attic.bj.core.room.RoomAction;
import com.attic.bj.core.room.RoomListener;
import com.attic.bj.core.user.Player;

public class WebSocketNotifyRoomListener implements RoomListener {

	private static final Logger logger = LoggerFactory
			.getLogger(WebSocketNotifyRoomListener.class);
	
	
	private UserOutputApi userOutputApi;

	public void setUserOutputApi(UserOutputApi userOutputApi) {
		this.userOutputApi = userOutputApi;
	}

	@Override
	public void listen(Player player, Room room, RoomAction roomAction) {
		logger.info("### WebSocketNotifyRoomListener roomListener " + (player == null?null:player.getAccount())+" "+roomAction);
		userOutputApi.listen(player, room, roomAction);
	}
}
