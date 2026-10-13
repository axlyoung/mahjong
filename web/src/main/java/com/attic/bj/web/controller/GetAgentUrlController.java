package com.attic.bj.web.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.attic.bj.common.helper.Response;
import com.attic.bj.common.helper.ResponseFactory;
import com.attic.bj.web.dao.GameUserDao;
import com.attic.bj.web.dao.entity.GameUser;
import com.attic.bj.web.service.EnvironmentService;
import com.attic.bj.web.service.GameUserIdService;

/**
 * 
 * @author zhengbinhui
 * 
 */
@Controller
public class GetAgentUrlController {

	private static final Logger logger = LoggerFactory
			.getLogger(GetAgentUrlController.class);

	@Autowired
	private EnvironmentService environmentService;

	@Autowired
	private GameUserDao gameUserDao;

	@Autowired
	private GameUserIdService gameUserIdService;

	@RequestMapping(value = "getAgentUrl.do")
	@ResponseBody
	public Response getAgentUrl(HttpServletRequest request) {
		String account = environmentService.getAccount(request);
		if (StringUtils.isEmpty(account)) {
			return ResponseFactory.newResponse("000001", "不存在該用戶");
		}

		GameUser agentGu = gameUserDao.selectGameUserByAccount(account);
		if (agentGu == null) {
			return ResponseFactory.newResponse("000002", "不存在該用戶");
		}
		if (!agentGu.isRecommend()) {
			return ResponseFactory.newResponse("000003", "您不是代理人");
		}

		
		return ResponseFactory.newResponse("000000", "success", gameUserIdService.encode(agentGu.getId()));
	}
}