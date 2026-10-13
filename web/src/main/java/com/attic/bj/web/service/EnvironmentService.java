package com.attic.bj.web.service;

import jakarta.servlet.http.HttpServletRequest;

public interface EnvironmentService {

	public String getCodedUrl(String path);
	
	public String getFullUrl(String path);
	
	public String getAccount(HttpServletRequest request);
	
	public String getAppid();
	
	public String getEnvironment();

}
