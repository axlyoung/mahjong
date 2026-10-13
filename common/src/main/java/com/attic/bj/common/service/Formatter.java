package com.attic.bj.common.service;

import com.attic.bj.common.exception.TLException;

public interface Formatter {
	public Object format(Object object) throws TLException;
}
