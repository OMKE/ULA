package com.ula.authentication.api.v1.controller;


import com.ula.authentication.api.v1.request.RegisterRequest;
import com.ula.authentication.service.exception.PasswordsDontMatchException;
import com.ula.authentication.service.exception.UserConflictException;
import com.ula.authentication.service.exception.UserException;
import com.ula.authentication.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;
import org.ula.core.domain.model.UserDTO;

import javax.validation.Valid;



@RestController
@Validated
public class RegisterController extends BaseController
{

	@Autowired
	private UserService userService;


	@Autowired
	private PasswordEncoder passwordEncoder;



	@PostMapping("/register")
	public Response<Object> register
	(
			@RequestBody @Valid RegisterRequest registerRequest,
			Errors errors
	)
	{
		try {


			UserDTO userDTO = new UserDTO().setUsername(this.sanitize(registerRequest.getUsername()))
					.setEmail(this.sanitize(registerRequest.getEmail()))
					.setPassword(passwordEncoder.encode(registerRequest.getPassword()))
					.setFirstName(this.sanitize(registerRequest.getFirstName()))
					.setLastName(this.sanitize(registerRequest.getLastName()))
					.setTermsAndConditions(registerRequest.getAcceptTerms());

//			Check if password and confirmation password match
			userService.checkForPasswords(registerRequest.getPassword(), registerRequest.getConfirmPassword());
			userService.checkTermsAndConditions(registerRequest.getAcceptTerms());

//			If everything is OK, return OK response
			return Response.ok().setPayload(userService.add(userDTO));
		} catch (UserException e) {
			return Response.badRequest()
					.setErrors(e.getMessage());
		} catch (PasswordsDontMatchException e)
		{
			return Response.validationException().setErrors(e.getMessage());

		} catch (UserConflictException e) {
			return Response.exception().setErrors(e.getMessage());
		}


	}


}
