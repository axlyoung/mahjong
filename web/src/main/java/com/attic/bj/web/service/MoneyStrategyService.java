package com.attic.bj.web.service;

import com.attic.bj.core.room.RoomInfo;

public interface MoneyStrategyService {

	public int newUserMoney();

	public boolean enoughMoney(String openid, RoomInfo roomInfo);

	public int needMoney(RoomInfo roomInfo);

	public void costMoney(String openid, int money);

	public int getMoneyOfPerJu();

	public void setMoneyOfPerJu(int moneyOfPerJu);

}
