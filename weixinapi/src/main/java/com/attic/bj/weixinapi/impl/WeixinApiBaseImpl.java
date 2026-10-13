package com.attic.bj.weixinapi.impl;

import com.attic.bj.weixinapi.WeixinApiBase;
import com.attic.bj.weixinapi.WeixinApiSupport;
import com.attic.bj.weixinapi.entity.WeixinReplyAccessToken;
import com.attic.bj.weixinapi.entity.WeixinReplyTicket;
import com.attic.bj.weixinapi.exception.WeixinException;

/**
 * 
 * 
 * @author zhengbinhui
 * @since 04.14.2016
 */
public class WeixinApiBaseImpl implements WeixinApiBase {

	private WeixinApiSupport weixinApiSupport;

	public void setWeixinApiSupport(WeixinApiSupport weixinApiSupport) {
		this.weixinApiSupport = weixinApiSupport;
	}

	@Override
	public WeixinReplyAccessToken getAccessToken(String appid, String secret)
			throws WeixinException {
		// TODO Auto-generated method stub
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ appid + "&secret=" + secret;
		return weixinApiSupport.postWeixin(url, null,
				WeixinReplyAccessToken.class);

	}

	@Override
	public WeixinReplyTicket getTicket(String accessToken)
			throws WeixinException {
		// TODO Auto-generated method stub
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
				+ accessToken + "&type=jsapi";
		return weixinApiSupport.postWeixin(url, null, WeixinReplyTicket.class);
	}
}
