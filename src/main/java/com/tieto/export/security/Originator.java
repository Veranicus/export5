package com.tieto.export.security;

public interface Originator {
	public void setOriginator(String userToken);
	public String getOriginator();
}