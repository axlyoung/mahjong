package com.attic.bj.web.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.attic.bj.web.dao.GameDictDao;

public class GameDictDaoImpl implements GameDictDao {

	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public String selectValueByKey(String key) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("game.selectValueByKey",key);
	}

}
