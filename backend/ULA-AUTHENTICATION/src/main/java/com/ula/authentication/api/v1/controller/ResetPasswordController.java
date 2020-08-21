package com.ula.authentication.api.v1.controller;

import com.ula.authentication.api.v1.request.ResetPasswordRequest;
import com.ula.authentication.dto.model.PasswordResetsDTO;
import com.ula.authentication.dto.response.Response;
import com.ula.authentication.service.exception.PasswordsDontMatchException;
import com.ula.authentication.service.exception.ResetPasswordTokenInvalidException;
import com.ula.authentication.service.passwordreset.PasswordResetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;



@RestController
public class ResetPasswordController
{

	@Autowired
	private PasswordResetsService passwordResetService;


	/*
	 * User will click on a link in the email and it will redirect to angular app
	 * which will get token from URL and then will form an object
	 * 
	 * @TODO - Send a token alongside URL to this app which will render a template
	 * for reseting password Password is hashed in the service after it's checked
	 * with confirmed password
	 */
	@PostMapping("/resetpassword")
	public Response<Object> resetPassword(
			@RequestBody @Valid ResetPasswordRequest resetPasswordRequest)
	{

		PasswordResetsDTO passwordResetsDTO = new PasswordResetsDTO()
				.setNewPassword(resetPasswordRequest.getNewPassword())
				.setConfirmPassword(resetPasswordRequest
						.getConfirmPassword())
				.setToken(resetPasswordRequest.getToken());

		try
		{
			return Response.ok()
					.setPayload(passwordResetService.verifyEmailToken(passwordResetsDTO));
		} catch (ResetPasswordTokenInvalidException e)
		{
			return Response.validationException().setErrors(e.getMessage());
		} catch (PasswordsDontMatchException e)
		{
			return Response.validationException().setErrors(e.getMessage());
		}


	}
}
