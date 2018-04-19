package com.tieto.export.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tieto.export.security.AuthenticationFilter;
import com.tieto.export.security.UserTokenAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserTokenAuthenticationProvider demoAuthenticationProvider;
    
    @Autowired
    private AuthenticationFilter authenticationFilter;
   
    @Override
    protected void configure(HttpSecurity http) throws Exception {        
        http
		.csrf().disable()
		.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
			.antMatchers("/swagger-ui.html**", "/swagger-resources/**", "/v2/**", "/webjars/**", "/error" ).permitAll()
			.antMatchers("/**").hasRole("ADMIN")
			.antMatchers("/admin/**").hasRole("ADMIN");
        
        
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {        
        auth.authenticationProvider(demoAuthenticationProvider);      
        
//        auth.inMemoryAuthentication()
//        .withUser("admin")
//        .password("password")
//        .roles("ADMIN", "USER");
    }    
    
}