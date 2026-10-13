package com.attic.bj.weixinapi.impl;

import org.springframework.util.StringUtils;

import com.attic.bj.weixinapi.WeixinApiSupport;
import com.attic.bj.weixinapi.WeixinApiUser;
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
public class WeixinApiUserImpl implements WeixinApiUser {

	private WeixinApiSupport weixinApiSupport;

	public void setWeixinApiSupport(WeixinApiSupport weixinApiSupport) {
		this.weixinApiSupport = weixinApiSupport;
	}

	@Override
	public WeixinReplyUser getUserById(WeixinSendUser sendUser)
			throws WeixinException {
		// TODO Auto-generated method stub
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="
				+ sendUser.getAccessToken()
				+ "&openid="
				+ sendUser.getOpenId()
				+ "&lang=" + sendUser.getLang();
		return weixinApiSupport.postWeixin(url, null, WeixinReplyUser.class);
	}

	@Override
	public WeixinReplyUsers getUsers(WeixinSendUsers sendUsers)
			throws WeixinException {
		// TODO Auto-generated method stub
		String nextOpenid = sendUsers.getNext_openid();
		String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="
				+ sendUsers.getAccessToken();
		if (StringUtils.hasText(nextOpenid)) {
			url = url + "&next_openid=" + nextOpenid;
		}
		return weixinApiSupport.postWeixin(url, null, WeixinReplyUsers.class);
	}

}
