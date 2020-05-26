package com.ula.api.v1.request.auth;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class LoginRequest {

	@NotEmpty(message = "Username is required")
	@Size(min = 4, max = 32, message = "Username must be at least 4 charaters long")
	private String username;

	@NotEmpty(message = "Password is required")
	@Size(min = 6, max = 32, message = "Password must be at least 5 characters long")
	private String password;

}
