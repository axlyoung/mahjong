package com.attic.bj.weixinapi.impl;

import com.attic.bj.weixinapi.WeixinApiMenu;
import com.attic.bj.weixinapi.WeixinApiSupport;
import com.attic.bj.weixinapi.entity.WeixinReplyCommon;
import com.attic.bj.weixinapi.entity.WeixinSendMenus;
import com.attic.bj.weixinapi.exception.WeixinException;



public class WeixinApiMenuImpl implements WeixinApiMenu {

	private WeixinApiSupport weixinApiSupport;

	public void setWeixinApiSupport(WeixinApiSupport weixinApiSupport) {
		this.weixinApiSupport = weixinApiSupport;
	}

	@Override
	public WeixinReplyCommon createMenu(WeixinSendMenus wsms)
			throws WeixinException {
		// TODO Auto-generated method stub
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
				+ wsms.getAccessToken();
		return weixinApiSupport.postWeixin(url, wsms, WeixinReplyCommon.class);
	}

}
