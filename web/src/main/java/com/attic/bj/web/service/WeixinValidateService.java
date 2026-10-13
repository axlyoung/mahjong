package com.attic.bj.web.service;

public interface WeixinValidateService {
	
	public boolean validate(String token,String signature,String timestamp,String nonce);
	
	
}
