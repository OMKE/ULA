package com.ula.exam.service.exception;

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
