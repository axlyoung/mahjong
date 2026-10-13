package com.attic.bj.web.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.attic.bj.web.dao.GameActionDao;
import com.attic.bj.web.dao.entity.GameAction;

public class GameActionDaoImpl implements GameActionDao {

	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int insertGameAction(GameAction gameAction) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("game.insertGameAction",
				gameAction);
	}

	@Override
	public List<GameAction> selectGameActionsByGameid(int gameId) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList(
				"game.selectGameActionsByGameid", gameId);
	}

}
