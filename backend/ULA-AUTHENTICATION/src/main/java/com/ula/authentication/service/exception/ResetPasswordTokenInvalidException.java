package com.ula.authentication.service.exception;

public class ResetPasswordTokenInvalidException extends Exception
{

	public ResetPasswordTokenInvalidException(String message)
	{
		super(message);
	}

	public ResetPasswordTokenInvalidException(Throwable throwable)
	{
		super(throwable);
	}
}
