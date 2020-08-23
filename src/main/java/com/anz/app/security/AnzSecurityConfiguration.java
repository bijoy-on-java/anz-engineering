package com.anz.app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AnzSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * ANZ Engineering: Spring security configuration method to application API's
	 * 
	 * @param httpSecurity
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().antMatcher("/api/anz/*").authorizeRequests().anyRequest().hasRole("ADMIN").and()
				.httpBasic();
	}

}
