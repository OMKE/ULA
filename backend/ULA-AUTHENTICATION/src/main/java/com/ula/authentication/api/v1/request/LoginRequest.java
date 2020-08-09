package com.ula.authentication.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {

	@NotEmpty(message = "Username is required")
	@Size(min = 4, max = 32, message = "Username must be at least 4 charaters long")
	private String username;

	@NotEmpty(message = "Password is required")
	@Size(min = 6, max = 32, message = "Password must be at least 5 characters long")
	private String password;

}
