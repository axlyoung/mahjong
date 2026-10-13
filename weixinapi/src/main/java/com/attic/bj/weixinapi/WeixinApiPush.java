package com.attic.bj.weixinapi;

import com.attic.bj.weixinapi.entity.WeixinReplyCommon;
import com.attic.bj.weixinapi.entity.WeixinReplyManyPush;
import com.attic.bj.weixinapi.entity.WeixinSendManyPushByGroup;
import com.attic.bj.weixinapi.entity.WeixinSendManyPushByUsers;
import com.attic.bj.weixinapi.entity.WeixinSendPushImage;
import com.attic.bj.weixinapi.entity.WeixinSendPushNews;
import com.attic.bj.weixinapi.entity.WeixinSendPushText;
import com.attic.bj.weixinapi.entity.WeixinSendPushVoice;
import com.attic.bj.weixinapi.exception.WeixinException;

/**
 * 
 * 
 * @author zhengbinhui
 * @since 04.14.2016
 */
public interface WeixinApiPush {
	public WeixinReplyCommon text(WeixinSendPushText text)
			throws WeixinException;

	public WeixinReplyCommon image(WeixinSendPushImage image)
			throws WeixinException;

	public WeixinReplyCommon voice(WeixinSendPushVoice voice)
			throws WeixinException;

	public WeixinReplyCommon news(WeixinSendPushNews pushNews)
			throws WeixinException;


	public WeixinReplyManyPush manyPushByGroup(
			WeixinSendManyPushByGroup weixinSendManyPushByGroup)
			throws WeixinException;

	public WeixinReplyManyPush manyPushByUsers(
			WeixinSendManyPushByUsers weixinSendManyPushByUsers)
			throws WeixinException;
}
