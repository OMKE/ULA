package com.ula.security;

public class SecurityConstants {

	public static final long EXPIRATION_TIME = 864_000_000;
	// In days
	public static final long RESET_PASSWORD_EXP_TIME = 5;
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/api/v1/auth/register";
	public static final String SIGN_IN_URL = "/api/v1/auth/login";
	public static final String LOGOUT_URL = "/api/v1/auth/logout";
}
