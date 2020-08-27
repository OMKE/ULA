package com.ula.authentication.api.v1.controller;

import com.ula.authentication.service.emailverification.EmailVerificationService;
import com.ula.authentication.service.exception.EmailVerificationTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.api.response.Response;
import org.ula.core.domain.model.UserDTO;


@RestController
public class EmailVerificationController {

	@Autowired
	private EmailVerificationService emailVerificationService;

	@PreAuthorize("hasAuthority('USER')")
	@GetMapping("/verifyemail")
	public Response<Object> verify
	(
			@RequestParam("token") String token,
			Authentication authentication
	)
	{
		try
		{
			return Response.ok().setPayload(emailVerificationService.verify(token,
					new UserDTO().setUsername(authentication.getName())));
		} catch (EmailVerificationTokenException e)
		{
			return Response.validationException().setErrors(e.getMessage());
		}
	}

	@PreAuthorize("hasAuthority('USER')")
	@PostMapping("/resend")
	public Response<Object> resendToken(Authentication authentication)
	{
		try
		{
			return Response.ok()
					.setPayload(emailVerificationService.resend(authentication.getName()));
		} catch (EmailVerificationTokenException e)
		{
			return Response.exception().setErrors(e.getMessage());
		}
	}
}
