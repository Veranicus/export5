package com.tieto.export.security;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value="request", proxyMode= ScopedProxyMode.TARGET_CLASS)
@Component
public class OriginatorImpl implements Originator{
	private String userToken;
	@Override
	public void setOriginator(String userToken) {
		this.userToken = userToken;
	}
	@Override
	public String getOriginator() {
		return this.userToken;
	}
}