package com.attic.bj.web.dao;

import java.util.List;

import com.attic.bj.web.dao.entity.GameAdvice;

public interface GameAdviceDao {

	public int insertGameAdvice(GameAdvice gameAdvice);

	public List<GameAdvice> seletGameAdvicesByAccount(String account);
}
