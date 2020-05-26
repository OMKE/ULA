package com.ula.api.v1.controller.auth;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ula.dto.response.Response;

@RestController()
@RequestMapping(path = "/test")
public class EmailVerificationController {

	@Secured("ROLE_USER")
	@GetMapping("")
	public Response<Object> test() {
		return Response.ok().setPayload("Authenticated");
	}
}
