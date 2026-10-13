package com.attic.bj.web.controller;

import java.util.HashMap;
import java.util.Map;

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
import com.attic.bj.common.service.AdminService;
import com.attic.bj.web.dao.GameUserDao;
import com.attic.bj.web.service.EnvironmentService;

/**
 * 
 * @author zhengbinhui
 * 
 */
@Controller
public class GetTotalUsersController {

	private static final Logger logger = LoggerFactory
			.getLogger(GetTotalUsersController.class);

	@Autowired
	private EnvironmentService environmentService;

	@Autowired
	private GameUserDao gameUserDao;

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "getTotalUsers.do")
	@ResponseBody
	public Response getTotalUsers(HttpServletRequest request) {
		String account = environmentService.getAccount(request);
		if (StringUtils.isEmpty(account)) {
			return ResponseFactory.newResponse("000001", "不存在該用戶");
		}

		if (!adminService.isSuperAdmin(account)) {
			return ResponseFactory.newResponse("000001", "无权限!");
		}

		Map mapRet = new HashMap();
		mapRet.put("totalUsers", gameUserDao.selectTotalUsers());
		mapRet.put("totalLiveUsers", gameUserDao.selectTotalLiveUsers());
		return ResponseFactory.newResponse("000000", "success", mapRet);
	}
}