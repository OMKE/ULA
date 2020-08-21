package com.ula.authentication.service.exception;

public class RequiredFieldException extends Exception
{

	public RequiredFieldException(String message)
	{
		super(message);
	}

	public RequiredFieldException(Throwable throwable)
	{
		super(throwable);
	}
}
