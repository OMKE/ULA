package com.ula.authentication.service.exception;

public class EmailNotFoundException extends Exception
{

	public EmailNotFoundException(String message)
	{
		super(message);
	}

	public EmailNotFoundException(Throwable throwable)
	{
		super(throwable);
	}
}
