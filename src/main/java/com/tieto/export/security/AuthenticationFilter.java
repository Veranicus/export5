package com.tieto.export.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class AuthenticationFilter extends GenericFilterBean {
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);
	
	private Originator originatorService;
	
	@Autowired
	public AuthenticationFilter(Originator originator) {
		super();
		this.originatorService = originator;
	}
	
	Map<String, User> userDB = null;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = this.getAsHttpRequest(request);
		String userName = httpRequest.getHeader("cas-user");
		String requestid = httpRequest.getHeader("transaction-id");
		String originator = httpRequest.getHeader("originator");
		originatorService.setOriginator(originator);
		
		String mdcData = String.format("[%s|%s] ", requestid, originator);
		
		MDC.put("mdcData", mdcData); // Variable 'mdcData' is referenced in Spring Boot's logging.pattern.level property
		
		String url = httpRequest.getRequestURL().toString();
		String method = httpRequest.getMethod();
		log.debug("accessing {} {}.", method, url);
		
		if (userName != null) {
			User userDetails = getUser(userName);
			if (userDetails != null) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		
		chain.doFilter(request, response);
		MDC.clear();
	}
	
	private User getUser(String userName) {
		if (userDB == null) {
			Set<String> roles = new HashSet<String>();
			roles.add("ROLE_ADMIN");
			roles.add("ROLE_ACTUATOR");
			userDB = new HashMap<String, User>();
			User admin = new User("admin", roles);
			userDB.put("admin", admin);
			
			Set<String> roles2 = new HashSet<String>();
			roles2.add("ROLE_USER");
			User user = new User("bacovjir", roles2);
			userDB.put("bacovjir", user);
		}
		return userDB.get(userName);
	}
	private HttpServletRequest getAsHttpRequest(ServletRequest request) {
		if (!(request instanceof HttpServletRequest)) {
			throw new RuntimeException("Expecting an HTTP request");
		}
		
		return (HttpServletRequest) request;
	}
}