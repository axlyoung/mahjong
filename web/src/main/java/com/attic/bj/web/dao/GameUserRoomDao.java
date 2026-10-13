package com.attic.bj.web.dao;

import java.util.Date;
import java.util.List;

import com.attic.bj.web.dao.entity.GameUserRoom;
import com.attic.bj.web.dao.entity.Page;

public interface GameUserRoomDao {
	
	public int insertGameUserRoom(GameUserRoom  gameUserRoom);
	
	public GameUserRoom selectLastGameUserRoomByAccount(String account);
	
	public List<GameUserRoom> selectGameUserRoomsByAccountAndTimeAndPage(String account,Date endTime,Page page);
}
