package com.attic.bj.web.websocket;

import jakarta.servlet.http.HttpServletRequest;

import com.attic.bj.web.service.OnlineUserRegistry;
import com.attic.bj.weixinapi.entity.WeixinReplyUser;
import com.attic.bj.weixinapi.entity.WeixinUser;

public class DevMajiangHandshakeInterceptor extends MajiangHandshakeInterceptor {

	protected OnlineUserRegistry onlineUserRegistry;

	public void setOnlineUserRegistry(OnlineUserRegistry onlineUserRegistry) {
		this.onlineUserRegistry = onlineUserRegistry;
	}

	protected WeixinUser getWeixinUser(HttpServletRequest request) {
		WeixinReplyUser wru = new WeixinReplyUser();
		String code = request.getParameter("code");
		wru.setOpenid(code);
		wru.setNickname(code + "名字");
		wru.setHeadimgurl(
				"http://wx.qlogo.cn/mmopen/ajNVdqHZLLCVquUSK6R0JrKIy9KX6ckuYRVWnkcL3iciaUEVZhrwXicxaUIic15yvleO1rcLtnvlZ2L0X1uoBXN0lw/0");

		WeixinUser wu = new WeixinUser();
		wu.setOpenid(request.getParameter("code"));
		wu.setName(wu.getOpenid() + "名字");
		wu.setHeadUrl(
				"http://wx.qlogo.cn/mmopen/ajNVdqHZLLCVquUSK6R0JrKIy9KX6ckuYRVWnkcL3iciaUEVZhrwXicxaUIic15yvleO1rcLtnvlZ2L0X1uoBXN0lw/0");
		return wu;
	}
}
