package com.ula.api.v1.controller.auth;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ula.api.v1.request.auth.RegisterRequest;
import com.ula.dto.model.UserDTO;
import com.ula.dto.response.Response;
import com.ula.service.exception.UserException;
import com.ula.service.user.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/auth/register")
public class RegisterController {

	@Autowired
	private UserServiceImpl userService;


	@Autowired
	private PasswordEncoder passwordEncoder;



	@PostMapping
	public Response<Object> register(
			@RequestBody @Valid RegisterRequest registerRequest)
			throws UserException {

		UserDTO userDTO = new UserDTO().setUsername(registerRequest.getUsername())
				.setEmail(registerRequest.getEmail())
				.setPassword(passwordEncoder.encode(registerRequest.getPassword()))
				.setFirstName(
						registerRequest.getFirstName())
				.setLastName(registerRequest.getLastName());

		try {
			userService.add(userDTO);
			return Response.ok();
		} catch (UserException e) {
			return Response.badRequest().setErrors(e.getMessage());
		}

		
	}
}
