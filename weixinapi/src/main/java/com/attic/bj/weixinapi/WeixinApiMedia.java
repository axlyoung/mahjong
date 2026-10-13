package com.attic.bj.weixinapi;

import com.attic.bj.weixinapi.entity.WeixinReplyCommon;
import com.attic.bj.weixinapi.entity.WeixinReplyMedia;
import com.attic.bj.weixinapi.entity.WeixinSendMedia;
import com.attic.bj.weixinapi.exception.WeixinException;

/**
 * @author zhengbinhui
 * @since 04.14.2016
 */
public interface WeixinApiMedia {

	public WeixinReplyMedia uploadPermanentMedia(WeixinSendMedia weixinSendMedia)
			throws WeixinException;

	public WeixinReplyCommon deletePermanentMedia(String accessToken,
			String mediaId) throws WeixinException;
	
	public WeixinReplyMedia uploadTemporarytMedia(WeixinSendMedia weixinSendMedia)
			throws WeixinException;

}
