package com.attic.bj.weixinapi;

import com.attic.bj.weixinapi.entity.WeixinSendReplyImage;
import com.attic.bj.weixinapi.entity.WeixinSendReplyNews;
import com.attic.bj.weixinapi.entity.WeixinSendReplyText;
import com.attic.bj.weixinapi.entity.WeixinSendReplyVoice;


/**
 * 
 * 
 * @author zhengbinhui
 * @since 04.14.2016
 */
public interface WeixinApiReply {
	public String replyText(WeixinSendReplyText text);

	public String replyImage(WeixinSendReplyImage image);

	public String replyNews(WeixinSendReplyNews news);

	public String replyVoice(WeixinSendReplyVoice voice);
}
