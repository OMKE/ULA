package com.ula.api.v1.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ula.dto.model.UserDTO;
import com.ula.dto.response.Response;
import com.ula.service.exception.EmailVerificationTokenException;
import com.ula.service.user.EmailVerificationService;

@RestController
@RequestMapping(path = "/api/v1/auth/verifyemail")
public class EmailVerificationController {

	@Autowired
	private EmailVerificationService emailVerificationService;

	@PreAuthorize("hasAuthority('USER')")
	@GetMapping("")
	public Response<Object> verify(
			@RequestParam("token") String token,
			Authentication authentication)
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
		System.out.println(authentication.getPrincipal().getClass());
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
