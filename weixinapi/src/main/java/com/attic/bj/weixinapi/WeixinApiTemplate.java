package com.attic.bj.weixinapi;

import com.attic.bj.weixinapi.entity.WeixinReplyAddTemplate;
import com.attic.bj.weixinapi.entity.WeixinReplyCommon;
import com.attic.bj.weixinapi.entity.WeixinReplyPushTemplates;
import com.attic.bj.weixinapi.entity.WeixinReplyTemplate;
import com.attic.bj.weixinapi.entity.WeixinSendPushTemplate;
import com.attic.bj.weixinapi.exception.WeixinException;

public interface WeixinApiTemplate {

	public WeixinReplyCommon setIndustry(String accessToken,
			String industryId1, String industryId2) throws WeixinException;

	public WeixinReplyAddTemplate addTemplate(String accessToken,
			String templateIdShort) throws WeixinException;

	public WeixinReplyPushTemplates queryAllTemplate(String accessToken)
			throws WeixinException;

	public WeixinReplyTemplate template(WeixinSendPushTemplate template)
			throws WeixinException;

}
