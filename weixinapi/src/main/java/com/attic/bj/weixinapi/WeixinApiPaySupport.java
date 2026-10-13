package com.attic.bj.weixinapi;

import com.attic.bj.weixinapi.entity.WeixinSendPayParent;
import com.attic.bj.weixinapi.exception.WeixinException;

public interface WeixinApiPaySupport {

	public <OUT> OUT nonCertExec(WeixinSendPayParent weixinSendPayParent,
			String uri, String name, Class<OUT> out) throws WeixinException;

}
