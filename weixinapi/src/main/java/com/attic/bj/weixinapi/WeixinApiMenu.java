package com.attic.bj.weixinapi;

import com.attic.bj.weixinapi.entity.WeixinReplyCommon;
import com.attic.bj.weixinapi.entity.WeixinSendMenus;
import com.attic.bj.weixinapi.exception.WeixinException;


public interface WeixinApiMenu {
	public WeixinReplyCommon createMenu(WeixinSendMenus wsms)throws WeixinException;
}
