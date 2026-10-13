package com.attic.bj.web.controller;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.attic.bj.common.util.InputStreamUtil;
import com.attic.bj.common.util.XmlUtil;
import com.attic.bj.web.service.WeixinValidateService;
import com.attic.bj.weixinapi.WeixinCachedApiBase;
import com.attic.bj.weixinapi.entity.WeixinAccount;
import com.attic.bj.weixinhandle.entity.Context;
import com.attic.bj.weixinhandle.handle.WeixinHandle;

/**
 * 
 * @author zhengbinhui
 * 
 */
@Controller
public class WeixinCallBackController {

	private static final Logger logger = LoggerFactory
			.getLogger(WeixinCallBackController.class);

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private WeixinCachedApiBase weixinCachedApiBase;

	@Autowired
	private WeixinValidateService weixinValidateService;

	@RequestMapping(value = "callBack.do", method = RequestMethod.GET)
	@ResponseBody
	public String callBackValidate(
			@RequestParam(required = true) String signature,
			@RequestParam(required = true) String timestamp,
			@RequestParam(required = true) String nonce,
			@RequestParam(required = true) String echostr) {

		String token = this.weixinCachedApiBase.getWeixinAccounts().get(0)
				.getToken();
		logger.debug(token + " " + signature + " " + timestamp + " " + nonce
				+ " " + echostr);
		if (weixinValidateService.validate(token, signature, timestamp, nonce))
			return echostr;
		return "";
	}

	@RequestMapping(value = "callBack.do", method = RequestMethod.POST, headers = "content-type=text/xml")
	@ResponseBody
	public String callBack(@RequestParam(required = true) String signature,
			@RequestParam(required = true) String timestamp,
			@RequestParam(required = true) String nonce,
			HttpServletRequest request) {
		String token = this.weixinCachedApiBase.getWeixinAccounts().get(0)
				.getToken();
		logger.debug(token + " " + signature + " " + timestamp + " " + nonce
				+ " ");
		if (!weixinValidateService.validate(token, signature, timestamp, nonce)) {
			return "";
		}
		Context context = null;
		String strReq = null;
		try {
			byte[] byteReq = InputStreamUtil.readStream(
					request.getInputStream(), request.getContentLength());
			strReq = new String(byteReq, "utf-8");
			logger.debug("### coming from weixin content [" + strReq + "] ");
			Map mapReq = XmlUtil.decode(strReq);
			context = new Context(request);
			context.putAll(mapReq);
		} catch (Exception e) {
			logger.error("### error", e);
			return "";
		}
		String account = context.getString("ToUserName");
		WeixinAccount wa = this.weixinCachedApiBase
				.getWeixinAccountByAccount(account);
		String name = wa.getName();
		WeixinHandle weixinHandle = (WeixinHandle) this.applicationContext
				.getBean(name + "WeixinHandle");
		if (weixinHandle == null) {
			logger.error("### can not find the named weixinHandle,name[" + name
					+ "]");
			return "";
		}
		weixinHandle.setWeixinAccount(wa);
		return weixinHandle.handle(context);
	}
}
