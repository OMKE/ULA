package com.ula.faculty.service.exception;

public class TeachingTypeNotFoundException extends Exception
{
    public TeachingTypeNotFoundException(String message)
    {
        super(message);
    }

    public TeachingTypeNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
