package com.attic.bj.weixinhandle.handle;

import com.attic.bj.weixinapi.WeixinApiMedia;
import com.attic.bj.weixinapi.WeixinApiMenu;
import com.attic.bj.weixinapi.WeixinApiOAuth2;
import com.attic.bj.weixinapi.WeixinApiPush;
import com.attic.bj.weixinapi.WeixinApiReply;
import com.attic.bj.weixinapi.WeixinApiUser;
import com.attic.bj.weixinapi.WeixinCachedApiBase;

/**
 * @author zhengbinhui
 * @since 04.14.2016
 */
public class WeixinApiHandle extends WeixinBaseHandle {

	private WeixinCachedApiBase weixinCachedApiBase;
	private WeixinApiReply weixinApiReply;
	private WeixinApiPush weixinApiPush;
	private WeixinApiMedia weixinApiMedia;
	private WeixinApiOAuth2 weixinApiOAuth2;
	private WeixinApiUser weixinApiUser;
	private WeixinApiMenu weixinApiMenu;

	public void setWeixinApiOAuth2(WeixinApiOAuth2 weixinApiOAuth2) {
		this.weixinApiOAuth2 = weixinApiOAuth2;
	}

	public void setWeixinApiUser(WeixinApiUser weixinApiUser) {
		this.weixinApiUser = weixinApiUser;
	}

	public WeixinApiMenu getWeixinApiMenu() {
		return weixinApiMenu;
	}

	public void setWeixinApiMenu(WeixinApiMenu weixinApiMenu) {
		this.weixinApiMenu = weixinApiMenu;
	}

	public void setWeixinApiPush(WeixinApiPush weixinApiPush) {
		this.weixinApiPush = weixinApiPush;
	}

	public void setWeixinApiMedia(WeixinApiMedia weixinApiMedia) {
		this.weixinApiMedia = weixinApiMedia;
	}

	public void setWeixinCachedApiBase(WeixinCachedApiBase weixinCachedApiBase) {
		this.weixinCachedApiBase = weixinCachedApiBase;
	}

	public WeixinCachedApiBase getWeixinCachedApiBase() {
		return weixinCachedApiBase;
	}

	public WeixinApiPush getWeixinApiPush() {
		return weixinApiPush;
	}

	public WeixinApiMedia getWeixinApiMedia() {
		return weixinApiMedia;
	}

	public WeixinApiOAuth2 getWeixinApiOAuth2() {
		return weixinApiOAuth2;
	}

	public WeixinApiUser getWeixinApiUser() {
		return weixinApiUser;
	}

	public WeixinApiReply getWeixinApiReply() {
		return weixinApiReply;
	}

	public void setWeixinApiReply(WeixinApiReply weixinApiReply) {
		this.weixinApiReply = weixinApiReply;
	}

}
