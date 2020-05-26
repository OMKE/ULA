package com.ula.api.v1.request.auth;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ForgotPasswordRequest
{

	@NotEmpty(message = "Email is required")
	private String email;

}
