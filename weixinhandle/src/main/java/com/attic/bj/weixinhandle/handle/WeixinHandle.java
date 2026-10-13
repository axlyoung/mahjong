package com.attic.bj.weixinhandle.handle;

import com.attic.bj.weixinapi.entity.WeixinAccount;
import com.attic.bj.weixinhandle.entity.Context;



/**
 * @author zhengbinhui
 * @since 04.14.2016
 */
public interface WeixinHandle {

	public void setWeixinAccount(WeixinAccount weixinAccount);

	public WeixinAccount getWeixinAccount();

	public String handle(Context context);
}
