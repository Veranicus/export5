package com.tieto.export.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tieto.export.security.Originator;
import com.tieto.export.security.OriginatorImpl;

@Configuration
public class BeanConfig {

	
	@Bean
	public Originator originator(){
		return new OriginatorImpl();
	}
}
