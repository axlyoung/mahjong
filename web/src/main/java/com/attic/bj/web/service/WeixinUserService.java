package com.attic.bj.web.service;

import jakarta.servlet.http.HttpServletRequest;

import com.attic.bj.weixinapi.entity.WeixinReplyUser;

public interface WeixinUserService {
	
	public WeixinReplyUser getWeixinUserByOpenid(String openid);
	
	public void putWeixinUser(WeixinReplyUser weixinReplyUser);
	
	public String getOriginIp(HttpServletRequest request);
}
