package com.ula.authentication.filter;

import com.ula.authentication.service.user.UserDetailsServiceImplementation;
import com.ula.authentication.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;




public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	private JWTUtils tokenUtils;

	@Autowired
	private UserDetailsServiceImplementation userDetailsService;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		String authToken = httpRequest.getHeader("Authorization");
		String username = tokenUtils.getUsername(authToken);

		if ((username != null) && (SecurityContextHolder.getContext().getAuthentication() == null))
		{
			try
			{
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
				if (tokenUtils.validateToken(authToken, userDetails))
				{
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(
							new WebAuthenticationDetailsSource().buildDetails(httpRequest));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			} catch (UsernameNotFoundException e)
			{
				// TODO: handle exception
			}

		}
		chain.doFilter(req, res);
	}





}
