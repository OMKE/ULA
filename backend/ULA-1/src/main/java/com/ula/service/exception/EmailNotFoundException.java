package com.ula.service.exception;

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
