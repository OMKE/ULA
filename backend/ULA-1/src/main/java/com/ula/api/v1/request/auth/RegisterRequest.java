package com.ula.api.v1.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRequest {

	@NotEmpty(message = "Username is required")
	@Size(min = 4, max = 32, message = "Username must be at least 5 characters long")
	private String username;

	@NotEmpty(message = "Password is required")
	@Size(min = 6, max = 32, message = "Password must be at least 5 characters long")
	private String password;

	@NotEmpty(message = "Password confirmation is required")
	@Size(min = 6, max = 32, message = "Confirmation password must be at least 5 characters long")
	private String confirmPassword;

	@NotEmpty(message = "Email is required")
	@Email(message = "Email must be valid")
	private String email;

	@Size(min = 3, max = 64, message = "First name must be at least 3 characters long")
	@NotEmpty(message = "First name is required")
	private String firstName;

	@Size(min = 3, max = 64, message = "Last name must be at least 3 characters long")
	@NotEmpty(message = "Last name is required")
	private String lastName;

	@NotEmpty(message = "Accepting Terms and Conditions is required")
	@Size(min = 4, max = 5, message = "Value must be either true or false")
	private String acceptTerms;
}
