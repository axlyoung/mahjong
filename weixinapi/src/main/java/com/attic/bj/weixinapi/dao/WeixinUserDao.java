package com.attic.bj.weixinapi.dao;

import com.attic.bj.weixinapi.entity.WeixinReplyUser;

public interface WeixinUserDao {

	public WeixinReplyUser selectUserByOpenid(WeixinReplyUser weixinReplyUser);

	public int updateUserSubscribeByOpenid(WeixinReplyUser weixinReplyUser);

	public int updateUserByOpenid(WeixinReplyUser weixinReplyUser);

	public int insertUser(WeixinReplyUser weixinReplyUser);
	

}
