package com.attic.bj.web.websocket;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.ActionListener;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.io.UserOutputApi;

public class WebSocketNotifyActionListener implements ActionListener {

	private UserOutputApi userOutputApi;

	public void setUserOutputApi(UserOutputApi userOutputApi) {
		this.userOutputApi = userOutputApi;
	}

	@Override
	public void listen(Game game, Action action) {
		// TODO Auto-generated method stub
		userOutputApi.listen(game, action);
	}
}
