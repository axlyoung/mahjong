package com.attic.bj.weixinapi.impl;

import com.attic.bj.weixinapi.WeixinApiPay;
import com.attic.bj.weixinapi.WeixinApiPaySign;
import com.attic.bj.weixinapi.WeixinApiPaySupport;
import com.attic.bj.weixinapi.entity.WeixinReplyQueryOrder;
import com.attic.bj.weixinapi.entity.WeixinReplyUnifiedOrder;
import com.attic.bj.weixinapi.entity.WeixinSendQueryOrder;
import com.attic.bj.weixinapi.entity.WeixinSendUnifiedOrder;
import com.attic.bj.weixinapi.exception.WeixinException;

public class WeixinApiPayImpl implements WeixinApiPay {

	private WeixinApiPaySupport weixinApiPaySupport;

	private WeixinApiPaySign weixinApiPaySign;

	public void setWeixinApiPaySign(WeixinApiPaySign weixinApiPaySign) {
		this.weixinApiPaySign = weixinApiPaySign;
	}

	public void setWeixinApiPaySupport(WeixinApiPaySupport weixinApiPaySupport) {
		this.weixinApiPaySupport = weixinApiPaySupport;
	}

	@Override
	public WeixinReplyUnifiedOrder unifiedOrder(
			WeixinSendUnifiedOrder weixinSendUnifiedOrder)
			throws WeixinException {
		// TODO Auto-generated method stub
		String uri = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		return weixinApiPaySupport.nonCertExec(weixinSendUnifiedOrder, uri,
				"微信统一下单接口", WeixinReplyUnifiedOrder.class);
	}

	@Override
	public WeixinReplyQueryOrder queryOrder(
			WeixinSendQueryOrder weixinSendQueryOrder) throws WeixinException {
		// TODO Auto-generated method stub
		String uri = "https://api.mch.weixin.qq.com/pay/orderquery";
		return weixinApiPaySupport.nonCertExec(weixinSendQueryOrder, uri,
				"微信查询订单接口", WeixinReplyQueryOrder.class);
	}

}
