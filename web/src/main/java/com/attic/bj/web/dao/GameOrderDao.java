package com.attic.bj.web.dao;

import java.util.Map;

import com.attic.bj.web.dao.entity.TimeRange;

public interface GameOrderDao {

	public Map selectGameOrderByTradeNo(String outTradeNo);

	public int insertGameOrder(Map map);

	public int getTotalPayByTimeRange(TimeRange timeRange);
}
