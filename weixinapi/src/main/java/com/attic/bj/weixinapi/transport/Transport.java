package com.attic.bj.weixinapi.transport;

import com.attic.bj.weixinapi.exception.WeixinException;

public interface Transport {

	public Object submit(Object object) throws WeixinException;
}
