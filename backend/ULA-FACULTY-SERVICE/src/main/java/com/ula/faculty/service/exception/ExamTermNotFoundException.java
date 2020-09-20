package com.ula.faculty.service.exception;

public class ExamTermNotFoundException extends Exception
{
    public ExamTermNotFoundException(String message)
    {
        super(message);
    }

    public ExamTermNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
