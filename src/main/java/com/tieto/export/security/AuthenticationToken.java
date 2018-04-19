package com.tieto.export.security;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class AuthenticationToken extends AbstractAuthenticationToken {
	private static final long serialVersionUID = -1949976839306453197L;
	private User authenticatedUser;
	private String usertoken;
	public AuthenticationToken(String usertoken){
		super(Arrays.asList());
		this.usertoken = usertoken;    
		this.authenticatedUser = new User(usertoken);
	}
	public AuthenticationToken(Collection<? extends GrantedAuthority> authorities, User authenticatedUser, String uid) {
		super(authorities);
		this.usertoken = uid;
		this.authenticatedUser = authenticatedUser;
	}
	@Override
	public Object getCredentials() {
		return authenticatedUser.getPassword();
	}
	@Override
	public Object getPrincipal() {
		return new User("bacovjirtest");//.authenticatedUser;
	}
	public String getUsertoken() {
		return usertoken;
	}
}