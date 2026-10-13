package com.attic.bj.common.service;

import com.attic.bj.common.exception.TLException;

public interface Parser {
	public Object parse(Object object) throws TLException;
}
