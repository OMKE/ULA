package com.ula.teacher.service.exception;

public class SubjectWithRealizationIdNotFoundException extends Exception
{
    public SubjectWithRealizationIdNotFoundException(String message)
    {
        super(message);
    }

    public SubjectWithRealizationIdNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
