package com.ula.api.v1.controller.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ula.api.v1.request.auth.LoginRequest;
import com.ula.api.v1.request.auth.MethodArgumentExceptionResolver;
import com.ula.dto.model.UserDTO;
import com.ula.dto.response.Response;
import com.ula.service.exception.UserException;
import com.ula.service.user.UserService;

@RestController
@RequestMapping("/api/v1/auth/login")
public class LoginController {


	@Autowired
	private UserService userService;



	@PostMapping
	public Response<Object> login(
			@RequestBody @Valid LoginRequest loginRequest, Errors errors)
	{

		UserDTO userDTO = new UserDTO().setUsername(loginRequest.getUsername())
				.setPassword(loginRequest.getPassword());

		try {
			return Response.ok().setPayload(userService.login(userDTO));
		} catch (UserException e)
		{
			return Response.wrongCredentials()
					.setErrors(MethodArgumentExceptionResolver.resolve(errors, e));
		}
	}

}
