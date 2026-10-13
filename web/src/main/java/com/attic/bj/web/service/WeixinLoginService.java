package com.attic.bj.web.service;

import jakarta.servlet.http.HttpSession;

import com.attic.bj.weixinapi.entity.WeixinUser;

public interface WeixinLoginService {
	public static final String WEIXINUSERKEY = "__WEIXINUSERKEY";

	public WeixinUser login(String code, HttpSession hs);

	public WeixinUser isLogin(HttpSession hs);
	

}
