package com.attic.bj.weixinhandle.pay;

import com.attic.bj.weixinapi.entity.WeixinAccount;
import com.attic.bj.weixinhandle.entity.Context;



public interface WeixinPayHandle {

	public void setWeixinAccount(WeixinAccount weixinAccount);

	public String handle(Context context);

	public String scanPayHandle(Context context);
}
