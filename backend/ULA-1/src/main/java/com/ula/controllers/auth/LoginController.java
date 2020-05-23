package com.ula.controllers.auth;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ula.models.User;
import com.ula.services.UserDetailsServiceImplementation;
import com.ula.utils.JWTUtils;

@Controller
@RequestMapping("/api/v1/auth/login")
public class LoginController {


	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImplementation userDetailsService;

	@Autowired
	private JWTUtils jwt;


	@PostMapping
	public ResponseEntity<HashMap<String, String>> login(@RequestBody User user) {

		UsernamePasswordAuthenticationToken token;
		UserDetails userDetails;
		try {
			if (!user.getUsername().equals("")) {
				token = new UsernamePasswordAuthenticationToken(
						user.getUsername(), user.getPassword());
				userDetails = userDetailsService.loadUserByUsername(user.getUsername());
			} else {
				token = new UsernamePasswordAuthenticationToken(
						user.getEmail(), user.getPassword());
				userDetails = userDetailsService.loadUserByEmail(user.getEmail());
			}
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			String userToken = jwt.generateToken(userDetails);

			HashMap<String, String> jwtData = new HashMap<>();
			jwtData.put("token", userToken);

			return new ResponseEntity<HashMap<String, String>>(jwtData, HttpStatus.OK);


		} catch (Exception e) {
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
	}




}
