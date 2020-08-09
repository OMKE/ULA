package com.ula.authentication.service.exception;

public class EmailVerificationTokenException extends Exception
{

	public EmailVerificationTokenException(String message)
	{
		super(message);
	}

	public EmailVerificationTokenException(Throwable throwable)
	{
		super(throwable);
	}
}
