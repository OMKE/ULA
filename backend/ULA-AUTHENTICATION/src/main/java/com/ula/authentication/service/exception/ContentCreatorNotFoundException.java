package com.ula.authentication.service.exception;

public class ContentCreatorNotFoundException extends Exception
{
    public ContentCreatorNotFoundException(String message)
    {
        super(message);
    }

    public ContentCreatorNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
