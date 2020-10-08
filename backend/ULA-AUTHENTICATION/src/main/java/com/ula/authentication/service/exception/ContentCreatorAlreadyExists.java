package com.ula.authentication.service.exception;

public class ContentCreatorAlreadyExists extends Exception
{
    public ContentCreatorAlreadyExists(String message)
    {
        super(message);
    }

    public ContentCreatorAlreadyExists(Throwable throwable)
    {
        super(throwable);
    }
}
