package com.ula.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;

import com.ula.security.filters.AuthenticationTokenFilter;
import com.ula.security.filters.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("bcrypt", new BCryptPasswordEncoder());

		DelegatingPasswordEncoder passworEncoder = new DelegatingPasswordEncoder("bcrypt",
				encoders);
		passworEncoder.setDefaultPasswordEncoderForMatches(encoders.get("bcrypt"));
		return passworEncoder;
	}

	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder)
			throws Exception {
		authenticationManagerBuilder.userDetailsService(this.userDetailsService)
				.passwordEncoder(this.getPasswordEncoder()).and().jdbcAuthentication();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
		authenticationTokenFilter.setAuthenticationManager(this.authenticationManagerBean());
		return authenticationTokenFilter;
	}

	@Bean
	CorsFilter corsFilter() {
		CorsFilter filter = new CorsFilter();
		return filter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(corsFilter(), SessionManagementFilter.class);
		http.addFilterBefore(authenticationTokenFilterBean(),
				UsernamePasswordAuthenticationFilter.class);
		http.csrf().disable();
	}

}
