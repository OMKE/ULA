package com.ula.research.service.exception;

public class AuthorNotFoundException extends Exception
{
    public AuthorNotFoundException(String message)
    {
        super(message);
    }

    public AuthorNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
