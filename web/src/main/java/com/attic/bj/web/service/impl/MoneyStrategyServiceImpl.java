package com.attic.bj.web.service.impl;

import com.attic.bj.core.room.RoomInfo;
import com.attic.bj.web.dao.GameUserDao;
import com.attic.bj.web.dao.entity.GameUser;
import com.attic.bj.web.service.MoneyStrategyService;

public class MoneyStrategyServiceImpl implements MoneyStrategyService {

	private GameUserDao gameUserDao;

	private int moneyOfPerJu = 25;

	public int getMoneyOfPerJu() {
		return moneyOfPerJu;
	}

	public void setMoneyOfPerJu(int moneyOfPerJu) {
		this.moneyOfPerJu = moneyOfPerJu;
	}

	public void setGameUserDao(GameUserDao gameUserDao) {
		this.gameUserDao = gameUserDao;
	}

	@Override
	public boolean enoughMoney(String openid, RoomInfo roomInfo) {
		// TODO Auto-generated method stub
		int hasMoney = gameUserDao.selectGameUserByAccount(openid).getMoney();
		int needMoney = this.needMoney(roomInfo);
		return hasMoney >= needMoney;
	}

	@Override
	public int needMoney(RoomInfo roomInfo) {
		// if ("hongzhongMajiang".equals(roomInfo.getName())
		// || "guangdongMajiang".equals(roomInfo.getName())) {
		// return moneyOfPerJu * roomInfo.getTotalJu();
		// }
		// return moneyOfPerJu * roomInfo.getTotalJu() / 4 *3;

		if ("xiangshanMajiang".equals(roomInfo.getName())
				|| "threeWater".equals(roomInfo.getName())
				|| "fenghuaMajiang".equals(roomInfo.getName())
				|| "hangzhouMajiang".equals(roomInfo.getName())
				|| "tiantaiMajiang".equals(roomInfo.getName())) {
			return 0;
		}

		int ju = roomInfo.getTotalJu();
		if (ju == 4) {
			return 2;
		} else if (ju == 8) {
			return 3;
		} else if (ju == 12) {
			return 4;
		} else if (ju == 16) {
			return 5;
		}
		return 999999;
	}

	@Override
	public void costMoney(String openid, int money) {
		// TODO Auto-generated method stub
		GameUser gameUser = new GameUser();
		gameUser.setOpenid(openid);
		gameUser.setMoney(0 - money);
		gameUserDao.addMoney(gameUser);
	}

	@Override
	public int newUserMoney() {
		// TODO Auto-generated method stub
		return 6;
	}

}
