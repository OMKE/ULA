package com.ula.authentication.api.v1.controller;

import com.ula.authentication.api.v1.request.ForgotPasswordRequest;
import com.ula.authentication.api.v1.request.MethodArgumentExceptionResolver;
import com.ula.authentication.dto.model.PasswordResetsDTO;
import com.ula.authentication.dto.response.Response;
import com.ula.authentication.service.exception.EmailNotFoundException;
import com.ula.authentication.service.passwordreset.PasswordResetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;



@RestController
public class ForgotPasswordController {

	@Autowired
	private PasswordResetsService passwordResetService;
	
	@PostMapping("/forgotpassword")
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
