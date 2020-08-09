package com.ula.authentication.service.exception;

public class PasswordsDontMatchException extends Exception
{

	public PasswordsDontMatchException(String message)
	{
		super(message);
	}

	public PasswordsDontMatchException(Throwable throwable)
	{
		super(throwable);
	}
}
