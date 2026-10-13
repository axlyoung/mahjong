package com.attic.bj.core.game;

import com.attic.bj.core.action.Action;
import com.attic.bj.core.action.Actions;
import com.attic.bj.core.card.Card;
import com.attic.bj.core.card.Cards;
import com.attic.bj.core.lifecycle.LifeCycle;
import com.attic.bj.core.room.Room;
import com.attic.bj.core.rule.Rule;
import com.attic.bj.core.server.Formatter;
import com.attic.bj.core.user.Players;

public interface Game extends LifeCycle, Players, Formatter {

	public int getUniqueId();

	public void setUniqueId(int id);

	public GameInfo getGameInfo();

	public Action getLastAction();

	public Actions getHistoryActions();

	public Actions getLegalActions();

	public void addAction(Action action);

	public void nextAction(Action action);

	public void setPlayerScores(PlayerScores playerScores);

	public PlayerScores getPlayerScores();

	public void setPlayers(Players players);

	public void setActions(Actions actions);

	public void setLegalActions(Actions actions);

	public void setRule(Rule rule);

	public void setAllCards(Cards allCards);

	public void setRoom(Room room);

	public Room getRoom();

	public Cards getAllCards();

}
