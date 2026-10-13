package com.attic.bj.weixinapi;

import com.attic.bj.weixinapi.entity.WeixinReplyQueryOrder;
import com.attic.bj.weixinapi.entity.WeixinReplyUnifiedOrder;
import com.attic.bj.weixinapi.entity.WeixinSendQueryOrder;
import com.attic.bj.weixinapi.entity.WeixinSendUnifiedOrder;
import com.attic.bj.weixinapi.exception.WeixinException;

public interface WeixinApiPay {
	public WeixinReplyUnifiedOrder unifiedOrder(
			WeixinSendUnifiedOrder weixinSendUnifiedOrder)
			throws WeixinException;

	public WeixinReplyQueryOrder queryOrder(
			WeixinSendQueryOrder weixinSendQueryOrder) throws WeixinException;


}
