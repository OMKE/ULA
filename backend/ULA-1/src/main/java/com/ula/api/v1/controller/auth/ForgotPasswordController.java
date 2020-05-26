package com.ula.api.v1.controller.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ula.api.v1.request.auth.ForgotPasswordRequest;
import com.ula.api.v1.request.auth.MethodArgumentExceptionResolver;
import com.ula.dto.model.PasswordResetsDTO;
import com.ula.dto.response.Response;
import com.ula.service.exception.EmailNotFoundException;
import com.ula.service.user.PasswordResetsService;

@RestController
@RequestMapping(path = "/api/v1/auth/forgotpassword")
public class ForgotPasswordController {

	@Autowired
	private PasswordResetsService passwordResetService;
	
	@PostMapping
	public Response<Object> sendEmail(
			@RequestBody @Valid ForgotPasswordRequest forgotPasswordRequest, Errors errors)
	{
		PasswordResetsDTO passwordResetsDTO = new PasswordResetsDTO()
				.setEmail(forgotPasswordRequest.getEmail());

		try
		{
			return Response.ok().setPayload(passwordResetService.sendResetEmail(passwordResetsDTO));
		} catch (EmailNotFoundException e)
		{
			return Response.wrongCredentials()
					.setErrors(MethodArgumentExceptionResolver.resolve(errors, e));
		}
	}
}
