package com.tieto.export.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UserTokenAuthenticationProvider implements AuthenticationProvider {
	    @Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	        
	        AuthenticationToken demoAuthentication = (AuthenticationToken) authentication;        
	        String userToken = demoAuthentication.getUsertoken();
	        User user = new User(userToken);
	        return user;
	    }
	    @Override
	    public boolean supports(Class<?> authentication) {
	        return AuthenticationToken.class.isAssignableFrom(authentication);
	    }
}