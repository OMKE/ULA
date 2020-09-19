package com.ula.teacher.service.exception;

public class TakingExamNotFoundException extends Exception
{
    public TakingExamNotFoundException(String message)
    {
        super(message);
    }

    public TakingExamNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
