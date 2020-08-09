package com.ula.authentication.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResetPasswordRequest {

	@NotEmpty(message = "Reset password token is required")
	private String token;

	@NotEmpty(message = "Password is required")
	private String newPassword;

	@NotEmpty(message = "Password confirmation is required")
	private String confirmPassword;

}
