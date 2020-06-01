package com.ula.api.v1.controller.auth;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ula.api.v1.request.auth.MethodArgumentExceptionResolver;
import com.ula.api.v1.request.auth.RegisterRequest;
import com.ula.dto.model.UserDTO;
import com.ula.dto.response.Response;
import com.ula.service.exception.PasswordsDontMatchException;
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
			@RequestBody @Valid RegisterRequest registerRequest,
			Errors errors)
			throws UserException
	{

		UserDTO userDTO = new UserDTO().setUsername(registerRequest.getUsername())
				.setEmail(registerRequest.getEmail())
				.setPassword(passwordEncoder.encode(registerRequest
						.getPassword()))
				.setFirstName(
						registerRequest.getFirstName())
				.setLastName(registerRequest.getLastName());

		try {
//			Check if password and confirmation password match
			this.checkForPasswords(registerRequest);
			return Response.ok().setPayload(userService.add(userDTO));
		} catch (UserException e) {
			return Response.badRequest()
					.setErrors(MethodArgumentExceptionResolver.resolve(errors, e));
		} catch (PasswordsDontMatchException e)
		{
			return Response.validationException()
					.setErrors(MethodArgumentExceptionResolver.resolve(errors, e));
		}

		
	}

	public void checkForPasswords(RegisterRequest registerRequest)
			throws PasswordsDontMatchException
	{
		if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword()))
		{
			throw new PasswordsDontMatchException("Passwords don't match");
		}
	}
}
