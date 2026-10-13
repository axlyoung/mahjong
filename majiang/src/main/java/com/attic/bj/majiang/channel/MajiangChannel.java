package com.attic.bj.majiang.channel;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.attic.bj.core.action.Actions;
import com.attic.bj.core.card.Cards;
import com.attic.bj.core.game.Game;
import com.attic.bj.core.room.Room;
import com.attic.bj.core.room.RoomInfo;
import com.attic.bj.core.rule.Rule;
import com.attic.bj.core.server.AbstractChannel;
import com.attic.bj.core.user.Player;
import com.attic.bj.majiang.action.MajiangActions;
import com.attic.bj.majiang.rule.MajiangRule;
import com.attic.bj.majiang.user.MajiangPlayer;

public class MajiangChannel extends AbstractChannel implements
		ApplicationContextAware {

	protected ApplicationContext applicationContext;

	private MajiangRule majiangRule;

	public void setMajiangRule(MajiangRule majiangRule) {
		this.majiangRule = majiangRule;
	}

	

	@Override
	public Player createPlayer(String account) {
		// TODO Auto-generated method stub
		return new MajiangPlayer(account);
	}

	@Override
	public Actions createActions() {
		// TODO Auto-generated method stub
		return new MajiangActions();
	}

	@Override
	public Game createGame(RoomInfo roomInfo, Game lastGame,Room room) {
		// TODO Auto-generated method stub

		return null;
	}

	

	@Override
	public Rule getRule(RoomInfo roomInfo) {
		// TODO Auto-generated method stub
		return this.majiangRule;
	}

	@Override
	public Cards createAllCards(RoomInfo roomInfo) {
		// TODO Auto-generated method stub
		return (Cards) this.applicationContext.getBean("majiangAllCardsOfFull");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = arg0;
	}

}
