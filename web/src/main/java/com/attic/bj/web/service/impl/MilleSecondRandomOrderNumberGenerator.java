package com.attic.bj.web.service.impl;

import com.attic.bj.common.util.RandomUtil;
import com.attic.bj.web.service.OrderNumberGenerator;



public class MilleSecondRandomOrderNumberGenerator implements OrderNumberGenerator {

	@Override
	public String generatorOrderNumber() {
		return System.currentTimeMillis()+RandomUtil.getRandomString(5);
	}

}
