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
public class ResetPasswordRequest {

	@NotEmpty(message = "Reset password token is required")
	private String token;

	@NotEmpty(message = "Password is required")
	private String newPassword;

	@NotEmpty(message = "Password confirmation is required")
	private String confirmPassword;

}
