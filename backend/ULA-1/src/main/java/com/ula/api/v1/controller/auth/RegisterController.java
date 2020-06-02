package com.ula.api.v1.controller.auth;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ula.api.v1.request.MethodArgumentExceptionResolver;
import com.ula.api.v1.request.auth.RegisterRequest;
import com.ula.dto.model.UserDTO;
import com.ula.dto.response.Response;
import com.ula.service.exception.PasswordsDontMatchException;
import com.ula.service.exception.RequiredFieldException;
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
	{
		try {
			MethodArgumentExceptionResolver.checkFields(registerRequest,
					registerRequest.getUsername(), registerRequest.getPassword(),
					registerRequest.getEmail(), registerRequest.getFirstName(),
					registerRequest.getLastName(), registerRequest.getAcceptTerms());

			UserDTO userDTO = new UserDTO().setUsername(registerRequest.getUsername())
					.setEmail(registerRequest.getEmail())
					.setPassword(passwordEncoder.encode(registerRequest.getPassword()))
					.setFirstName(registerRequest.getFirstName())
					.setLastName(registerRequest.getLastName())
					.setTermsAndConditions(registerRequest.getAcceptTerms());

//			Check if password and confirmation password match
userService.checkForPasswords(registerRequest.getPassword(), registerRequest.getConfirmPassword());
userService.checkTermsAndConditions(registerRequest.getAcceptTerms());

//			If everything is OK, return OK response
			return Response.ok().setPayload(userService.add(userDTO));
		} catch (UserException e) {
			return Response.badRequest()
					.setErrors(MethodArgumentExceptionResolver.resolve(errors, e));
		} catch (PasswordsDontMatchException e)
		{
			return Response.validationException()
					.setErrors(MethodArgumentExceptionResolver.resolve(errors, e));
		} catch (RequiredFieldException e)
		{
			return Response.badRequest()
					.setErrors(MethodArgumentExceptionResolver.resolve(errors));
		}

		
	}


}
