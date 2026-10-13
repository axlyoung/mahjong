package com.attic.bj.web.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.attic.bj.web.dao.GameAdviceDao;
import com.attic.bj.web.dao.entity.GameAdvice;

public class GameAdviceDaoImpl implements GameAdviceDao {

	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int insertGameAdvice(GameAdvice gameAdvice) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("game.insertGameAdvice",
				gameAdvice);
	}

	@Override
	public List<GameAdvice> seletGameAdvicesByAccount(String account) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList(
				"game.seletGameAdvicesByAccount", account);
	}

}
