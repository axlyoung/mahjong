package com.attic.bj.web.service;

import java.util.List;

import com.attic.bj.common.service.TimerService;
import com.attic.bj.web.dao.entity.RoomDaoEntity;

public interface CheckRoomGameService extends TimerService {

	/**
	 * 查询用户创建的所有未开始的房间
	 * @param account
	 * @return 
	 */
	public List<RoomDaoEntity> findUnstartRoomByCreateAccount(String account);
	/**
	 * 查询所有未开始的房间
	 * @return
	 */
	public List<RoomDaoEntity> findUnstartRoom();
	/**
	 * 查询所有未结束的房间
	 * @return
	 */
	public List<RoomDaoEntity> findUnfinishRoom();
		
	public int getRoomTimeOut() ;

	public int getGameTimeOut();

}
