package com.attic.bj.common.service;

import com.attic.bj.common.exception.TLCommunicationException;

public interface Transport {
	public Object submit(Object object) throws TLCommunicationException;
}
