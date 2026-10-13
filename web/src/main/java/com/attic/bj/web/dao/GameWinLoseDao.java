package com.attic.bj.web.dao;

import java.util.List;

import com.attic.bj.web.dao.entity.GameWinLose;
import com.attic.bj.web.dao.entity.Page;

public interface GameWinLoseDao {

	public GameWinLose selectGameWinLoseByOpenid(String openid);

	public List<GameWinLose> selectGameWinLoses();

	public List<GameWinLose> selectGameWinLosesByPage(Page page);

	public int insertGameWinLose(GameWinLose gameWinLose);

	public int deleteGameWinLoseByOpenid(String openid);
	
	public int updateGameWinLoseByOpenid(GameWinLose gameWinLose);
}
