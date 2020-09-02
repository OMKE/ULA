package com.ula.faculty.service.exception;

public class SubjectRealizationNotFoundException extends Exception
{
    public SubjectRealizationNotFoundException(String message)
    {
        super(message);
    }

    public SubjectRealizationNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
