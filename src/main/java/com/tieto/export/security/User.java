package com.tieto.export.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class User implements /*UserDetails,*/ Authentication {
	private static final long serialVersionUID = -6085970405911378177L;
	private String username;
	private String password;
	private Set<String> roles;
	
	public User(String username) {
		super();
		this.username = username;
	}
	
	public User(String username, Set<String> roles) {
		super();
		this.username = username;
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.username;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if(roles != null) {
			for (String role : roles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
				authorities.add(authority);
			}
		}
		return authorities;
	}
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return  new Object();
	}
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return new Object();
	}
	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
}