package com.attic.bj.weixinapi;

import com.attic.bj.weixinapi.entity.WeixinReplyOAuth2Token;
import com.attic.bj.weixinapi.entity.WeixinReplyUser;
import com.attic.bj.weixinapi.entity.WeixinSendOAuth2;
import com.attic.bj.weixinapi.entity.WeixinSendOAuth2Code;
import com.attic.bj.weixinapi.entity.WeixinSendOAuth2Refresh;
import com.attic.bj.weixinapi.entity.WeixinSendUser;
import com.attic.bj.weixinapi.exception.WeixinException;

/**
 * 
 * 
 * @author zhengbinhui
 * @since 04.14.2016
 */
public interface WeixinApiOAuth2 {
	public String getOAuth2DoorUrl(WeixinSendOAuth2 weixinSendOAuth2);

	public WeixinReplyOAuth2Token getOAuth2TokenByCode(WeixinSendOAuth2Code code)
			throws WeixinException;

	public WeixinReplyOAuth2Token refreshOAuth2Token(
			WeixinSendOAuth2Refresh weixinSendOAuth2Refresh)
			throws WeixinException;

	public WeixinReplyUser getOAuth2User(WeixinSendUser sendUser)
			throws WeixinException;

}
