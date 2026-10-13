package com.attic.bj.weixinapi;

import com.attic.bj.weixinapi.entity.WeixinReplyUser;
import com.attic.bj.weixinapi.entity.WeixinReplyUsers;
import com.attic.bj.weixinapi.entity.WeixinSendUser;
import com.attic.bj.weixinapi.entity.WeixinSendUsers;
import com.attic.bj.weixinapi.exception.WeixinException;

/**
 * 
 * 
 * @author zhengbinhui
 * @since 04.14.2016
 */
public interface WeixinApiUser {
	public WeixinReplyUser getUserById(WeixinSendUser sendUser)
			throws WeixinException;

	public WeixinReplyUsers getUsers(WeixinSendUsers sendUsers)
			throws WeixinException;
}
