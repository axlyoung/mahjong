package com.attic.bj.web.dao;

import java.util.List;

import com.attic.bj.web.dao.entity.GameAction;

public interface GameActionDao {

	public int insertGameAction(GameAction gameAction);

	public List<GameAction> selectGameActionsByGameid(int gameId);
}
